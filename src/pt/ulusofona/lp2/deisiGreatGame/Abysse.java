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
            this.title = "Efeitos secundários ";
        } else if (type == 9) {
            this.title = "Segmentation Fault";
        }
    }

    public int getPos() {
        return pos;
    }

    public String getTitle() {
        return title;
    }
}
