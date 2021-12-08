package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestAbyss {
    GameManager gameManager = new GameManager();

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
        assertEquals(2, gameManager.getAbyssesOrTools().get(1).getPos());
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
        gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
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
}
