package logic;

import graphics.Figure;

import java.awt.*;
import java.util.Stack;
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

    public static Stack<Figure> stack = new Stack<Figure>();

    public GameField(Figure figure) {
        if (stack.empty()) {
            add(figure);
            gravity(stack);
        } else if (!collisionDetect()) {
            add(figure);
            gravity(stack);
        }
    }

    public static void main(String[] args) {
        stack.push(new Figure());
        System.out.println(stack.get(0));
    }

    public static void add(Figure figure) {
        for (int i = 0; i < figure.getPoints().length; i++) {
            figure.getPoints()[i].x = (figure.getPoints()[i].x - (WIDTH / 2));
            figure.getPoints()[i].y = (figure.getPoints()[i].y - (HEIGHT / 3));
        }
        stack.push(figure);
    }

    public static boolean collisionDetect() {
        return true;
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
            if (figures.lastElement().getPoints()[i].y < 448 && collisionDetect()) {
                figures.lastElement().getPoints()[i].y += 32;
            } else if (figures.lastElement().getPoints()[i].y == 448) {
                checkFillLine();
                temp = true;
                break;
            }
        }
        return temp;
    }

    private static void checkFillLine(){// need do it simple structure
        byte [] line = new byte[12];
        for (int i = 0; i < stack.size(); i++) {
            for (int j = 0; j < 4 ; j++) {
                switch (stack.get(i).getPoints()[j].y){
                    case HEIGHT:
                        line[line.length - 1] += 1;
                        default:
                    case HEIGHT - 32:
                        line[line.length - 2] += 1;
                }
            }
        }

        for (int i = 0; i < line.length ; i++) {
            if(line[i] == 9){
                for (int j = 0; j < stack.size(); j++) {
                    for (int k = 0; k < 4; k++) {
                        if(stack.get(i).getPoints()[k].y == HEIGHT){
                        stack.get(i).getPoints()[k].y = 0;
                        }
                    }
                }
            }
        }
    }
}
