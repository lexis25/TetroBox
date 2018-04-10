package ui;

import javax.swing.*;
import java.awt.*;

/***
 * 1.Need create engine (flow, render, etc)
 * 2.Implements GameField to class
 * 3.Add Graphics
 * 4.Testing
 * */
public class Display {

    private static boolean isGameRun = false;
    private static Canvas content;
    private static final String TITLE = "TetroBox";
    public static final int CLEAR_COLOR = 0xff000000;


    public static void create() {
        if (isGameRun) {
            return;
        } else {
            JFrame window = new JFrame(TITLE);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            content = new Canvas();

            Dimension size = new Dimension(342, 546);
            content.setPreferredSize(size);
            content.setBackground(Color.black);

            window.setResizable(false);
            window.getContentPane().add(content);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);

        }

    }

    private static void render() {

    }

}
