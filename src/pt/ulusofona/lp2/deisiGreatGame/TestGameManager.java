package pt.ulusofona.lp2.deisiGreatGame;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;


public class TestGameManager {
    GameManager gameManager;
    String [][] playerInfo = new String[2][4];

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
        gameManager.players.get(0).setPos(78);
        assertTrue(gameManager.moveCurrentPlayer(5));
        assertEquals(gameManager.players.get(0).getPos(), 75);
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
        gameManager.players.get(0).setPos(78);
        gameManager.players.get(1).setPos(77);
        assertTrue(gameManager.moveCurrentPlayer(5));
        assertTrue(gameManager.moveCurrentPlayer(2));
        assertEquals(gameManager.players.get(0).getPos(), 75);
        assertEquals(gameManager.players.get(1).getPos(), 79);
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
        gameManager.players.get(0).setPos(78);
        gameManager.players.get(1).setPos(77);
        assertFalse(gameManager.moveCurrentPlayer(0));
        assertTrue(gameManager.moveCurrentPlayer(2));
    }
}
