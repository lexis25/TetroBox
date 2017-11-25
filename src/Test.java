import java.awt.*;

public class Test {
    private static int a = 1;
    private final static int WIDTH = 140;
    private final static int HEIGHT = 120;
    private final static int WHCUBE = 18;

    public static void main(String[] args) {
       /* int[] arr = {1, 1, 2, 1};
        again(arr, 4);
        Point[] square =
                       {new Point(1, 1),
                        new Point(2, 1),
                        new Point(1, 2),
                        new Point(2, 2)};
        addPoint(square);
        readPoint(square);
        */
        System.out.println(Math.pow(18, 1));
    }

    public static int[] again(int[] array, int divide) {
        int loop = array.length / divide;
        int[] copyArray = new int[4];
        if (loop == a) {
            a = 0;
        } else {
            System.arraycopy(array, (divide * a), copyArray, 0, divide);
            a++;
        }
        return copyArray;
    }

    public static void readArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void add(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

        }
    }

    public static void addPoint(Point[] points) {
        for (int i = 1; i < points.length; i++) {
            switch ((int) points[i].getX()) {
                case 0:
                    points[i].x = WIDTH;
                    break;
                case 1:
                    points[i].x = WIDTH + WHCUBE;
                    break;
                case 2:
                    points[i].x = WIDTH + WHCUBE + WHCUBE;
                    break;
                case 3:

            }
            points[0].setLocation(WIDTH, HEIGHT);
            points[i].setLocation(points[i].getX() * WHCUBE + WIDTH, points[i].getY() * WHCUBE + HEIGHT);
        }
    }

    public static void readPoint(Point[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getLocation());
        }
    }

}
