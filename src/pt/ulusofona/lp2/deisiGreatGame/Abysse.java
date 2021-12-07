package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class Abysse extends AbysseOrTool {

    public Abysse(int type, int pos) {
        super(type, pos);
        if (type == 0) {
            this.title = "Erro de sintaxe";
        } else if (type == 1) {
            this.title = "Erro de lógica";
        } else if (type == 2) {
            this.title = "Exception";
        } else if (type == 3) {
            this.title = "File Not Found Exception";
        } else if (type == 4) {
            this.title = "Crash (aka Rebentanço)";
        } else if (type == 5) {
            this.title = "Duplicated Code";
        } else if (type == 6) {
            this.title = "Efeitos secundários";
        } else if (type == 7) {
            this.title = "Blue Screen of Death";
        } else if (type == 8) {
            this.title = "Ciclo infinito";
        } else if (type == 9) {
            this.title = "Segmentation Fault";
        }
    }
    @Override
    public String getImage() {
        if (type == 0) {
            return "syntax.png";
        } else if (type == 1) {
            return "logic.png";
        } else if (type == 2) {
            return "exception.png";
        } else if (type == 3) {
            return "file-not-found-exception.png";
        } else if (type == 4) {
            return "crash.png";
        } else if (type == 5) {
            return "duplicated-code.png";
        } else if (type == 6) {
            return "secondary-effects.png";
        } else if (type == 7) {
            return "bsod.png";
        } else if (type == 8) {
            return "infinite-loop.png";
        } else if (type == 9) {
            return "core-dumped.png";
        }

        return "";
    }
    @Override
    public String message() {
        if (type == 0) {
            return "Erro de sintaxe\nOra bolas, nao sabes escrever! Recua 1 casa.";
        } else if (type == 1) {
            return "Erro de lógica\nOra bolas, tens QI negativo! Recua metade do que saiu no dado.";
        } else if (type == 2) {
            return "Exception\nOra bolas, nao sabes ver nulls! Recua 2 casas";
        } else if (type == 3) {
            return "File Not Found Exception\nOra bolas, nao sabes criar ficheiros! Recua 3 casas";
        } else if (type == 4) {
            return "Crash\nCarambolas, nao sabes programar! Vai direto para a primeira casa.";
        } else if (type == 5) {
            return "Duplicated Code\nOra bolas, nao sabes fazer funções! Vai para a sua penultima casa.";
        } else if (type == 6) {
            return "Efeitos secundários\nOra bolas, andas a tomar o que não deves! Recua para a antepenultima casa.";
        } else if (type == 7) {
            return "Blue Screen of Death\nCarambolas, Windows back at it again! Infelizmente perdeste!";
        } else if (type == 8) {
            return "Ciclo Infinito\nCarambolas, nao sabes fazer ciclos! Espera que outro jogador te venha ajudar!";
        } else if (type == 9) {
            return "Segmentation Fault\nCarambolas, voces sao gordos! Se forem mais de 2 jogadores recuem todos 3 casas";
        } else {
            return "";
        }
    }
    @Override
    public void react(Programmer programmer, List<Programmer> programmers, int size){
        int posAtual = programmer.getPos();
        int penultimaPos = 0;
        int antepenultimaPos = 0;
        if (programmer.getOldPos().size() >= 1) {
            penultimaPos = programmer.getOldPos().get(programmer.getOldPos().size()-1);
        }
        if (programmer.getOldPos().size() >= 2) {
            antepenultimaPos = programmer.getOldPos().get(programmer.getOldPos().size()-2);
        }
        if (title.equals("Erro de sintaxe")) {
            if (programmer.getTools().contains("Ajuda Do Professor") || programmer.getTools().contains("IDE")) {
                if (!(programmer.getTools().contains("Ajuda Do Professor"))) {
                    programmer.getTools().remove("IDE");
                } else {
                    programmer.getTools().remove("Ajuda Do Professor");
                }
            } else {
                programmer.move(-1, size);
            }
        } else if (title.equals("Erro de lógica")) {
            int posFinal = (int) Math.floor((((double) posAtual - (double) penultimaPos) / 2));
            if (programmer.getTools().contains("Ajuda Do Professor") || programmer.getTools().contains("Testes unitários")) {
                if (!programmer.getTools().contains("Ajuda Do Professor")) {
                    programmer.getTools().remove("Testes unitários");
                } else {
                    programmer.getTools().remove("Ajuda Do Professor");
                }
            } else {
                programmer.move(-posFinal, size);
            }
        } else if (title.equals("Exception")) {
            if (programmer.getTools().contains("Ajuda Do Professor") || programmer.getTools().contains("Tratamento de Excepções")) {
                if (!programmer.getTools().contains("Ajuda Do Professor")) {
                    programmer.getTools().remove("Tratamento de Excepções");
                } else {
                    programmer.getTools().remove("Ajuda Do Professor");
                }
            } else {
                programmer.move(-2, size);
            }
        } else if (title.equals("File Not Found Exception")) {
            if (programmer.getTools().contains("Ajuda Do Professor") || programmer.getTools().contains("Tratamento de Excepções")) {
                if (!programmer.getTools().contains("Ajuda Do Professor")) {
                    programmer.getTools().remove("Tratamento de Excepções");
                } else {
                    programmer.getTools().remove("Ajuda Do Professor");
                }
            } else {
                programmer.move(-3, size);
            }
        } else if (title.equals("Crash (aka Rebentanço)")) {
            programmer.setPos(1);
        } else if (title.equals("Duplicated Code")) {
            if (programmer.getTools().contains("Herança")) {
                programmer.getTools().remove("Herança");
            } else {
                programmer.setPos(penultimaPos);
            }
        } else if (title.equals("Efeitos secundários")) {
            if (programmer.getTools().contains("Programação Funcional")) {
                programmer.getTools().remove("Programação Funcional");
            } else {
                programmer.setPos(antepenultimaPos);
            }
        } else if (title.equals("Blue Screen of Death")) {
            programmer.setPodeMover(false);
            programmer.setGameState("Derrotado");
        } else if (title.equals("Ciclo infinito")) {
            if (programmer.getTools().contains("Programação Funcional")) {
                programmer.getTools().remove("Programação Funcional");
            } else {
                programmer.setPodeMover(false);
                for (Programmer programmer1 : programmers) {
                    if (!(programmer1.getName().equals(programmer.getName()))) {
                        if (programmer1.getPos() == programmer.getPos()) {
                            programmer1.setPodeMover(true);
                        }
                    }
                }
            }
        } else if (title.equals("Segmentation Fault")) {
            int i = 0;
            for (Programmer programmer1 : programmers) {
                if (programmer1.getPos() == programmer.getPos()) {
                    i++;
                }
            }

            if (i >= 2) {
                for (Programmer programmer1 : programmers) {
                    if (programmer1.getPos() == programmer.getPos()) {
                        programmer1.move(-3, size);
                    }
                }
            }
        }
    }

}
