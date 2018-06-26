package logic;

import ui.Display;
import util.Time;

public class Game implements Runnable {

    public static final int WIDTH = 342;
    public static final int HEIGHT = 546;
    public static final String TITLE = "TetroBox";
    public static final int CLEAR_COLOR = 0xFF0000;
    public static final int NUM_BUFFERS = 3;

    public static final float UPDATE_RATE = 30.0f;
    public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;
    public static final long IDLE_TIME = 1;

    private boolean running;
    private Thread gameThread;

    public Game() {
        running = false;
        Display.create(WIDTH, HEIGHT, CLEAR_COLOR, NUM_BUFFERS);
        GameField field = new GameField();
        field.run();
    }

    public synchronized void start() {

        if (running)
            return;

        running = true;
        gameThread = new Thread(this);
        gameThread.start();

    }

    public synchronized void stop() {

        if (!running)
            return;

        running = false;

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cleanUp();
    }

    public void run() {
        int fps = 0;
        int upd = 0;
        int updl = 0;

        long count = 0;


        float delta = 0;
        long lastTime = Time.get();
        while (running) {
            long now = Time.get();
            long elapsedTime = now - lastTime;
            lastTime = now;

            count += elapsedTime;

            boolean render = false;
            delta += (elapsedTime / UPDATE_INTERVAL);

            while (delta > 1) {
                upd++;
                update();
                delta--;
                if (render) {
                    updl++;
                } else {
                    render = true;
                }
            }
            if (render) {
                fps++;
                render();
            } else {
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(count >= Time.SECOND){
                Display.setTitle(TITLE + " || fps: " + fps + " || upd: " + upd + " || updl: "  + updl );
                upd = 0;
                fps = 0;
                updl = 0;
                count = 0;
            }
        }
    }

    private void update() {

    }

    private void render() {
        Display.clear();
        Display.swapBuffers();
    }

    private void cleanUp() {
        Display.destroy();
    }
}
