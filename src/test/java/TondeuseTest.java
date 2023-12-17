package test.java;

import main.java.Tondeuse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TondeuseTest {

    @Test
    public void shouldReturn12NWhengetPosition(){

        Tondeuse tondeuse = new Tondeuse (1,2,'N');
        assertEquals("1 2 N",tondeuse.getPosition());

    }

    @Test
    public void shouldReturn12WWhenPivoterGauche(){
        Tondeuse tondeuse = new Tondeuse (1,2,'N');
        tondeuse.pivoterAGauche();
        assertEquals("1 2 W",tondeuse.getPosition());
    }

    @Test
    public void shouldReturn12EWhenPivoterDroite(){
        Tondeuse tondeuse = new Tondeuse (1,2,'N');
        tondeuse.pivoterADroite();
        assertEquals("1 2 E",tondeuse.getPosition());
    }

    @Test
    public void shouldReturn13NWhenAvancerNord(){
        Tondeuse tondeuse = new Tondeuse (1,2,'N');
        tondeuse.avancer();
        assertEquals("1 3 N",tondeuse.getPosition());
    }

    @Test
    public void shouldReturn13NWhenAvancerSud(){
        Tondeuse tondeuse = new Tondeuse (1,2,'S');
        tondeuse.avancer();
        assertEquals("1 1 S",tondeuse.getPosition());
    }

}
