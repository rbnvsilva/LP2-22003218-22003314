package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

public class TestException {
    GameManager gameManager = new GameManager();
    @Test
    public void testException() {
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
        } catch (InvalidInitialBoardException i) {
            System.out.println(i.getMessage());
        }
    }

    @Test
    public void testException2() {
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Rui";
        playerInfo[0][2] = "Java;";
        playerInfo[0][3] = "Blue";
        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Fiona";
        playerInfo[1][2] = "Python;";
        playerInfo[1][3] = "Purple";
        try {
            gameManager.createInitialBoard(playerInfo, 24);
        } catch (InvalidInitialBoardException i) {
            System.out.println(i.getMessage());
        }
    }
}
