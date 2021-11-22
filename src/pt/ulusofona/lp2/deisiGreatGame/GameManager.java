package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GameManager {
    int size, idTurn, nTurns;
    ArrayList<Programmer> players;
    ArrayList<Abysse> abysses;
    ArrayList<Tool> tools;

    public GameManager() {

    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize) {
        nTurns = 1;
        players = new ArrayList<>();
        HashSet<Integer> ids = new HashSet<>();
        HashSet<ProgrammerColor> colors = new HashSet<>();
        ProgrammerColor color = null;
        size = worldSize;

        if (playerInfo.length > 4 || playerInfo.length < 2 || worldSize < playerInfo.length * 2) {
            return false;
        } else {
            for (String[] info : playerInfo) {
                if (info[0] != null && (info[1] != null && !info[1].equals(""))
                        && info[2] != null && info[3] != null) {
                    if (Integer.parseInt(info[0]) <= 0) {
                        return false;
                    }
                    if (ids.contains(Integer.parseInt(info[0]))) {
                        return false;
                    } else {
                        ids.add(Integer.parseInt(info[0]));
                    }
                    if (info[3].equals("Purple") || info[3].equals("Blue")
                            || info[3].equals("Green") || info[3].equals("Brown")) {
                        if (info[3].equals("Purple")) {
                            color = ProgrammerColor.PURPLE;
                        } else if (info[3].equals("Blue")) {
                            color = ProgrammerColor.BLUE;
                        } else if (info[3].equals("Green")) {
                            color = ProgrammerColor.GREEN;
                        } else {
                            color = ProgrammerColor.BROWN;
                        }
                        if (colors.contains(color)) {
                            return false;
                        } else {
                            colors.add(color);
                        }
                    }
                }
                players.add(new Programmer(Integer.parseInt(info[0]), info[1], info[2], color));
                color = null;
            }
        }
        players.sort(Comparator.comparing(Programmer -> Programmer.getId()));
        idTurn = players.get(0).getId();
        return true;
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) {
        //TODO fazer classe com abismo e tools ao mm tempo

        if (!createInitialBoard(playerInfo, worldSize)) {
            return false;
        }

        abysses = new ArrayList<>();
        tools = new ArrayList<>();

        if (abyssesAndTools != null) {
            for (String[] abysseOrToolArray : abyssesAndTools) {
                if (abysseOrToolArray[0].equals("0")) {
                    if ((!(Integer.parseInt(abysseOrToolArray[1]) > 9 || Integer.parseInt(abysseOrToolArray[1]) < 0))
                            && ((Integer.parseInt(abysseOrToolArray[2]) > 0) && (Integer.parseInt(abysseOrToolArray[2]) < worldSize))) {
                        abysses.add(new Abysse(Integer.parseInt(abysseOrToolArray[1]), Integer.parseInt(abysseOrToolArray[2])));
                    }
                } else if (abysseOrToolArray[0].equals("1")) {
                    if ((!(Integer.parseInt(abysseOrToolArray[1]) > 5 || Integer.parseInt(abysseOrToolArray[1]) < 0))
                            && ((Integer.parseInt(abysseOrToolArray[2]) > 0) && (Integer.parseInt(abysseOrToolArray[2]) < worldSize))) {
                        tools.add(new Tool(Integer.parseInt(abysseOrToolArray[1]), Integer.parseInt(abysseOrToolArray[2])));
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public String getImagePng(int position) {
        if (position < 1 || position > size) {
            return null;
        }

        if (position == 1) {
            return "blank.png";
        }

        if (position == size) {
            return "glory.png";
        }

        for (int i = 2; i <= size; i++) {

        }

        return "";
    }

    public String getTitle(int position) {
        if (position > size) {
            return null;
        }

        for (Abysse abysse : abysses) {
            if (abysse.getPos() == position) {
                return abysse.getTitle();
            }
        }

        for (Tool tool : tools) {
            if (tool.getPos() == position) {
                return tool.getTitle();
            }
        }
        return null;
    }

    List<Programmer> getProgrammers(boolean includeDefeated) {
        return new ArrayList<>();
    }

    public ArrayList<Programmer> getProgrammers() {
        return players;
    }

    List<Programmer> getProgrammers(int position) {
        ArrayList<Programmer> valid = new ArrayList<>();
        for (Programmer programmer : players) {
            if (programmer.getPos() == position) {
                valid.add(programmer);
            }
        }

        if (valid.size() == 0) {
            return null;
        }
        return valid;
    }

    String getProgrammersInfo() {
        return "";
    }

    public int getCurrentPlayerID() {
        return idTurn;
    }

    public boolean moveCurrentPlayer(int nrPositions) {
        if (nrPositions < 1 || nrPositions > 6) {
            return false;
        }
        for (Programmer programmer : players) {
            if (programmer.getId() == idTurn) {
                programmer.move(nrPositions, size);
                nTurns++;
                if (programmer.getPos() == size) {
                    return true;
                }
            }
        }
        for (Programmer programmer : players) {
            if (programmer.getId() > idTurn) {
                idTurn = programmer.getId();
                return true;
            }
        }
        idTurn = players.get(0).getId();
        return true;
    }

    public String reactToAbyssOrTool() {
        return "";
    }

    public boolean gameIsOver() {
        for (Programmer programmer : players) {
            if (programmer.getId() == idTurn) {
                if (programmer.getPos() == size) {
                    for (Programmer programmers : players) {
                        if (!(programmers.getId() == idTurn)) {
                            programmers.setGameState("Derrotado");
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getGameResults() {
        ArrayList<String> results = new ArrayList<>();
        results.add("O GRANDE JOGO DO DEISI");
        results.add("");
        results.add("NR. DE TURNOS");
        results.add(nTurns + "");
        results.add("");
        results.add("VENCEDOR");
        for (Programmer programmer : players) {
            if (programmer.getGameState().equals("Em Jogo")) {
                results.add(programmer.getName());
                results.add("");
            }
        }
        results.add("RESTANTES");
        players.sort(Comparator.comparing(Programmer -> Programmer.getPos()));
        Collections.reverse(players);
        for (Programmer programmer : players) {
            if (!programmer.getGameState().equals("Em Jogo")) {
                results.add(programmer.getName() + " " + programmer.getPos());
            }
        }
        return results;
    }

    public JPanel getAuthorsPanel() {
        JPanel panel = new JPanel();
        JLabel jLabel = new JLabel("Simao Bento 22003314\n");
        JLabel jLabel1 = new JLabel("Ruben Silva 22003218\n");
        panel.add(jLabel, BorderLayout.NORTH);
        panel.add(jLabel1, BorderLayout.CENTER);
        panel.setVisible(true);
        return panel;
    }
}
