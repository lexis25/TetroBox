import java.awt.*;

public class Player {

    private static int counterRotation = 1;


    public static Point[] rotationFigure (Point[] array) {
        int loop = array.length / 4;
        Point [] copyArray = new Point[4];
        if (loop == counterRotation) {
            counterRotation = 0;
            System.arraycopy(array,0,copyArray,0,4);
        }else {
            System.arraycopy(array, (4 * counterRotation), copyArray, 0, 4);
            counterRotation++;
        }
        return copyArray;
    }
}
