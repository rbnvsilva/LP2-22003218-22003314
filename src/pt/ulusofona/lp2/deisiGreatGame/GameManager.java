package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GameManager {
    private int size, idTurn, nTurns;
    private ArrayList<Programmer> programmers;
    private ArrayList<AbysseOrTool> abyssesOrTools;

    public GameManager() {
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize) {
        nTurns = 1;
        programmers = new ArrayList<>();
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
                programmers.add(new Programmer(Integer.parseInt(info[0]), info[1], info[2], color));
                color = null;
            }
        }
        programmers.sort(Comparator.comparing(Programmer -> Programmer.getId()));
        idTurn = programmers.get(0).getId();
        return true;
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) {
        if (!createInitialBoard(playerInfo, worldSize)) {
            return false;
        }

        abyssesOrTools = new ArrayList<>();
        if (abyssesAndTools != null) {
            for (String[] abysseOrToolArray : abyssesAndTools) {
                if ((Integer.parseInt(abysseOrToolArray[0]) > 1) || (Integer.parseInt(abysseOrToolArray[0]) < 0)) {
                    return false;
                } else {
                    if (abysseOrToolArray[0].equals("0")) {
                        if ((Integer.parseInt(abysseOrToolArray[1]) > 9) || (Integer.parseInt(abysseOrToolArray[1]) < 0)) {
                            return false;
                        } else {
                            if ((Integer.parseInt(abysseOrToolArray[2]) < 1) || (Integer.parseInt(abysseOrToolArray[2]) > worldSize)) {
                                return false;
                            } else {
                                abyssesOrTools.add(new Abysse(Integer.parseInt(abysseOrToolArray[1]), Integer.parseInt(abysseOrToolArray[2])));
                            }
                        }
                    } else if (abysseOrToolArray[0].equals("1")) {
                        if ((Integer.parseInt(abysseOrToolArray[1]) > 5) || (Integer.parseInt(abysseOrToolArray[1]) < 0)) {
                            return false;
                        } else {
                            if ((Integer.parseInt(abysseOrToolArray[2]) < 1) || (Integer.parseInt(abysseOrToolArray[2]) > worldSize)) {
                                return false;
                            } else {
                                abyssesOrTools.add(new Tool(Integer.parseInt(abysseOrToolArray[1]), Integer.parseInt(abysseOrToolArray[2])));
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public String getImagePng(int position) {
        if (position < 1 || position > size) {
            return null;
        }

        for (Programmer programmer : programmers) {
            if (programmer.getPos() == position) {
                programmer.getImage();
            }
        }

        if (position == size) {
            return "glory.png";
        }

        for (AbysseOrTool abysseOrTool : abyssesOrTools) {
            if (abysseOrTool.comparePos(position)) {
                return abysseOrTool.getImage();
            }
        }
        return null;
    }

    public String getTitle(int position) {
        if (position > size) {
            return null;
        }

        for (AbysseOrTool abysseOrTool : abyssesOrTools) {
            if (abysseOrTool.comparePos(position)) {
                return abysseOrTool.getTitle();
            }
        }
        return null;
    }

    public List<Programmer> getProgrammers(boolean includeDefeated) {
        ArrayList<Programmer> inGame = new ArrayList<>();
        if (includeDefeated) {
            return programmers;
        }

        for (Programmer programmer : programmers) {
            if (programmer.getGameState().equals("Em Jogo")) {
                inGame.add(programmer);
            }
        }

        return inGame;
    }

    public List<Programmer> getProgrammers(int position) {
        ArrayList<Programmer> valid = new ArrayList<>();
        for (Programmer programmer : programmers) {
            if (programmer.getPos() == position) {
                valid.add(programmer);
            }
        }

        if (valid.size() == 0) {
            return null;
        }

        return valid;
    }

    public String getProgrammersInfo() {
        StringBuilder info = new StringBuilder();
        int j = 0;
        for (Programmer programmer : programmers) {
            StringBuilder tools = new StringBuilder();
            int i = 0;
            for (String tool : programmer.getTools()) {
                if (i == programmer.getTools().size() - 1) {
                    tools.append(tool);
                } else {
                    tools.append(tool).append("; ");
                }
                i++;
            }
            if (j == programmers.size() - 1) {
                if (!programmer.getGameState().equals("Derrotado")) {
                    if (programmer.getTools().size() == 0) {
                        info.append(programmer.getName()).append(" : No tools");
                    } else {
                        info.append(programmer.getName()).append(" : ").append(tools);
                    }
                }

            } else {
                if (!programmer.getGameState().equals("Derrotado")) {
                    if (programmer.getTools().size() == 0) {
                        info.append(programmer.getName()).append(" : No tools").append(" | ");
                    } else {
                        info.append(programmer.getName()).append(" : ").append(tools).append(" | ");
                    }
                }
            }
            j++;
        }
        return info.toString();
    }

    public int getCurrentPlayerID() {
        return idTurn;
    }

    public boolean moveCurrentPlayer(int nrPositions) {
        if (nrPositions < 1 || nrPositions > 6) {
            return false;
        }
        for (Programmer programmer : getProgrammers(false)) {
            if (programmer.getId() == idTurn) {
                if (programmer.podeMover()) {
                    programmer.getOldPos().add(programmer.getPos());
                    programmer.move(nrPositions, size);
                    return true;
                }
            }
        }
        return false;
    }

    public String reactToAbyssOrTool() {
        StringBuilder message = new StringBuilder();
        for (Programmer programmer : getProgrammers(false)) {
            if (programmer.getId() == idTurn) {
                if (abyssesOrTools != null) {
                    for (AbysseOrTool abysseOrTool : abyssesOrTools) {
                        if (abysseOrTool.comparePos(programmer.getPos())) {
                            message.append(abysseOrTool.message());
                            abysseOrTool.react(programmer, getProgrammers(false), size);
                        }
                    }
                }
            }
        }

        nTurns++;
        for (Programmer programmer : getProgrammers(false)) {

            if (programmer.getId() > idTurn) {
                idTurn = programmer.getId();
                if (message.toString().equals("")) {
                    return null;
                } else {
                    return message.toString();
                }
            }
        }

        idTurn = getProgrammers(false).get(0).getId();
        if (message.toString().equals("")) {
            return null;
        } else {
            return message.toString();
        }
    }

    public boolean gameIsOver() {
        if (getProgrammers(false).size() < 2) {
            return true;
        }
        for (Programmer programmer : getProgrammers(false)) {
            if (programmer.getPos() == size) {
                for (Programmer programmers : programmers) {
                    programmers.setGameState("Derrotado");
                }
                programmer.setGameState("Em Jogo");
                return true;
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
        for (Programmer programmer : programmers) {
            if (programmer.getGameState().equals("Em Jogo")) {
                results.add(programmer.getName());
                results.add("");
            }
        }
        results.add("RESTANTES");
        Comparator<Programmer> compare = Comparator.comparing(Programmer::getPos).reversed().thenComparing(Programmer::getName);
        programmers.sort(compare);
        for (Programmer programmer : programmers) {
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
