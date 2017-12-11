package graphics;

import java.awt.*;
import java.util.Random;

public class Figure {

    private Point[] points;
    private String nameFigure;

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
        int number = new Random().nextInt(7);
        switch (number) {
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
        }
    }

    public String getNameFigure() {
        return this.nameFigure;
    }

    public void rotation() {
        if (points.length > 4 && canRotation(points)) {
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
    }

    private boolean canRotation(Point[] points) {
        boolean can = false;
        if (nameFigure.equals("tube")) {
            if (points[0].y >= 64 && points[1].y <= 256) {
                can = true;
            } else if (points[0].x < points[1].x) {
                can = true;
            }
        }
        if (nameFigure.equals("boot")) {
            if (points[2].y < points[3].y && points[2].x <= 288) {
                can = true;
            } else if (points[0].y < points[1].y && points[1].y < points[2].y && points[0].x <= 288) {
                can = true;
            } else if (points[0].y < points[1].y && points[0].x >= 32) {
                can = true;
            } else if (points[1].y < points[2].y && points[2].y < points[3].y && points[1].x >= 64) {
                can = true;
            }
        }
        if (nameFigure.equals("triangle")) {
            if (points[0].y < points[1].y && points[1].y < points[3].y && points[0].x >= 32) {
                can = true;
            } else if (points[0].y < points[1].y && points[2].x < points[1].x && points[1].y < points[3].y && points[0].x <= 288) {
                can = true;
            }
        }
        if (nameFigure.equals("flash")) {
            if (points[0].y < points[1].y && points[0].x >= 32 && points[3].x <= 288) {
                can = true;
            }
        }
        if (nameFigure.equals("bootV")) {
            if(points[0].y > points[1].y && points[1].x < points[2].x && points[2].x < points[3].x && points[1].x >= 32){
                can = true;
            } else if( points[0].x < points[1].x && points[1].y < points[2].y && points[2].y < points[3].y && points[0].x >= 32 && points[1].x <= 288){
                can = true;
            } else if( points[0].x < points[1].x && points[1].x < points[2].x && points[3].y < points[2].y && points[3].x <= 288){
                can = true;
            } else if( points[0].y < points[1].y && points[1].y < points[2].y && points[2].x < points[3].x && points[0].x >= 32){
                can = true;
            }
        }
        if(nameFigure.equals("flashV")){
            if(points[0].y < points[1].y && points[1].x > points[2].x && points[2].y < points[3].y && points[3].x >= 32 && points[0].x <= 288){
                can = true;
            }
        }
        return can;
    }

    public Point[] getPoints() {
        return this.points;
    }
}
