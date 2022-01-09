package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestGameManager {
    GameManager gameManager = new GameManager();

    @Test
    public void testCreateInitialBoardWithoutAbysses() {
        String[][] playerInfo1 = new String[5][4];
        try {
            gameManager.createInitialBoard(playerInfo1, 79);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        String[][] playerInfo = new String[4][4];
        playerInfo[0][0] = "-1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Ruben";
        playerInfo[2][2] = "Java;";
        playerInfo[2][3] = "Green";
        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Simão";
        playerInfo[3][2] = "Python;";
        playerInfo[3][3] = "Brown";
        try {
            gameManager.createInitialBoard(playerInfo, 79);
        } catch (InvalidInitialBoardException e){
            System.out.println(e.getMessage());
        }
        playerInfo[0][0] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 79);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        playerInfo[0][0] = "1";
        playerInfo[3][3] = "Blue";
        try {
            gameManager.createInitialBoard(playerInfo, 79);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreateInitialBoardWithAbysses() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[4][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Ruben";
        playerInfo[2][2] = "Java;";
        playerInfo[2][3] = "Green";
        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Simão";
        playerInfo[3][2] = "Python;";
        playerInfo[3][3] = "Green";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "7";
        abyssesAndTools[0][2] = "2";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        playerInfo[3][3] = "Brown";
        abyssesAndTools[0][0] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "10";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        abyssesAndTools[0][2] = "80";
        abyssesAndTools[0][1] = "7";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        abyssesAndTools[0][2] = "2";
        abyssesAndTools[1][0] = "-1";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "6";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "-3";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInvalidMove() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[4][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Ruben";
        playerInfo[2][2] = "Java;";
        playerInfo[2][3] = "Green";
        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Simão";
        playerInfo[3][2] = "Python;";
        playerInfo[3][3] = "Brown";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "7";
        abyssesAndTools[0][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(gameManager.moveCurrentPlayer(-1));
    }

    @Test
    public void testGameIsOver() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[4][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Ruben";
        playerInfo[2][2] = "Java;";
        playerInfo[2][3] = "Green";
        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Simão";
        playerInfo[3][2] = "Python;";
        playerInfo[3][3] = "Brown";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "7";
        abyssesAndTools[0][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertFalse(gameManager.gameIsOver());
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertFalse(gameManager.gameIsOver());
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertTrue(gameManager.gameIsOver());
    }

    @Test
    public void testMoveWithToolIntoAbyss() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "2";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "23";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        assertEquals(23,gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testMoveWithWrongToolIntoAbyss() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "2";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "23";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        assertEquals(22,gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testMoveTurn() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "2";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "23";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
    }

    @Test
    public void testGetGameResults() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "2";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "23";
        try {
            gameManager.createInitialBoard(playerInfo, 23, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getCurrentPlayerID());
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getCurrentPlayerID());
        assertTrue(gameManager.gameIsOver());
        ArrayList<String> results = new ArrayList<>();
        results.add("O GRANDE JOGO DO DEISI");
        results.add("");
        results.add("NR. DE TURNOS");
        results.add("10");
        results.add("");
        results.add("VENCEDOR");
        results.add("Rui");
        results.add("");
        results.add("RESTANTES");
        results.add("Fiona 21");
        assertEquals(results,gameManager.getGameResults());
    }

    @Test
    public void testGetTitle() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertNull(gameManager.getTitle(25));
        assertEquals("Herança", gameManager.getTitle(5));
        assertNull(gameManager.getTitle(10));
    }

    @Test
    public void testGetProgrammers() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertNull(gameManager.getProgrammers(5));
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        ArrayList<Programmer> valid = new ArrayList<>();
        valid.add(gameManager.getProgrammers(false).get(0));
        valid.add(gameManager.getProgrammers(false).get(1));
        assertEquals(valid, gameManager.getProgrammers(1));
    }

    @Test
    public void testGetProgrammersInfo() {
        String[][] abyssesAndTools = new String[3][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "19";
        abyssesAndTools[2][0] = "1";
        abyssesAndTools[2][1] = "1";
        abyssesAndTools[2][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertEquals("Rui : No tools | Fiona : No tools", gameManager.getProgrammersInfo());
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertEquals("Rui : No tools | Fiona : No tools", gameManager.getProgrammersInfo());
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertEquals("Rui : Herança | Fiona : No tools", gameManager.getProgrammersInfo());
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        assertEquals("Rui : Herança | Fiona : Programação Funcional", gameManager.getProgrammersInfo());
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        assertEquals("Rui : Herança; Programação Funcional | Fiona : Programação Funcional", gameManager.getProgrammersInfo());
    }

    @Test
    public void testJPanel() {
        assertTrue(gameManager.getAuthorsPanel().isOpaque());
    }

    @Test
    public void testGetImageAbysses() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(2, gameManager.getAbyssesOrTools().get(1).getPos());
        assertEquals("syntax.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "1";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("logic.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("exception.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("file-not-found-exception.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "4";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("crash.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("duplicated-code.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "6";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("secondary-effects.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "7";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("bsod.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "8";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("infinite-loop.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "9";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("core-dumped.png",gameManager.getImagePng(2));
    }

    @Test
    public void testAbyssMessage() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Erro de sintaxe\nOra bolas, nao sabes escrever! Recua 1 casa.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "1";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Erro de lógica\nOra bolas, tens QI negativo! Recua metade do que saiu no dado.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Exception\nOra bolas, nao sabes ver nulls! Recua 2 casas", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("File Not Found Exception\nOra bolas, nao sabes criar ficheiros! Recua 3 casas", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "4";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Crash\nCarambolas, nao sabes programar! Vai direto para a primeira casa.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Duplicated Code\nOra bolas, nao sabes fazer funções! Vai para a sua penultima casa.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "6";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Efeitos secundários\nOra bolas, andas a tomar o que não deves! Recua para a antepenultima casa.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "7";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Blue Screen of Death\nCarambolas, Windows back at it again! Infelizmente perdeste!", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "8";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Ciclo Infinito\nCarambolas, nao sabes fazer ciclos! Espera que outro jogador te venha ajudar!", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "9";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Segmentation Fault\nCarambolas, voces sao gordos! Se forem mais de 2 jogadores recuem todos 3 casas", gameManager.getAbyssesOrTools().get(0).message());
    }

    @Test
    public void testSyntaxErrorWithTool() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "10";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "4";
        abyssesAndTools[1][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(10, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testLogicErrorWithTool() {
        String[][] abyssesAndTools = new String[4][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "10";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "2";
        abyssesAndTools[1][2] = "5";
        abyssesAndTools[2][0] = "1";
        abyssesAndTools[2][1] = "5";
        abyssesAndTools[2][2] = "6";
        abyssesAndTools[3][0] = "0";
        abyssesAndTools[3][1] = "1";
        abyssesAndTools[3][2] = "15";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(10, gameManager.getProgrammers(false).get(0).getPos());
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(15, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testLogicErrorWithoutTool() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(3, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testExceptionErrorWithTool() {
        String[][] abyssesAndTools = new String[4][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "2";
        abyssesAndTools[0][2] = "15";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "2";
        abyssesAndTools[1][2] = "10";
        abyssesAndTools[2][0] = "1";
        abyssesAndTools[2][1] = "5";
        abyssesAndTools[2][2] = "5";
        abyssesAndTools[3][0] = "1";
        abyssesAndTools[3][1] = "3";
        abyssesAndTools[3][2] = "7";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        assertEquals(10, gameManager.getProgrammers(false).get(0).getPos());
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(15, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testExceptionErrorWithoutTool() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "2";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(3, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testFileExceptionErrorWithTool() {
        String[][] abyssesAndTools = new String[4][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "3";
        abyssesAndTools[0][2] = "15";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "3";
        abyssesAndTools[1][2] = "10";
        abyssesAndTools[2][0] = "1";
        abyssesAndTools[2][1] = "5";
        abyssesAndTools[2][2] = "5";
        abyssesAndTools[3][0] = "1";
        abyssesAndTools[3][1] = "3";
        abyssesAndTools[3][2] = "7";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        assertEquals(10, gameManager.getProgrammers(false).get(0).getPos());
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(15, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testFileExceptionErrorWithoutTool() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "3";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(2, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testCrash() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "4";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(1, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testDuplicatedWithTool() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "10";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(10, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testDuplicatedWithoutTool() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "10";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(5, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testSideEffectsWithTool() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "6";
        abyssesAndTools[0][2] = "10";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "1";
        abyssesAndTools[1][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(10, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testSideEffectsWithoutTool() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "6";
        abyssesAndTools[0][2] = "15";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(5, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testInfiniteCicleWithTool() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "10";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "1";
        abyssesAndTools[1][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        assertEquals(10, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testInfiniteCicleWithoutTool() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "10";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertTrue(gameManager.getProgrammers(false).get(0).podeMover());
    }

    @Test
    public void testSegmentation() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "10";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(7, gameManager.getProgrammers(false).get(0).getPos());
        assertEquals(7, gameManager.getProgrammers(false).get(1).getPos());
    }

    @Test
    public void testLanguages() {
        String[][] abyssesAndTools = new String[3][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "19";
        abyssesAndTools[2][0] = "1";
        abyssesAndTools[2][1] = "1";
        abyssesAndTools[2][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("[Java,  Python]", Arrays.toString(gameManager.getProgrammers(false).get(0).getLanguages()));
    }

    @Test
    public void testProgrammerToString() {
        String[][] abyssesAndTools = new String[3][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "19";
        abyssesAndTools[2][0] = "1";
        abyssesAndTools[2][1] = "1";
        abyssesAndTools[2][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("1 | Rui | 1 | No tools | Python; Java | Em Jogo", gameManager.getProgrammers(false).get(0).toString());
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        assertEquals("1 | Rui | 5 | Herança; Programação Funcional | Python; Java | Em Jogo", gameManager.getProgrammers(false).get(0).toString());
    }

    @Test
    public void testProgrammerColor() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "7";
        abyssesAndTools[0][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e ) {
            System.out.println(e.getMessage());
        }
        assertEquals(ProgrammerColor.BLUE, gameManager.getProgrammers(false).get(0).getColor());
    }

    @Test
    public void testProgrammerMove() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "7";
        abyssesAndTools[0][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getProgrammers(false).get(0).move(-5, 79);
        gameManager.getProgrammers(false).get(0).setPodeMover(false);
        assertFalse(gameManager.moveCurrentPlayer(1));
        gameManager.getProgrammers(false).get(0).setPodeMover(true);
    }

    @Test
    public void testProgrammerSetGetPos() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "7";
        abyssesAndTools[0][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getProgrammers(false).get(0).setPos(2);
        assertEquals(2, gameManager.getProgrammers(false).get(0).getPos());
    }

    @Test
    public void testGetImageTools() {
        String[][] abyssesAndTools = new String[2][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "2";
        abyssesAndTools[1][0] = "0";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "23";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertNull(gameManager.getImagePng(10));
        assertNull(gameManager.getImagePng(-1));
        assertEquals("glory.png",gameManager.getImagePng(24));
        assertEquals("ajuda-professor.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "0";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("inheritance.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "1";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("functional.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("unit-tests.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("exception.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "4";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("IDE.png",gameManager.getImagePng(2));
    }

    @Test
    public void testToolMessage() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Herança\nTens mesmo sorte! Imune ao abismo Duplicated Code 1 vez.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "1";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Programação funcional\nTens mesmo sorte! Imune aos seguintes abismos 1 vez:\nCiclo Infinito e Efeitos secundários.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Testes unitários\nTens mesmo sorte! Imune aos seguintes abismos 1 vez:\nErro de lógica.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Tratamento de Excepções\nTens mesmo sorte! Imune aos seguintes abismos 1 vez:\nException e File Not Found Exception.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "4";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("IDE\nTens mesmo sorte! Imune aos seguintes abismos 1 vez:\nErro de sintaxe.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Ajuda Do Professor\nTens mesmo sorte! Imune aos seguintes abismos 1 vez:\nErro de sintaxe, Erro de lógica, Exception, File Not Found Exception.", gameManager.getAbyssesOrTools().get(0).message());
    }

    @Test
    public void testPisadelasPosition() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        gameManager.moveCurrentPlayer(2);
        assertEquals(1, gameManager.getPositions().get(1).getNumeroPisadelas());
    }

    @Test
    public void testInvalidException1() {
        String[][] abyssesAndTools = new String[1][3];
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java; Python";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "3";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            assertEquals("Erro de abismo", e.getMessage());
            assertEquals("0", e.getTypeId());
            assertTrue(e.isInvalidAbyss());
            assertFalse(e.isInvalidTool());
            System.out.println(e.getMessage());
        }

    }
}
