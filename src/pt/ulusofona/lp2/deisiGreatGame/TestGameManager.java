package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TestGameManager {
    GameManager gameManager = new GameManager();

    @Test
    public void testCreateInitialBoardWithoutAbysses() {
        String[][] playerInfo1 = new String[5][4];
        assertFalse(gameManager.createInitialBoard(playerInfo1, 79));
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
        assertFalse(gameManager.createInitialBoard(playerInfo, 79));
        playerInfo[0][0] = "2";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79));
        playerInfo[0][0] = "1";
        playerInfo[3][3] = "Blue";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79));
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
        assertFalse(gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools));
        playerInfo[3][3] = "Brown";
        abyssesAndTools[0][0] = "2";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools));
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "10";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools));
        abyssesAndTools[0][2] = "80";
        abyssesAndTools[0][1] = "7";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools));
        abyssesAndTools[0][2] = "2";
        abyssesAndTools[1][0] = "-1";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools));
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "6";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools));
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "-3";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools));
        abyssesAndTools[1][2] = "80";
        assertFalse(gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools));
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
        gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
        assertEquals(ProgrammerColor.BLUE, gameManager.getProgrammers(false).get(0).getColor());
        assertFalse(gameManager.moveCurrentPlayer(-1));
        gameManager.getProgrammers(false).get(0).move(-5, 79);
        gameManager.getProgrammers(false).get(0).setPodeMover(false);
        assertFalse(gameManager.moveCurrentPlayer(1));
        gameManager.getProgrammers(false).get(0).setPodeMover(true);
        gameManager.moveCurrentPlayer(1);
        gameManager.getProgrammers(false).get(0).setPos(2);
        gameManager.reactToAbyssOrTool();
        assertEquals(2, gameManager.getProgrammers(true).get(0).getPos());
        assertFalse(gameManager.gameIsOver());
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertEquals(2, gameManager.getProgrammers(true).get(1).getPos());
        assertFalse(gameManager.gameIsOver());
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        assertEquals(2, gameManager.getProgrammers(true).get(2).getPos());
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
        gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
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
    public void testMoveWrongToolIntoAbyss() {
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
        gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
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
    public void testTurn() {
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
        gameManager.createInitialBoard(playerInfo, 79, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 23, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertNull(gameManager.getImagePng(10));
        assertNull(gameManager.getImagePng(-1));
        assertEquals("glory.png",gameManager.getImagePng(24));
        assertEquals("ajuda-professor.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "0";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("inheritance.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "1";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("functional.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "2";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("unit-tests.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "3";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("exception.png",gameManager.getImagePng(2));
        abyssesAndTools[0][1] = "4";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("IDE.png",gameManager.getImagePng(2));
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
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("syntax.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "1";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("logic.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "2";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("exception.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "3";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("file-not-found-exception.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "4";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("crash.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "5";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("duplicated-code.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "6";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("secondary-effects.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "7";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("bsod.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "8";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("infinite-loop.png",gameManager.getImagePng(2));
        abyssesAndTools[1][1] = "9";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        assertEquals("core-dumped.png",gameManager.getImagePng(2));
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
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Erro de sintaxe\nOra bolas, nao sabes escrever! Recua 1 casa.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "1";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Erro de lógica\nOra bolas, tens QI negativo! Recua metade do que saiu no dado.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "2";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Exception\nOra bolas, nao sabes ver nulls! Recua 2 casas", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "3";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("File Not Found Exception\nOra bolas, nao sabes criar ficheiros! Recua 3 casas", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "4";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Crash\nCarambolas, nao sabes programar! Vai direto para a primeira casa.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "5";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Duplicated Code\nOra bolas, nao sabes fazer funções! Vai para a sua penultima casa.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "6";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Efeitos secundários\nOra bolas, andas a tomar o que não deves! Recua para a antepenultima casa.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "7";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Blue Screen of Death\nCarambolas, Windows back at it again! Infelizmente perdeste!", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "8";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Ciclo Infinito\nCarambolas, nao sabes fazer ciclos! Espera que outro jogador te venha ajudar!", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "9";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Segmentation Fault\nCarambolas, voces sao gordos! Se forem mais de 2 jogadores recuem todos 3 casas", gameManager.getAbyssesOrTools().get(0).message());
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
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Herança\nTens mesmo sorte! Imune ao abismo Efeitos Secundários +1 vez.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "1";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Programação funcional\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nCiclo Infinito e Segmentation Fault.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "2";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Testes unitários\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nCrash (aka Rebentanco).", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "3";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Tratamento de Excepções\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nException e File Not Found Exception.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "4";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("IDE\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nDuplicated Code.", gameManager.getAbyssesOrTools().get(0).message());
        abyssesAndTools[0][1] = "5";
        gameManager.createInitialBoard(playerInfo, 24, abyssesAndTools);
        gameManager.getAbyssesOrTools().get(0).message();
        assertEquals("Ajuda Do Professor\nTens mesmo sorte! Imune aos seguintes abismos +1 vez:\nErro de sintaxe, Erro de logica, Exception, File Not Found Exception.", gameManager.getAbyssesOrTools().get(0).message());
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(3, gameManager.getProgrammers(false).get(0).getPos());
    }
}
