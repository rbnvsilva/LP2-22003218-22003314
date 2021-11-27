package pt.ulusofona.lp2.deisiGreatGame;

public class Abysse {
    String title;
    int type, pos;

    public Abysse(int type, int pos) {
        this.type = type;
        this.pos = pos;
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

    public String abysseMessage(Programmer programmer) {
        int posAtual = programmer.getPos();
        int penultimaPos = 0;
        int antepenultimaPos = 0;
        if (programmer.getOldPos().size() >= 1) {
            penultimaPos = programmer.getOldPos().get(programmer.getOldPos().size()-1);
        }
        if (programmer.getOldPos().size() >= 2) {
            antepenultimaPos = programmer.getOldPos().get(programmer.getOldPos().size()-2);
        }

        if (type == 0) {
            return "Erro de sintaxe\nOra bolas, nao sabes escrever! Recua 1 casa.";
        } else if (type == 1) {
            int posFinal = (int)Math.floor((((double) posAtual - (double) penultimaPos) / 2));
            return "Erro de lógica\nOra bolas, tens QI negativo! Recua " + posFinal + " casa(s).";
        } else if (type == 2) {
            return "Exception\nOra bolas, nao sabes ver nulls! Recua 2 casas";
        } else if (type == 3) {
            return "File Not Found Exception\nOra bolas, nao sabes criar ficheiros! Recua 3 casas";
        } else if (type == 4) {
            return "Crash\nCarambolas, nao sabes programar! Vai direto para a primeira casa.";
        } else if (type == 5) {
            return "Duplicated Code\nOra bolas, nao sabes fazer funções! Vai para a casa " + penultimaPos + ".";
        } else if (type == 6) {
            return "Efeitos secundários\nOra bolas, andas a tomar o que não deves! Recua para a casa " + antepenultimaPos + ".";
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

    public int getPos() {
        return pos;
    }

    public String getTitle() {
        return title;
    }
}
