package pt.ulusofona.lp2.deisiGreatGame;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestGameManager {
    GameManager gameManager = new GameManager();
    @Test
    public void testGameIsOver() {
        String [][] abyssesAndTools = new String[1][3];
        String [][] playerInfo = new String[4][4];
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
}
