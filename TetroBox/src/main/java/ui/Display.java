package ui;

import javax.swing.*;
import java.awt.*;

public class Display {

    private static boolean isGameRun = false;
    private static Canvas content;
    private static final String TITLE = "TetroBox";
    public static final int CLEAR_COLOR = 0xff000000;


    public static void create(){
        if(isGameRun){
            return;
        }else{
            JFrame window = new JFrame(TITLE);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            content = new Canvas();

            Dimension size = new Dimension(320, 400);
            content.setPreferredSize(size);
            content.setBackground(Color.black);

            window.setResizable(false);
            window.getContentPane().add(content);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);


        }

    }

}
