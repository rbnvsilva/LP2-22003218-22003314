package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Programmer {
    private int id, pos;
    private String name, gameState, favLanguages;
    private ProgrammerColor color;
    private HashSet<String> tools;
    private ArrayList<Integer> oldPos;
    private boolean podeMover = true;

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

    public int getPos() {
        return pos;
    }

    public void setPos(int value) {
        pos = value;
    }

    public ArrayList<Integer> getOldPos() {
        return oldPos;
    }

    public void setPodeMover(boolean podeMover) {
        this.podeMover = podeMover;
    }

    public boolean podeMover() {return this.podeMover;}

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
        ArrayList<String> toolsArray = new ArrayList<>(tools);

        StringBuilder toolsString = new StringBuilder();
        for (int i = 0; i < toolsArray.size(); i++) {
            if (i != toolsArray.size() - 1) {
                toolsString.append(toolsArray.get(i).trim()).append("; ");
            } else {
                toolsString.append(toolsArray.get(i).trim());
            }
        }

        if (toolsArray.size() == 0) {
            return id + " | " + name + " | " + pos + " | No tools" + " | " + languages + " | " + gameState;
        } else {
            return id + " | " + name + " | " + pos + " | " + toolsString + " | " + languages + " | " + gameState;
        }
    }
}
