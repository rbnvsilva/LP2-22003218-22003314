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

    public String getTypeId() {
        if (isInvalidAbyss()) {
            return "0";
        } else if (isInvalidTool()) {
            return "1";
        }
        return null;
    }

    public String getMessage() {
        return message;
    }
}
