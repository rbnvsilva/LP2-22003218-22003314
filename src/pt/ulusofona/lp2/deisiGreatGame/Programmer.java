package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Programmer {
    int id, pos;
    String name, gameState, favLanguages;
    ProgrammerColor color;
    HashSet<String> tools;
    ArrayList<Integer> oldPos;
    boolean podeMover = true;

    public Programmer(int id, String name, String favLanguages, ProgrammerColor color) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.favLanguages = favLanguages;
        this.pos = 1;
        this.gameState = "Em Jogo";
        this.tools = new HashSet<>();
        this.oldPos = new ArrayList<>();
    }

    public String getGameState() {
        return this.gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public int getId() {
        return id;
    }

    public HashSet<String> getTools() {
        return tools;
    }
    public String getName() {
        return name;
    }

    public void setPos(int value) {
        pos = value;
    }

    public int getPos() {
        return pos;
    }

    public ArrayList<Integer> getOldPos() {
        return oldPos;
    }

    public void setPodeMover(boolean podeMover) {
        this.podeMover = podeMover;
    }

    public boolean podeMover(){
        return podeMover;
    }

    public ProgrammerColor getColor() {
        return this.color;
    }

    public void move(int value, int size) {
        int excess;
        if (value + pos < 1) {
            pos = 1;
        } else if (value + pos > size) {
            excess = size - (value + pos);
            pos = size + excess;
        } else {
            pos += value;
        }
    }

    @Override
    public String toString() {
        ArrayList<String> listFavLanguages = new ArrayList<>();
        Collections.addAll(listFavLanguages, favLanguages.split(";"));
        Collections.sort(listFavLanguages);

        StringBuilder languages = new StringBuilder();
        for (int i = 0; i < listFavLanguages.size(); i++) {
            if (i != listFavLanguages.size() - 1) {
                languages.append(listFavLanguages.get(i).trim()).append("; ");
            } else {
                languages.append(listFavLanguages.get(i).trim());
            }
        }
        return id + " | " + name + " | " + pos + " | " + languages + " | " + gameState;
    }
}
