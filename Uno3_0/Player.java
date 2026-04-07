package Uno3_0;

import java.util.Random;

public class Player {

    private String nombre;
    private Hand mano;
    private boolean esHumano;
    private boolean dijoUno = false;
    private Random random = new Random();

    public Player(String nombre, boolean esHumano) {
        this.nombre = nombre;
        this.esHumano = esHumano;
        this.mano = new Hand();
    }

    public String getNombre() { return nombre; }
    public Hand getMano() { return mano; }

    public boolean dijoUno() { return dijoUno; }

    public void robarCarta(Deck deck) {
        mano.agregarCarta(deck.robarCarta());
    }

    public void jugarTurno(Game game) {
        dijoUno = false;
        if (esHumano) turnoHumano(game);
        else turnoIA(game);
    }

    private void turnoHumano(Game game) {

        game.mostrarEstado(this);

        if (!mano.tieneJugadaValida(game.getCartaMesa())) {
            System.out.println("No tienes jugada válida. Robas carta.");
            robarCarta(game.getDeck());
            return;
        }

        while (true) {
            try {
                System.out.print("Elige carta: ");
                int opcion = Integer.parseInt(game.getScanner().nextLine());

                Card carta = mano.jugarCarta(opcion);

                if (!carta.esJugableSobre(game.getCartaMesa())) {
                    System.out.println("❌ Movimiento inválido.");
                    mano.agregarCarta(carta);
                    continue;
                }

                jugarCartaEnMesa(game, carta);

                if (mano.size() == 1) {
                    System.out.print("¿Decir UNO? (s/n): ");
                    if (game.getScanner().nextLine().equalsIgnoreCase("s")) {
                        dijoUno = true;
                        System.out.println("UNO!");
                    }
                }

                break;

            } catch (Exception e) {
                System.out.println("❌ Entrada inválida.");
            }
        }
    }

    private void turnoIA(Game game) {

        Card carta = mano.obtenerPrimeraValida(game.getCartaMesa());

        if (carta != null) {
            System.out.println(nombre + " juega: " + carta);
            jugarCartaEnMesa(game, carta);

            if (mano.size() == 1) {
                dijoUno = true;
                System.out.println(nombre + " dice: ¡UNO!");
            }
            return;
        }

        Card robada = game.getDeck().robarCarta();
        mano.agregarCarta(robada);

        System.out.println(nombre + " roba carta.");

        if (robada.esJugableSobre(game.getCartaMesa())) {
            System.out.println(nombre + " juega: " + robada);
            mano.jugarCarta(mano.size() - 1);
            jugarCartaEnMesa(game, robada);

            if (mano.size() == 1) {
                dijoUno = true;
                System.out.println(nombre + " dice: ¡UNO!");
            }
        }
    }

    private void jugarCartaEnMesa(Game game, Card carta) {
        game.setCartaMesa(carta);
        game.aplicarEfecto(carta, this);
    }

    public boolean esHumano() { return esHumano; }

    public String elegirColorIA() {
        String[] colores = {"rojo", "azul", "verde", "amarillo"};
        return colores[random.nextInt(colores.length)];
    }
}