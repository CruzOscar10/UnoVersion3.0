package Uno3_0;

import java.util.*;

public class Game {

    private Deck deck = new Deck();
    private List<Player> jugadores = new ArrayList<>();
    private int turnoActual = 0;
    private int direccion = 1;
    private Card cartaMesa;
    private Scanner scanner = new Scanner(System.in);

    private String obtenerDireccionVisual() {
        return (direccion == 1) ? "⬇️" : "⬆️";
    }

    private void pausa(int ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public void iniciar() {
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();

        jugadores.add(new Player(nombre, true));
        jugadores.add(new Player("Pepe", false));
        jugadores.add(new Player("Toña", false));
        jugadores.add(new Player("Mari", false));

        repartir();

        do {
            cartaMesa = deck.robarCarta();
        } while (cartaMesa.getTipo() != Card.Tipo.NUMERO || cartaMesa.getColor().equals("negro"));

        while (true) {

            Player actual = jugadores.get(turnoActual);

            System.out.println("\n=================================");
            System.out.println("Dirección: " + obtenerDireccionVisual());
            System.out.println("Turno de: " + actual.getNombre());
            System.out.println("Carta en mesa: " + cartaMesa);

            mostrarResumen();

            actual.jugarTurno(this);

            pausa(actual.esHumano() ? 1500 : 2500);

            if (actual.getMano().size() == 1 && !actual.dijoUno()) {
                System.out.println("⚠️ " + actual.getNombre() + " no dijo UNO. Roba 2 cartas!");
                actual.robarCarta(deck);
                actual.robarCarta(deck);
            }

            if (actual.getMano().estaVacia()) {
                System.out.println("" + actual.getNombre() + " ha ganado!");
                break;
            }

            avanzarTurno();
        }
    }

    private void repartir() {
        for (int i = 0; i < 7; i++) { 
            for (Player p : jugadores) {
                p.robarCarta(deck);
            }
        }
    }

    public void avanzarTurno() {
        turnoActual = (turnoActual + direccion + jugadores.size()) % jugadores.size();
    }

    public Player siguienteJugador() {
        int i = (turnoActual + direccion + jugadores.size()) % jugadores.size();
        return jugadores.get(i);
    }

    public void aplicarEfecto(Card carta, Player jugadorActual) {

        switch (carta.getTipo()) {

            case SALTO:
                avanzarTurno();
                break;

            case REVERSA:
                direccion *= -1;
                break;

            case ROBA2:
                Player sig = siguienteJugador();
                sig.robarCarta(deck);
                sig.robarCarta(deck);
                avanzarTurno();
                break;

            case ROBA4:
                Player sig2 = siguienteJugador();
                for (int i = 0; i < 4; i++) sig2.robarCarta(deck);
                avanzarTurno();
                elegirColor(jugadorActual);
                break;

            case COMODIN:
                elegirColor(jugadorActual);
                break;
            default:
            	break;
        }
    }

    private void elegirColor(Player jugador) {

        if (jugador.esHumano()) {
            String color;

            while (true) {
                System.out.print("Elige color (rojo, azul, verde, amarillo): ");
                color = scanner.nextLine().trim().toLowerCase();

                if (color.matches("rojo|azul|verde|amarillo")) break;

                System.out.println("❌ Color inválido.");
            }

            cartaMesa.setColor(color);

        } else {
            String color = jugador.elegirColorIA();
            System.out.println(jugador.getNombre() + " elige color: " + color);
            cartaMesa.setColor(color);
        }
    }

    public void mostrarEstado(Player p) {
        System.out.println("Tus cartas:");
        p.getMano().mostrarMano();
    }

    private void mostrarResumen() {
        System.out.println("\nJugadores:");
        for (Player p : jugadores) {
            System.out.println("- " + p.getNombre() + " (" + p.getMano().size() + " cartas)");
        }
    }

    public Card getCartaMesa() { return cartaMesa; }
    public void setCartaMesa(Card c) { cartaMesa = c; }
    public Deck getDeck() { return deck; }
    public Scanner getScanner() { return scanner; }
}