package com.company;
import java.io.IOException;

public class Main {

    public static void startGameOfLife() {
        UniverseGeneration.getInput();
        boolean[][] previousMap = UniverseGeneration.generateMap();
        boolean[][] currentMap  = new boolean[UniverseGeneration.NUMBER_OF_COLUMNS][UniverseGeneration.NUMBER_OF_ROWS];
        UniverseGeneration.copyArray(currentMap, previousMap);


        for (int i = 0; i <= UniverseGeneration.GENERATIONS; i++) {

            System.out.println("Generation #" + (i));
            System.out.println("Alive: " + GenerationAlgorithm.countAlive(currentMap));
            //if (i == UniverseGeneration.GENERATIONS)
            UniverseGeneration.print2DMatrix(currentMap);
            GenerationAlgorithm.generateNewLifeALT(previousMap, currentMap);
            UniverseGeneration.copyArray(previousMap, currentMap);


            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            }
            catch (IOException | InterruptedException e) {}
        }
    }


    public static void main(String[] args) {
        startGameOfLife();
    }

}
