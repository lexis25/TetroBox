package graphics;

import java.awt.*;

public class Figure {

    private Point[] points;
    private String nameFigure;
    private static int numFigure = 0;

    private final Point[] square = {new Point(32, 32), new Point(64, 32), new Point(32, 64), new Point(64, 64)};
    private final Point[] tube = {new Point(0, 32), new Point(32, 32), new Point(64, 32), new Point(96, 32),
            new Point(32, 0), new Point(32, 32), new Point(32, 64), new Point(32, 96)};
    private final Point[] boot = {new Point(0, 32), new Point(32, 32), new Point(64, 32), new Point(64, 64),
            new Point(64, 0), new Point(64, 32), new Point(64, 64), new Point(32, 64),
            new Point(0, 0), new Point(0, 32), new Point(32, 32), new Point(64, 32),
            new Point(64, 0), new Point(32, 0), new Point(32, 32), new Point(32, 64)};
    private final Point[] triangle = {new Point(0, 32), new Point(32, 0), new Point(32, 32), new Point(64, 32),
            new Point(32, 0), new Point(32, 32), new Point(64, 32), new Point(32, 64),
            new Point(0, 32), new Point(32, 32), new Point(64, 32), new Point(32, 64),
            new Point(32, 0), new Point(32, 32), new Point(0, 32), new Point(32, 64)};
    private final Point[] flash = {new Point(32, 0), new Point(32, 32), new Point(64, 32), new Point(64, 64),
            new Point(0, 64), new Point(32, 64), new Point(32, 32), new Point(64, 32)};
    private final Point[] bootV = {new Point(0, 64), new Point(0, 32), new Point(32, 32), new Point(64, 32),
            new Point(32, 0), new Point(64, 0), new Point(64, 32), new Point(64, 64),
            new Point(0, 32), new Point(32, 32), new Point(64, 32), new Point(64, 0),
            new Point(32, 0), new Point(32, 32), new Point(32, 64), new Point(64, 64)};
    private final Point[] flashV = {new Point(32, 32), new Point(64, 32), new Point(64, 64), new Point(96, 64),
            new Point(64, 0), new Point(64, 32), new Point(32, 32), new Point(32, 64)};

    public Figure() {
        create();
    }

    private void create() {
        switch (numFigure) {
            case 0:
                points = square;
                nameFigure = "square";
                break;
            case 1:
                points = tube;
                nameFigure = "tube";
                break;
            case 2:
                points = boot;
                nameFigure = "boot";
                break;
            case 3:
                points = triangle;
                nameFigure = "triangle";
                break;
            case 4:
                points = flash;
                nameFigure = "flash";
                break;
            case 5:
                points = bootV;
                nameFigure = "bootV";
                break;
            case 6:
                points = flashV;
                nameFigure = "flashV";
                break;
            default:
                numFigure = 0;
                points = square;
                nameFigure = "square";
                break;
        }
        numFigure++;
    }

    public void rotation() {
        for (int i = 0; i < 4; i++) {
            Point temp = points[0];
            for (int j = 0; j < points.length; j++) {
                points[j] = points[j + 1];
                if (j == (points.length - 2)) {
                    points[points.length - 1] = temp;
                    break;
                }
            }
        }
    }

    public Point[] getPoints() {
        return this.points;
    }

    public String getNameFigure() {
        return this.nameFigure;
    }
}