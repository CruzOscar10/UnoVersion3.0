package Uno3_0;

import java.util.*;

public class Hand {

    private List<Card> cartas = new ArrayList<>();

    public void agregarCarta(Card c) {
        if (c != null) cartas.add(c);
    }

    public Card jugarCarta(int index) {
        if (index < 0 || index >= cartas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        return cartas.remove(index);
    }

    public boolean tieneJugadaValida(Card mesa) {
        return cartas.stream().anyMatch(c -> c.esJugableSobre(mesa));
    }

    public Card obtenerPrimeraValida(Card mesa) {
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).esJugableSobre(mesa)) {
                return cartas.remove(i);
            }
        }
        return null;
    }

    public void mostrarMano() {
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println("[" + i + "] " + cartas.get(i));
        }
    }

    public int size() { return cartas.size(); }
    public boolean estaVacia() { return cartas.isEmpty(); }
}