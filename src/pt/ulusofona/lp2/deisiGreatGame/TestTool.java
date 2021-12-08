package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestTool {
    GameManager gameManager = new GameManager();

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
}
