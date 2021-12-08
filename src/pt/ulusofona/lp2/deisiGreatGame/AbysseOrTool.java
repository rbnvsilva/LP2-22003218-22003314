package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public abstract class AbysseOrTool {
    protected String title;
    protected int type, pos;

    protected AbysseOrTool(int type, int pos) {
        this.type = type;
        this.pos = pos;
    }
    protected int getPos() {
        return pos;
    }

    protected String getTitle() {
        return title;
    }

    protected abstract String getImage();

    protected abstract String message();
    protected boolean comparePos(int pos){
        return this.pos == pos;
    }
    protected abstract void react(Programmer programmer, List<Programmer> programmers, int size);
}
