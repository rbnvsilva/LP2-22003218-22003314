package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends Exception {
    String message;

    InvalidInitialBoardException(String message) {
        this.message = message;
    }

    public boolean isInvalidAbyss() {
        return message.equals("Erro de abismo");
    }

    public boolean isInvalidTool() {
        return message.equals("Erro de tool");
    }

    public int getTypeId() {
        return 0;
    }

    public String getMessage() {
        return message;
    }
}
