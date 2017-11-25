package graphics;

import java.awt.*;
import java.util.Random;

public class Utils {

    private final String PATH_IMAGE = "/res/cube.jpg";

    private final Point[] square = {new Point(18, 18), new Point(36, 18), new Point(18, 36), new Point(36, 36)};
    private final Point[] tube = {new Point(0, 18), new Point(18, 18), new Point(36, 18), new Point(54, 18),
            new Point(18, 0), new Point(18, 18), new Point(18, 36), new Point(18, 54)};
    private final Point[] boot = {new Point(0, 18), new Point(18, 18), new Point(36, 18), new Point(36, 36),
            new Point(36, 0), new Point(36, 18), new Point(36, 36), new Point(18, 36),
            new Point(0, 0), new Point(0, 18), new Point(18, 18), new Point(36, 18),
            new Point(36, 0), new Point(18, 0), new Point(18, 18), new Point(18, 36)};
    private final Point[] triangle = {new Point(0, 18), new Point(18, 0), new Point(18, 18), new Point(36, 18),
            new Point(18, 0), new Point(18, 18), new Point(36, 18), new Point(18, 36),
            new Point(0, 18), new Point(18, 18), new Point(36, 18), new Point(18, 36),
            new Point(18, 0), new Point(18, 18), new Point(0, 18), new Point(18, 36)};
    private final Point[] flash = {new Point(18, 0), new Point(18, 18), new Point(36, 18), new Point(36, 36),
            new Point(0, 36), new Point(18, 36), new Point(18, 36), new Point(36, 18)};
    private final Point[] bootV = {new Point(0, 36), new Point(0, 18), new Point(18, 18), new Point(36, 18),
            new Point(18, 0), new Point(36, 0), new Point(36, 18), new Point(36, 36),
            new Point(0, 36), new Point(18, 18), new Point(36, 18), new Point(36, 0),
            new Point(18, 0), new Point(18, 18), new Point(18, 36), new Point(36, 36)};
    private final Point[] flashV = {new Point(18, 18), new Point(36, 18), new Point(36, 36), new Point(54, 36),
            new Point(36, 0), new Point(36, 18), new Point(18, 18), new Point(18, 36)};


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
        //number * 18 + 2;
        return null;
    }

}
