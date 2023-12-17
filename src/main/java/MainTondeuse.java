package main.java;

import java.io.*;

public class MainTondeuse {
    private static final char GAUCHE = 'G';
    private static final char DROITE = 'D';
    private static final char AVANCER = 'A';

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("ressources/input.txt"))) {
            lancerTondeuses(br);
        } catch (FileNotFoundException e) {
            System.err.println("Erreur : Le fichier d'entrée n'a pas été trouvé.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier.");
            e.printStackTrace();
        }catch (Exception e) {
            System.err.println("Une erreur inattendue s'est produite.");
            e.printStackTrace();
        }
    }

    public static void lancerTondeuses(BufferedReader br) throws IOException {
        //Récupération des limites du rectangles
        String[] dimensionsRectangle = br.readLine().split(" ");
        int maxX = Integer.parseInt(dimensionsRectangle[0]);
        int maxY = Integer.parseInt(dimensionsRectangle[1]);

        //Exécuter les instructions pour totues les tondeuses
        String ligne;
        while ((ligne = br.readLine()) != null) {
            Tondeuse tondeuse = creerTondeuse(ligne);

            ligne = br.readLine();
            for (char instruction : ligne.toCharArray()) {
                executerInstruction(instruction, tondeuse, maxX, maxY);
            }
            System.out.println(tondeuse.getPosition());
        }
    }

    public static Tondeuse creerTondeuse(String ligne) {
        String[] tondeuseInfo = ligne.split(" ");
        int x = Integer.parseInt(tondeuseInfo[0]);
        int y = Integer.parseInt(tondeuseInfo[1]);
        char sens = tondeuseInfo[2].charAt(0);
        return new Tondeuse(x, y, sens);
    }

    public static void executerInstruction(char instruction, Tondeuse tondeuse, int maxX, int maxY) {
        int oldX = tondeuse.getX();
        int oldY = tondeuse.getY();

        switch (instruction) {
            case GAUCHE:
                tondeuse.pivoterAGauche();
                break;
            case DROITE:
                tondeuse.pivoterADroite();
                break;
            case AVANCER:
                tondeuse.avancer();
                gererLimitesRectangle(tondeuse, maxX, maxY, oldX, oldY);
                break;
            default:

        }
    }

    private static void gererLimitesRectangle(Tondeuse tondeuse, int maxX, int maxY, int oldX, int oldY) {
        // Si la tondeuse est hors des limites, on garde les mêmes positions
        if (tondeuse.getX() < 0 || tondeuse.getX() > maxX || tondeuse.getY() < 0 || tondeuse.getY() > maxY) {
            tondeuse.setX(oldX);
            tondeuse.setY(oldY);
        }
    }
}

