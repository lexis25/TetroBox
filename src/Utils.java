import java.awt.*;
import java.util.Random;

public class Utils {

    private final String PATH_IMAGE = "/res/cube.jpg";

    private final Point[] square = {new Point(1, 1), new Point(2, 1), new Point(1, 2), new Point(2, 2)};
    private final Point[] tube = {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1),
            new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)};
    private final Point[] boot = {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2),
            new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 2),
            new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1),
            new Point(2, 0), new Point(1, 0), new Point(1, 1), new Point(1, 2)};
    private final Point[] triangle = {new Point(0, 1), new Point(1, 0), new Point(1, 1), new Point(2, 1),
            new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2),
            new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2),
            new Point(1, 0), new Point(1, 1), new Point(0, 1), new Point(1, 2)};
    private final Point[] flash = {new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(2, 2),
            new Point(0, 2), new Point(1, 2), new Point(1, 1), new Point(2, 1)};
    private final Point[] bootV = {new Point(0, 2), new Point(0, 1), new Point(1, 1), new Point(2, 1),
            new Point(1, 0), new Point(2, 0), new Point(2, 1), new Point(2, 2),
            new Point(0, 2), new Point(1, 1), new Point(2, 1), new Point(2, 0),
            new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2)};
    private final Point[] flashV = {new Point(1, 1), new Point(2, 1), new Point(2, 2), new Point(3, 2),
            new Point(2, 0), new Point(2, 1), new Point(1, 1), new Point(1, 2)};


    public Point[] getFigureRandom() {
        int number = new Random().nextInt(7);
        Point[] points = new Point[4];
        switch (number) {
            case 0:
                points = square;
                break;
            case 1:
                points = tube;
                break;
            case 2:
                points = boot;
                break;
            case 3:
                points = triangle;
                break;
            case 4:
                points = flash;
                break;
            case 5:
                points = bootV;
                break;
            case 6:
                points = flashV;
                break;
        }
        return points;
    }

    public Image getImage(){
        int number = new Random().nextInt(6);
        //number * 16 + 2;
        return null;
    }

}
