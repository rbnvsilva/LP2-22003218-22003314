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
    ArrayList<Programmer> programmers;
    ArrayList<Abysse> abysses;
    ArrayList<Tool> tools;

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
        //TODO fazer classe com abismo e tools ao mm tempo

        if (!createInitialBoard(playerInfo, worldSize)) {
            return false;
        }

        abysses = new ArrayList<>();
        tools = new ArrayList<>();

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
                                abysses.add(new Abysse(Integer.parseInt(abysseOrToolArray[1]), Integer.parseInt(abysseOrToolArray[2])));
                            }
                        }
                    } else if (abysseOrToolArray[0].equals("1")) {
                        if ((Integer.parseInt(abysseOrToolArray[1]) > 5) || (Integer.parseInt(abysseOrToolArray[1]) < 0)) {
                            return false;
                        } else {
                            if ((Integer.parseInt(abysseOrToolArray[2]) < 1) || (Integer.parseInt(abysseOrToolArray[2]) > worldSize)) {
                                return false;
                            } else {
                                tools.add(new Tool(Integer.parseInt(abysseOrToolArray[1]), Integer.parseInt(abysseOrToolArray[2])));
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

        if (position == size) {
            return "glory.png";
        }

        for (Abysse abysse : abysses) {
            if (abysse.getPos() == position) {
                return abysse.getImage();
            }
        }

        for (Tool tool : tools) {
            if (tool.getPos() == position) {
                return tool.getImage();
            }
        }

        return null;
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
            for (String tool : programmer.tools) {
                if (i == programmer.tools.size() - 1) {
                    tools.append(tool);
                } else {
                    tools.append(tool).append("; ");
                }
                i++;
            }
            if (j == programmers.size() - 1) {
                if (programmer.tools.size() == 0) {
                    info.append(programmer.getName()).append(" : No tools");
                } else {
                    info.append(programmer.getName()).append(" : ").append(tools);
                }
            } else {
                if (programmer.tools.size() == 0) {
                    info.append(programmer.getName()).append(" : No tools").append(" | ");
                } else {
                    info.append(programmer.getName()).append(" : ").append(tools).append(" | ");
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
        for (Programmer programmer : programmers) {
            if (programmer.getId() == idTurn) {
                programmer.getOldPos().add(programmer.getPos());
                if (programmer.podeMover()) {
                    programmer.move(nrPositions, size);
                    return true;
                }
            }
        }
        return false;
    }

    public String reactToAbyssOrTool() {
        StringBuilder message = new StringBuilder();
        for (Programmer programmer : programmers) {
            if (programmer.getId() == idTurn) {
                int posAtual = programmer.getPos();
                int penultimaPos = 0;
                int antepenultimaPos = 0;
                if (programmer.getOldPos().size() >= 1) {
                    penultimaPos = programmer.getOldPos().get(programmer.getOldPos().size()-1);
                }
                if (programmer.getOldPos().size() >= 2) {
                    antepenultimaPos = programmer.getOldPos().get(programmer.getOldPos().size()-2);
                }
                for (Abysse abysse : abysses) {
                    if (abysse != null) {
                        if (abysse.getPos() == programmer.getPos()) {
                            message.append(abysse.abysseMessage(programmer));
                            if (abysse.getTitle().equals("Erro de sintaxe")) {
                                if (!(programmer.getTools().contains("Ajuda Do Professor"))) {
                                    programmer.move(-1, size);
                                } else {
                                    programmer.getTools().remove("Ajuda Do Professor");
                                }
                            } else if (abysse.getTitle().equals("Erro de lógica")) {
                                int posFinal = (int) Math.floor((((double) posAtual - (double) penultimaPos) / 2));
                                if (!(programmer.getTools().contains("Ajuda Do Professor"))) {
                                    programmer.move(-posFinal, size);
                                } else {
                                    programmer.getTools().remove("Ajuda Do Professor");
                                }
                            } else if (abysse.getTitle().equals("Exception")) {
                                if (programmer.getTools().contains("Ajuda Do Professor") || programmer.getTools().contains("Tratamento de Excepções")) {
                                    if (!programmer.getTools().contains("Ajuda Do Professor")) {
                                        programmer.getTools().remove("Tratamento de Excepções");
                                    } else {
                                        programmer.getTools().remove("Ajuda Do Professor");
                                    }
                                } else {
                                    programmer.move(-2, size);
                                }
                            } else if (abysse.getTitle().equals("File Not Found Exception")) {
                                if (programmer.getTools().contains("Ajuda Do Professor") || programmer.getTools().contains("Tratamento de Excepções")) {
                                    if (!programmer.getTools().contains("Ajuda Do Professor")) {
                                        programmer.getTools().remove("Tratamento de Excepções");
                                    } else {
                                        programmer.getTools().remove("Ajuda Do Professor");
                                    }
                                } else {
                                    programmer.move(-3, size);
                                }
                            } else if (abysse.getTitle().equals("Crash (aka Rebentanço)")) {
                                if (!(programmer.getTools().contains("Testes unitários"))) {
                                    programmer.setPos(1);
                                } else {
                                    programmer.getTools().remove("Testes unitários");
                                }
                            } else if (abysse.getTitle().equals("Duplicated Code")) {
                                if (!(programmer.getTools().contains("IDE"))) {
                                    programmer.setPos(penultimaPos);
                                } else {
                                    programmer.getTools().remove("IDE");
                                }
                            } else if (abysse.getTitle().equals("Efeitos secundários")) {
                                if (!(programmer.getTools().contains("Herança"))) {
                                    programmer.setPos(antepenultimaPos);
                                } else {
                                    programmer.getTools().remove("Herança");
                                }
                            } else if (abysse.getTitle().equals("Blue Screen of Death")) {
                                programmer.setPodeMover(false);
                                programmer.setGameState("Derrotado");
                            } else if (abysse.getTitle().equals("Ciclo infinito")) {
                                if (!(programmer.getTools().contains("Programação Funcional"))) {
                                    programmer.setPodeMover(false);
                                    for (Programmer programmer1 : programmers) {
                                        if (!(programmer1.getName().equals(programmer.getName()))) {
                                            if (programmer1.getPos() == programmer.getPos()) {
                                                programmer1.setPodeMover(true);
                                            }
                                        }
                                    }
                                } else {
                                    programmer.getTools().remove("Programação Funcional");
                                }
                            } else if (abysse.getTitle().equals("Segmentation Fault")) {
                                int i = 0;
                                for (Programmer programmer1 : programmers) {
                                    if (programmer1.getPos() == programmer.getPos()) {
                                        i++;
                                    }
                                }
                                if (!(programmer.getTools().contains("Programação Funcional"))) {
                                    if (i >= 2) {
                                        for (Programmer programmer1 : programmers) {
                                            if (programmer1.getPos() == programmer.getPos()) {
                                                programmer1.move(-3, size);
                                            }
                                        }
                                    }
                                } else {
                                    if (i >= 2) {
                                        programmer.getTools().remove("Programação Funcional");
                                    }
                                }
                            }
                        }
                    }
                }
                for (Tool tool : tools) {
                    if (tool != null) {
                        if (tool.getPos() == programmer.getPos()) {
                            message.append(tool.toolMessage());
                            programmer.getTools().add(tool.getTitle());
                        }
                    }
                }
            }
        }

        nTurns++;
        for (Programmer programmer : programmers) {
            if (programmer.getId() > idTurn) {
                idTurn = programmer.getId();
                if (message.toString().equals("")) {
                    return null;
                } else {
                    return message.toString();
                }
            }
        }

        idTurn = programmers.get(0).getId();
        if (message.toString().equals("")) {
            return null;
        } else {
            return message.toString();
        }

    }

    public boolean gameIsOver() {
        int i = 0;
        for (Programmer programmer : programmers) {
            if (programmer.getGameState().equals("Em Jogo")) {
                i++;
            }
        }
        if (i == 1) {
            return true;
        }

        for (Programmer programmer : programmers) {
            if (programmer.getId() == idTurn) {
                if (programmer.getPos() == size) {
                    for (Programmer programmers : programmers) {
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
        for (Programmer programmer : programmers) {
            if (programmer.getGameState().equals("Em Jogo")) {
                results.add(programmer.getName());
                results.add("");
            }
        }
        results.add("RESTANTES");
        programmers.sort(Comparator.comparing(Programmer -> Programmer.getPos()));
        Collections.reverse(programmers);
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
