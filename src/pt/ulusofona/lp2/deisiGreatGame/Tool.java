package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public class Tool extends AbysseOrTool {

    public Tool(int type, int pos) {
        super(type, pos);
        if (type == 0) {
            this.title = "Herança";
        } else if (type == 1) {
            this.title = "Programação Funcional";
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
    @Override
    public String getImage() {
        if (type == 0) {
            return "inheritance.png";
        } else if (type == 1) {
            return "functional.png";
        } else if (type == 2) {
            return "unit-tests.png";
        } else if (type == 3) {
            return "exception.png";
        } else if (type == 4) {
            return "IDE.png";
        } else if (type == 5) {
            return "ajuda-professor.png";
        }

        return "";
    }
    @Override
    public String message() {
        if (type == 0) {
            return "Herança\nTens mesmo sorte! Imune ao abismo Efeitos Secundários +1 vez.";
        } else if (type == 1) {
            return "Programação funcional\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nCiclo Infinito e Segmentation Fault.";
        } else if (type == 2) {
            return "Testes unitários\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nCrash (aka Rebentanco).";
        } else if (type == 3) {
            return "Tratamento de Excepções\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nException e File Not Found Exception.";
        } else if (type == 4) {
            return "IDE\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nDuplicated Code.";
        } else if (type == 5) {
            return "Ajuda Do Professor\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nErro de sintaxe, Erro de logica, Exception, File Not Found Exception.";
        } else {
            return "";
        }
    }
    @Override
    public void react(Programmer programmer, List<Programmer> programmers, int size) {
        programmer.getTools().add(title);
    }
}
