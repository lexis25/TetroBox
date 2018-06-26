package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {
    private static boolean isGameRun = false;
    private static Canvas content;
    private static final String TITLE = "TetroBox";

    private static BufferedImage buffer;
    private static int [] bufferData;
    private static Graphics bufferedGraphics;
    private static int clearColor;
    private static JFrame window;
    private static BufferStrategy bufferStrategy;

    public static void create(int width, int height, int _clearColor, int _numBuffers) {
        if (isGameRun) {
            return;
        } else {
            window = new JFrame(TITLE);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            content = new Canvas();

            Dimension size = new Dimension(width, height);
            content.setPreferredSize(size);
            content.setBackground(Color.black);

            window.setResizable(false);
            window.getContentPane().add(content);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);

            buffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            bufferData = ((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
            bufferedGraphics = buffer.getGraphics();
            ((Graphics2D)bufferedGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            clearColor = _clearColor;

            content.createBufferStrategy(_numBuffers);
            bufferStrategy = content.getBufferStrategy();

            isGameRun = true;
        }

    }

    public static void clear() {
        Arrays.fill(bufferData,clearColor);
    }

    public static void swapBuffers(){
        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(buffer,0,0,null);
        bufferStrategy.show();
    }

    public static Graphics2D getGraphics(){
        return (Graphics2D) bufferedGraphics;
    }

    public static void destroy() {
        if (!isGameRun)
            return;
        window.dispose();
    }

    public static void setTitle(String title){
        window.setTitle(title);
    }

}
