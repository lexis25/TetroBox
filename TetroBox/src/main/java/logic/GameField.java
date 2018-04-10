package logic;

import graphics.Figure;

import java.util.*;

/***
 * Class virtual board
 * detect collision,
 * fill lines,
 * create gravity
 *
 */
public class GameField {

    private final static int WIDTH = 320;
    private final static int HEIGHT = 448;
    private static int maxPointY;
    private static int[] lines = {448, 416, 384, 352, 320, 288, 256, 224, 192, 160, 128, 96, 64, 32};

    public static Stack<Figure> stack = new Stack<Figure>();
    private static boolean bottom;
    private static boolean left;
    private static boolean right;

    public GameField() {

    }


    public static void run(Figure figure) {
        while (true) {
            if (stack.empty()) {
                add(figure);
                gravity(stack);
            } else {
                collisionDetect();
                add(figure);
                gravity(stack);
            }
            if (bottom) {
                System.out.println("GAME OVER");
                break;
            }
        }
    }

    public static void add(Figure figure) {
        for (int i = 0; i < figure.getPoints().length; i++) {
            figure.getPoints()[i].x = (figure.getPoints()[i].x - (WIDTH / 2));
            figure.getPoints()[i].y = (figure.getPoints()[i].y - (HEIGHT / 3));
        }
        stack.push(figure);
    }

    public static void collisionDetect() {
        for (int i = 0; i < 4; i++) {
            if (stack.lastElement().getPoints()[i].y == (maxPointY + 32)) {
                for (int j = 0; j < stack.size() - 1; j++) {
                    if ((stack.lastElement().getPoints()[i].y + 32) == stack.get(j).getPoints()[i].y) {
                        bottom = true;
                    }
                    if ((stack.lastElement().getPoints()[i].x + 32) == stack.get(j).getPoints()[i].x) {
                        left = true;
                    }
                    if ((stack.lastElement().getPoints()[i].x - 32) == stack.get(j).getPoints()[i].x) {
                        right = true;
                    }
                }
            }
        }
    }

    public static void gravity(final Stack<Figure> figures) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (moveGravity(figures)) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    private static boolean moveGravity(Stack<Figure> figures) {
        boolean temp = false;
        for (int i = 0; i < figures.lastElement().getPoints().length; i++) {
            if (figures.lastElement().getPoints()[i].y < 448 && !bottom) {
                figures.lastElement().getPoints()[i].y += 32;
            } else {
                checkFillLine();
                nullCollision();
                run(new Figure());
                temp = true;
                break;
            }
        }
        return temp;
    }

    private static void checkFillLine() {
        int counter = 0;
        for (int j = 0; j < lines.length; j++) {
            for (int i = 0; i < stack.size(); i++) {
                for (int k = 0; k < 4; k++) {
                    if (stack.get(i).getPoints()[k].y == lines[j]) {
                        counter++;
                    } else {
                        counter--;
                    }
                }
                if (counter == 10) {
                    removeLines(lines[j]);
                    counter = 0;
                }
            }
            counter = 0;
        }
    }

    private static void removeLines(int remove) {
        for (int i = 0; i < stack.size(); i++) {
            for (int j = 0; j < 4; j++) {
                if (stack.get(i).getPoints()[j].y == remove) {
                    stack.get(i).getPoints()[j].y = 0;
                } else {
                    stack.get(i).getPoints()[j].y -= 32;
                }
                if (maxPointY < stack.get(i).getPoints()[j].y) {
                    maxPointY = stack.get(i).getPoints()[j].y;
                }
            }
        }
    }

    public static void moveFigure(boolean left, boolean right, boolean bottom){
        if(left){
            for (int i = 0; i < stack.lastElement().getPoints().length; i++) {
                stack.lastElement().getPoints()[i].x += 32;
            }
        }
        if(right){
            for (int i = 0; i < stack.lastElement().getPoints().length; i++) {
                stack.lastElement().getPoints()[i].x -= 32;
            }
        }
        if(bottom){
            for (int i = 0; i < stack.lastElement().getPoints().length; i++) {
                stack.lastElement().getPoints()[i].y += 32;
            }
        }
    }


    private static void nullCollision() {
        bottom = false;
        right = false;
        left = false;
    }

    public static boolean isBottom() {
        return bottom;
    }

    public static boolean isLeft() {
        return left;
    }

    public static boolean isRight() {
        return right;
    }
}
