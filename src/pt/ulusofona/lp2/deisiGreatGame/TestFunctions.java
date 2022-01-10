package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestFunctions {
    GameManager gameManager = new GameManager();
    @Test
    public void testFunctions() {
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
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("MOST_USED_ABYSSES");
        arrayList.add("3");
        assertEquals("Crash (aka Rebentanço):0\nErro de sintaxe:0\nErro de lógica:0",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager,arrayList));
        arrayList = new ArrayList<>();
        arrayList.add("PLAYER");
        arrayList.add("Fiona");
        assertEquals("2 | Fiona | 1 | No tools | Python | Em Jogo",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, arrayList));
        arrayList = new ArrayList<>();
        arrayList.add("PLAYER");
        arrayList.add("Shrek");
        assertEquals("Inexistent player",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, arrayList));
        arrayList = new ArrayList<>();
        arrayList.add("PLAYERS_BY_LANGUAGE");
        arrayList.add("Python");
        assertEquals("Rui,Fiona",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, arrayList));
        arrayList = new ArrayList<>();
        arrayList.add("POLYGLOTS");
        assertEquals("Rui:2",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, arrayList));
        arrayList = new ArrayList<>();
        arrayList.add("MOVE");
        arrayList.add("3");
        assertEquals("OK", FunctionsKt.router().invoke(CommandType.POST).invoke(gameManager, arrayList));
        assertEquals(4,gameManager.getProgrammers(true).get(0).getPos());
        gameManager.moveCurrentPlayer(2);
        arrayList = new ArrayList<>();
        arrayList.add("MOST_USED_POSITIONS");
        arrayList.add("1");
        assertEquals("3:1",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, arrayList));
        arrayList = new ArrayList<>();
        arrayList.add("ABYSS");
        arrayList.add("1");
        arrayList.add("10");
        assertEquals("OK",
                FunctionsKt.router().invoke(CommandType.POST).invoke(gameManager, arrayList));
    }
}
