package Uno3_0;

public class Card {

    public enum Tipo { NUMERO, SALTO, REVERSA, ROBA2, ROBA4, COMODIN }

    private String color;
    private Tipo tipo;
    private int numero;

    public Card(String color, int numero) {
        this.color = color;
        this.numero = numero;
        this.tipo = Tipo.NUMERO;
    }

    public Card(String color, Tipo tipo) {
        this.color = color;
        this.tipo = tipo;
        this.numero = -1;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Tipo getTipo() { return tipo; }
    public int getNumero() { return numero; }

    public boolean esJugableSobre(Card otra) {
        if (otra == null) return true;

        if (tipo == Tipo.COMODIN || tipo == Tipo.ROBA4) return true;

        if (color.equals(otra.color)) return true;

        if (tipo == Tipo.NUMERO && otra.tipo == Tipo.NUMERO) {
            return numero == otra.numero;
        }

        return tipo == otra.tipo;
    }

    @Override
    public String toString() {
        return (tipo == Tipo.NUMERO) ? color + " " + numero : color + " " + tipo;
    }
}