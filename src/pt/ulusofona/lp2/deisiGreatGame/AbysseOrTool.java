package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public abstract class AbysseOrTool {
    String title;
    int type, pos;

    public AbysseOrTool(int type, int pos) {
        this.type = type;
        this.pos = pos;
    }
    public int getPos() {
        return pos;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return "";
    }

    public String message() {
       return "";
    }
    public boolean comparePos(int pos){
        return this.pos == pos;
    }
    public void react(Programmer programmer, List<Programmer> programmers, int size) {
    }
}
