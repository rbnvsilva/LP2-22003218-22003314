package pt.ulusofona.lp2.deisiGreatGame;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestGameManager {
    GameManager gameManager;
    String [][] playerInfo = new String[4][4];
    String [][] abyssesAndTools = new String[1][3];


    @Test
    public void testMoveCurrentPlayer1() {
        gameManager = new GameManager();
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        gameManager.createInitialBoard(playerInfo, 79);
        assertFalse(gameManager.moveCurrentPlayer(7));
    }

    @Test
    public void testMoveCurrentPlayer2() {
        gameManager = new GameManager();
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        gameManager.createInitialBoard(playerInfo, 79);
        gameManager.programmers.get(0).setPos(78);
        assertTrue(gameManager.moveCurrentPlayer(5));
        assertEquals(gameManager.programmers.get(0).getPos(), 75);
    }

    @Test
    public void testMoveCurrentPlayer3() {
        gameManager = new GameManager();
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        gameManager.createInitialBoard(playerInfo, 79);
        gameManager.programmers.get(0).setPos(78);
        gameManager.programmers.get(1).setPos(77);
        assertFalse(gameManager.moveCurrentPlayer(0));
        assertTrue(gameManager.moveCurrentPlayer(2));
    }

    @Test
    public void testMoveCurrentPlayer4() {
        gameManager = new GameManager();
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";

        gameManager.createInitialBoard(playerInfo, 79);
        gameManager.programmers.get(0).setPos(78);
        gameManager.programmers.get(1).setPos(77);
        assertFalse(gameManager.moveCurrentPlayer(0));
        assertTrue(gameManager.moveCurrentPlayer(2));
    }

    @Test
    public void testGameIsOver() {
        gameManager = new GameManager();
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
        gameManager.createInitialBoard(playerInfo, 79,abyssesAndTools);
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
}
