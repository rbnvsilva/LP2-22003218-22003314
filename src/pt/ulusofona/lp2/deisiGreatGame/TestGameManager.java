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
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(gameManager.getAbyssesOrTools().get(0).isAbyss());
        gameManager.moveCurrentPlayer(2);
        assertEquals(24,gameManager.getSize());
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
        }
    }
}

