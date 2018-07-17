package logic;

import graphics.Figure;
import test.TestGameField;
import util.Loader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.*;
import java.util.Timer;

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
    private final static int WH_FIGURE = 32;
    private final static int LEFT_BORDER = 0;
    private final static int RIGHT_BORDER = 320;
    private static int maxPointY;
    private static int[] lines = {448, 416, 384, 352, 320, 288, 256, 224, 192, 160, 128, 96, 64, 32};

    public static Stack<Figure> stack = new Stack<Figure>();
    private static boolean bottom;
    private static boolean left;
    private static boolean right;

    public GameField() {

    }

    public static void main(String[] args) {
        add(new Figure());
        gravity(stack);

    }

    public static void run() {
        add(new Figure());
        gravity(stack);
    }

    public static void add(Figure figure) {
        for (int i = 0; i < figure.getPoints().length; i++) {
            figure.getPoints()[i].x = ((WIDTH / 2) - figure.getPoints()[i].x);
            figure.getPoints()[i].y = (lines[9] - figure.getPoints()[i].y);
        }
        stack.push(figure);
    }

    public static void collisionDetect() {
        int maxY = getMaxYFigure();
        if (maxY + WH_FIGURE == maxPointY && maxPointY < HEIGHT) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < stack.size() - 1; j++) {
                    if ((stack.lastElement().getPoints()[i].y + WH_FIGURE) == stack.get(j).getPoints()[i].y ||
                            (stack.lastElement().getPoints()[i].y + WH_FIGURE) == HEIGHT) {
                        bottom = true;
                        searchMaxPointY();
                        break;
                    }
                    if (((stack.lastElement().getPoints()[i].x - WH_FIGURE) == stack.get(j).getPoints()[i].x &&
                            stack.lastElement().getPoints()[i].y == stack.get(j).getPoints()[i].y) ||
                            (stack.lastElement().getPoints()[i].x - WH_FIGURE) < LEFT_BORDER) {
                        left = true;
                    }
                    if (((stack.lastElement().getPoints()[i].x + WH_FIGURE) == stack.get(j).getPoints()[i].x &&
                            stack.lastElement().getPoints()[i].y == stack.get(j).getPoints()[i].y) ||
                            (stack.lastElement().getPoints()[i].x + WH_FIGURE) > RIGHT_BORDER) {
                        right = true;
                    }
                }
            }
        } else if (maxY + WH_FIGURE < maxPointY && maxPointY != HEIGHT) {
            for (int i = 0; i < 4; i++) {
                if ((stack.lastElement().getPoints()[i].x + WH_FIGURE) > RIGHT_BORDER) {
                    right = true;
                }

                if ((stack.lastElement().getPoints()[i].x - WH_FIGURE) < LEFT_BORDER) {
                    left = true;
                }
            }
        } else if (maxY == HEIGHT) {
            for (int i = 0; i < 4; i++) {
                if ((stack.lastElement().getPoints()[i].x + WH_FIGURE) > RIGHT_BORDER) {
                    right = true;
                }
                if ((stack.lastElement().getPoints()[i].x - WH_FIGURE) < LEFT_BORDER) {
                    left = true;
                }

                if ((stack.lastElement().getPoints()[i].y + WH_FIGURE) == HEIGHT) {
                    bottom = true;
                    searchMaxPointY();
                    break;
                }

            }
        }
    }

    private static int getMaxYFigure() {
        int maxY = 0;
        for (int i = 0; i < 4; i++) {
            if (stack.lastElement().getPoints()[i].y > maxY) {
                maxY = stack.lastElement().getPoints()[i].y;
            }
        }
        return maxY;
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
        collisionDetect();
        if (!bottom) {
            new TestGameField().printField(stack);
            for (int i = 0; i < stack.lastElement().getPoints().length; i++) {
                figures.lastElement().getPoints()[i].y += WH_FIGURE;
            }
        } else {
            clearUnusedFigure();
            checkFillLine();
            nullCollision();
            run();
            temp = true;
        }
        return temp;
    }

    private static void searchMaxPointY() {
        int max = 448;
        for (int i = 0; i < stack.size(); i++) {
            for (int j = 0; j < 4; j++) {
                if (stack.get(i).getPoints()[j].y < max) {
                    max = stack.get(i).getPoints()[j].y;
                    System.out.println(stack.get(i).getNameFigure());
                }
            }
        }
        maxPointY = max;
    }

    private static void checkFillLine() {
        if (stack.size() >= 3) {
            int counter = 0;
            ArrayList<Integer> listLines = new ArrayList<Integer>();
            for (int j = 0; j < lines.length; j++) {
                for (int i = 0; i < stack.size(); i++) {
                    System.out.println("stack check");
                    for (int k = 0; k < 4; k++) {
                        if (stack.get(i).getPoints()[k].y == lines[j]) {//
                            counter++;
                        } else {
                            counter--;
                        }
                    }
                    if (counter == 10) {
                        listLines.add(lines[j]);
                        removeLines(listLines);
                        countShore(listLines);
                        counter = 0;
                    }
                }
                counter = 0;
            }
        }
    }

    private static void removeLines(ArrayList<Integer> listLines) {
        for (int k = 0; k < listLines.size(); k++) {
            for (int i = 0; i < stack.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    if (stack.get(i).getPoints()[j].y == listLines.get(k)) {
                        stack.get(i).getPoints()[j] = null;
                    }
                }
            }
        }
        moveDown(listLines);
    }

    private static void moveDown(ArrayList<Integer> listLines) {
        for (int k = 0; k < listLines.size(); k++) {
            for (int i = 0; i < stack.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    if (stack.get(i).getPoints()[j].y < listLines.get(k)) {
                        stack.get(i).getPoints()[j].y += WH_FIGURE;
                    }
                }
            }
        }
        searchMaxPointY();
    }

    private static void countShore(ArrayList<Integer> lines) {
        switch (lines.size()) {
            case 1:
                Player.shore += 100;
                break;
            case 2:
                Player.shore += 200;
                break;
            case 3:
                Player.shore += 300;
                break;
            case 4:
                Player.shore += 400;
                break;
        }
    }


    public static void moveFigure(boolean isLeft, boolean isRight, boolean isBottom, boolean isRotation) {
        if (isLeft) {
            for (int i = 0; i < stack.lastElement().getPoints().length; i++) {
                stack.lastElement().getPoints()[i].x += WH_FIGURE;
            }
        }
        if (isRight) {
            for (int i = 0; i < stack.lastElement().getPoints().length; i++) {
                stack.lastElement().getPoints()[i].x -= WH_FIGURE;
            }
        }
        if (isBottom) {
            for (int i = 0; i < stack.lastElement().getPoints().length; i++) {
                stack.lastElement().getPoints()[i].y += WH_FIGURE;
            }
        }
        if (isRotation && stack.lastElement().getPoints().length > 4) {
            if (!getCollisionRotationBorderDetect(stack.lastElement())) {
                if (stack.size() > 1) {
                    int collision = 0;
                    for (int i = 4; i < 8; i++) {
                        for (int j = 0; j < stack.size() - 1; j++) {
                            for (int k = 0; k < 4; k++) {
                                if (stack.lastElement().getPoints()[i].x == stack.get(j).getPoints()[k].x &&
                                        stack.lastElement().getPoints()[i].y == stack.get(j).getPoints()[k].y) {
                                    collision++;
                                }
                            }
                        }
                    }
                    if (collision == 0) {
                        stack.lastElement().rotation();
                    }
                } else {
                    stack.lastElement().rotation();
                }
            }
        }
    }

    private static boolean getCollisionRotationBorderDetect(Figure figure) {
        boolean collision = false;
        for (int i = 4; i < 8; i++) {
            if (figure.getPoints()[i].x > LEFT_BORDER ||
                    figure.getPoints()[i].x < RIGHT_BORDER) {
                collision = true;
            }
        }
        return collision;
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

    private static void clearUnusedFigure() {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).getPoints().length > 4) {
                for (int j = 4; j < stack.get(i).getPoints().length; j++) {
                    stack.get(i).getPoints()[j] = null;
                }
            }
        }
    }
}