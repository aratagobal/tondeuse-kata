package main.java;

import java.util.HashMap;
import java.util.Map;

public class Tondeuse {

    int x;
    int y;
    char sens;

    private static final Map<Character, Character> PIVOT_GAUCHE = new HashMap<>();
    private static final Map<Character, Character> PIVOT_DROITE = new HashMap<>();

    static {
        PIVOT_GAUCHE.put('N', 'W');
        PIVOT_GAUCHE.put('E', 'N');
        PIVOT_GAUCHE.put('S', 'E');
        PIVOT_GAUCHE.put('W', 'S');

        PIVOT_DROITE.put('N', 'E');
        PIVOT_DROITE.put('E', 'S');
        PIVOT_DROITE.put('S', 'W');
        PIVOT_DROITE.put('W', 'N');
    }

    public Tondeuse(int x, int y, char sens) {
        this.x = x;
        this.y = y;
        this.sens = sens;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public String getPosition(){

        return x + " " + y + " " + sens;
    }

    public void pivoterAGauche(){
        sens = PIVOT_GAUCHE.get(sens);
    }

    public void pivoterADroite(){
        sens = PIVOT_DROITE.get(sens);
    }

    public void avancer(){
        switch (sens) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
    }
}
