import graphics.Figure;

import java.awt.*;

/***
 * Class virtual board
 * detect collision,
 * fill lines,
 *
 */
public class GameField {

    private final static int WIDTH = 320;
    private final static int HEIGHT = 448;
    private static int counter = 0;

    private static int Xmax = 0;
    private static int Ymax = 0;
    private static int Xmin;


    public static int[][] arrayField = new int[HEIGHT/32][WIDTH/32];

    public GameField(){

    }

    public static void main(String[] args) {


    }

    public static void readField(){
        for (int i = 0; i < arrayField.length; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                System.out.print(arrayField[i][j]);
            }
            System.out.println();
        }
    }


    public static void readPoint(Point [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void resetField() {
        for (int i = 0; i < arrayField.length; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                arrayField[i][j] = 0;
            }
        }
    }

    public static void addFigure(Point[] points) {
        for (int i = 0; i < 4; i++) {
            arrayField[((HEIGHT - points[i].y) / 32) - 11][((points[i].x + (WIDTH / 2)) / 32) - 1] = 1;
        }
    }

    public static void findFillLines(){
        for (int i = 0; i < arrayField.length ; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                if(arrayField[i][j] == 1){
                    counter++;
                    if(counter == 10){
                        destroyLines();
                    }
                }
            }
            counter = 0;
        }
    }

    public static void destroyLines(){
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                arrayField[i][j] = 0;
                if(j == arrayField[i].length){
                    return;
                }
            }
        }
    }
}
