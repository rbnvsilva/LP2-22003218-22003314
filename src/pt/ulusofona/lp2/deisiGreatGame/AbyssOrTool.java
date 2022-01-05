package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public abstract class AbyssOrTool {
    protected String title;
    protected int type, pos;

    protected AbyssOrTool(int type, int pos) {
        this.type = type;
        this.pos = pos;
    }

    protected int getNumeroPisadelas() {
        return -1;
    }

    protected int getPos() {
        return pos;
    }

    protected String getTitle() {
        return title;
    }

    protected int getType() {
        return type;
    }

    protected abstract String getImage();

    protected abstract String message();

    protected boolean comparePos(int pos) {
        return this.pos == pos;
    }

    protected abstract void react(Programmer programmer, List<Programmer> programmers, int size);
}
