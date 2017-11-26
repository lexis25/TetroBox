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

    public static int[][] arrayField = new int[HEIGHT/32][WIDTH/32];

    public static void main(String[] args) {

        Point[] points = {new Point(32, 0), new Point(32, 32), new Point(64, 32), new Point(32, 64),
                new Point(0, 32), new Point(32, 32), new Point(64, 32), new Point(32, 64)};
        Player player = new Player();

        writeFigure(player.rotationFigure(points));
        System.out.println(points.length);
        clearFigure(points);
        writeFigure(player.rotationFigure(points));
        readPoint(points);
        //writeFigure(points);
        //clearFigure(points);
        readArray(arrayField);
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

    public static void readArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void writeFigure(Point[] points) {
        for (int i = 0; i < 4; i++) {
            arrayField[((HEIGHT - points[i].y) / 32) - 1][((points[i].x + (WIDTH / 2)) / 32) - 1] = 1;
        }
    }

    public static void clearFigure(Point[] points) {
        for (int i = 0; i < 5; i++) {
            arrayField[((HEIGHT - points[i].y) / 32) - 1][((points[i].x + (WIDTH / 2)) / 32) - 1] = 0;
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
                if(j == arrayField.length){
                    return;
                }
            }
        }
    }
}
