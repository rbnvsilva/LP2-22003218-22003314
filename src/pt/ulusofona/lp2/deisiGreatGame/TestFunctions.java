package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestFunctions {
    GameManager gameManager = new GameManager();
    @Test
    public void testFunctionsGet() {
        String[][] abyssesAndTools = new String[3][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "4";
        abyssesAndTools[0][2] = "6";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "19";
        abyssesAndTools[2][0] = "0";
        abyssesAndTools[2][1] = "1";
        abyssesAndTools[2][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("Crash (aka Rebentanço):0\nErro de sintaxe:0\nErro de lógica:0",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, Arrays.stream("MOST_USED_ABYSSES 10".split(" ")).toList()));
        assertEquals("2 | Fiona | 1 | No tools | Python | Em Jogo",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, Arrays.stream("PLAYER Fiona".split(" ")).toList()));
        assertEquals("Inexistent player",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, Arrays.stream("PLAYER Shrek".split(" ")).toList()));
        assertEquals("Rui,Fiona",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, Arrays.stream("PLAYERS_BY_LANGUAGE Python".split(" ")).toList()));
        assertEquals("Rui:2",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, Arrays.stream("POLYGLOTS".split(" ")).toList()));
        assertEquals("OK", FunctionsKt.router().invoke(CommandType.POST).invoke(gameManager, Arrays.stream("MOVE 3".split(" ")).toList()));
        assertEquals(4,gameManager.getProgrammers(true).get(0).getPos());
        gameManager.moveCurrentPlayer(2);
        assertEquals("3:1",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, Arrays.stream("MOST_USED_POSITIONS 1".split(" ")).toList()));
        assertEquals("OK",
                FunctionsKt.router().invoke(CommandType.POST).invoke(gameManager, Arrays.stream("ABYSS 1 10".split(" ")).toList()));
    }
}
