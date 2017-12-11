import graphics.Figure;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

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

    public static void add(Point[] points) {
        for (int i = 0; i < 4; i++) {
            arrayField[((HEIGHT - points[i].y) / 32) - 11][((points[i].x + (WIDTH / 2)) / 32) - 1] = 1;
        }
    }

    public static void gravity(final int []arr) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(moveGravity(arr)){
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    private static boolean moveGravity(int []arr) {
        boolean temp = false;
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
            if (arr[i] < 448) {
                arr[i] += 32;
            } else if (arr[i] == 448) {
                temp = true;
                break;
            }
        }
        return temp;

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

    private static void destroyLines(){
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                arrayField[i][j] = 0;// move field down;
                if(j == arrayField[i].length){

                    return;
                }
            }
        }
    }

    public static void reset() {
        for (int i = 0; i < arrayField.length; i++) {
            for (int j = 0; j < arrayField[i].length; j++) {
                arrayField[i][j] = 0;
            }
        }
    }
}
