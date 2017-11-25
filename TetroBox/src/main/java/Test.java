import graphics.Figure;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
    private static int a = 1;
    private final static int WIDTH = 320;
    private final static int HEIGHT = 480;
    private final static int START_POS_WIDTH = WIDTH / 2;
    private final static int START_POS_HEIGHT = HEIGHT / 2;
    private static Point [] points;

    public static void main(String[] args) {
        Figure utils = new Figure();
        Point[] points = utils.getFigureRandom();
        addPoint(points);
        readPoint(points);

    }

    public static void addPoint(Point[] points) {

        for (int i = 0; i < points.length / 4; i++) {
            points[i].setLocation(START_POS_WIDTH + points[i].getX(), START_POS_HEIGHT + points[i].getY());
        }
    }

    public static void readPoint(Point[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getLocation());
        }
    }

    public void gravity() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveGravity();
            }
        },0,1000);
    }

    private void moveGravity() {
        for (int i = 0; i < points.length; i++) {
            if (points[i].y < 500) {
                points[i].y += 18;
            } else if (points[i].y == 500) {
                break;
            }
        }

    }

}
