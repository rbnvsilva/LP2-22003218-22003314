package pt.ulusofona.lp2.deisiGreatGame;

public class Position {
    int numeroPisadelas, casa;

    public Position(int casa, int numeroPisadelas) {
        this.casa = casa;
        this.numeroPisadelas = numeroPisadelas;
    }

    public int getNumeroPisadelas() {
        return numeroPisadelas;
    }

    public int getCasa() {
        return casa;
    }

    public void incrementaPisadelas() {
        numeroPisadelas++;
    }
}
