package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestProgrammer {
    GameManager gameManager = new GameManager();

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

}
