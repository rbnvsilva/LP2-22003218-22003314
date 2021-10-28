package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Collections;

public class Programmer {
    int id, pos;
    String name, gameState, favLanguages;
    ProgrammerColor color;

    public Programmer(int id, String name, String favLanguages, ProgrammerColor color) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.favLanguages = favLanguages;
        this.pos = 1;
        this.gameState = "Em Jogo";
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

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
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
