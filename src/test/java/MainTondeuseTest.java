package test.java;

import main.java.MainTondeuse;
import main.java.Tondeuse;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MainTondeuseTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void shouldMoveToWestWhenPivoterAGauche() {
        Tondeuse tondeuse = new Tondeuse(1, 1, 'N');
        int maxX = 5;
        int maxY = 5;

        MainTondeuse.executerInstruction('G', tondeuse, maxX, maxY);

        assertEquals("1 1 W", tondeuse.getPosition());
    }

    @Test
    public void shouldMoveToEastWhenPivoterADroite() {
        Tondeuse tondeuse = new Tondeuse(1, 1, 'N');
        int maxX = 5;
        int maxY = 5;

        MainTondeuse.executerInstruction('D', tondeuse, maxX, maxY);

        assertEquals("1 1 E", tondeuse.getPosition());
    }

    @Test
    public void ShouldMoveForwardWhenAvancer() {
        Tondeuse tondeuse = new Tondeuse(1, 1, 'N');
        int maxX = 5;
        int maxY = 5;

        MainTondeuse.executerInstruction('A', tondeuse, maxX, maxY);

        assertEquals("1 2 N", tondeuse.getPosition());
    }

    @Test
    public void shouldNotMoveWhenLimitsReached() {
        Tondeuse tondeuse = new Tondeuse(5, 1, 'E');
        int maxX = 5;
        int maxY = 5;

        MainTondeuse.executerInstruction('A', tondeuse, maxX, maxY);

        assertEquals("5 1 E", tondeuse.getPosition());
    }

    @Test
    public void testExecuterInstructionAvancerLimiteMaxY() {
        Tondeuse tondeuse = new Tondeuse(1, 5, 'N');
        int maxX = 5;
        int maxY = 5;

        MainTondeuse.executerInstruction('A', tondeuse, maxX, maxY);

        assertEquals("1 5 N", tondeuse.getPosition());
    }

    @Test
    public void testCreerTondeuseFormatValide() {
        String ligne = "2 3 N";
        Tondeuse tondeuse = MainTondeuse.creerTondeuse(ligne);

        assertEquals(2, tondeuse.getX());
    }

    @Test
    public void testLancerTondeuses() throws IOException {

        String input = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA\n"; // Exemple de contenu du fichier
        BufferedReader mockReader = new BufferedReader(new StringReader(input));

        System.setOut(new PrintStream(outputStreamCaptor));

        MainTondeuse mainTondeuse = new MainTondeuse();
        mainTondeuse.lancerTondeuses(mockReader);

        String expectedOutput = "1 3 N\r\n5 1 E\r\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
//        assertEquals("5 1 E", getConsoleOutput(1));



    }




}