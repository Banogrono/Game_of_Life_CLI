package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// mostly utility stuff
public class UniverseGeneration {
    static int NUMBER_OF_COLUMNS;
    static int NUMBER_OF_ROWS;
    static long SEED;
    static int GENERATIONS;

    final static int DEFAULT_VALUE = 5;

    static void print2DMatrix(final boolean[][] matrix) {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {

                if (matrix[i][j]) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static boolean[][] generateMap() {
        Random random = new Random(SEED);
        boolean[][] matrix = new boolean[NUMBER_OF_COLUMNS][NUMBER_OF_ROWS];
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                matrix[i][j] = random.nextBoolean();
            }
        }
        return matrix;
    }

    static void copyArray(boolean[][] copyToMatrix, boolean[][] copyFromMatrix) {
        for (int i = 0; i < copyFromMatrix.length; i++) {
            copyToMatrix[i] = Arrays.copyOf(copyFromMatrix[i], copyFromMatrix[0].length);
        }
    }

    static void getInput() {
        Scanner s = new Scanner(System.in);
        try {
            NUMBER_OF_COLUMNS = s.nextInt();
            NUMBER_OF_ROWS = NUMBER_OF_COLUMNS;
            SEED = s.nextLong();
            GENERATIONS = s.nextInt();
        } catch (Exception ignored) {
            NUMBER_OF_COLUMNS = DEFAULT_VALUE;
            NUMBER_OF_ROWS = NUMBER_OF_COLUMNS;
            SEED = DEFAULT_VALUE;
            GENERATIONS = DEFAULT_VALUE;
        }
    }
}

       /* static <T>void print2DMatrix(final T [][] matrix) {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

*/