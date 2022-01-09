package pt.ulusofona.lp2.deisiGreatGame;

import java.io.Serializable;

public class Position implements Serializable {
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
