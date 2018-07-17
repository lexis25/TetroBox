package test;

import graphics.Figure;

import java.util.Stack;

public class TestGameField {


    public static void printField(Stack<Figure> stack) {
        int[] posX = new int[stack.size() * 4];
        int[] posY = new int[stack.size() * 4];
        int[][] field = new int[14][10];

        for (int i = 0; i < stack.size(); i++) {
            for (int j = 0; j < 4; j++) {
                posX[j] = stack.get(i).getPoints()[j].x / 32;
                posY[j] = stack.get(i).getPoints()[j].y / 32;

            }
        }
        for (int i = 0; i < 4; i++) {
            field[posY[i]][posX[i]] = 1;
        }

        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[i].length ; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();

        }
        System.out.println("----------");

    }
}
