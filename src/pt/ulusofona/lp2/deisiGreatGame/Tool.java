package pt.ulusofona.lp2.deisiGreatGame;

public class Tool {
    String title;
    int type, pos;

    public Tool(int type, int pos) {
        this.type = type;
        this.pos = pos;
        if (type == 0) {
            this.title = "Herança";
        } else if (type == 1) {
            this.title = "Programação funcional";
        } else if (type == 2) {
            this.title = "Testes unitários";
        } else if (type == 3) {
            this.title = "Tratamento de Excepções";
        } else if (type == 4) {
            this.title = "IDE";
        } else if (type == 5) {
            this.title = "Ajuda Do Professor";
        }
    }
    public int getPos() {
        return pos;
    }
    public String getTitle() {
        return title;
    }
}
