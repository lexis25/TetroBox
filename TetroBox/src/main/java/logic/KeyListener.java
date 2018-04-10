package logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e){
        super.keyPressed(e);
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && !GameField.isLeft()) {
            GameField.moveFigure(true,false,false);
        }
        if(key == KeyEvent.VK_RIGHT && !GameField.isRight()){
            GameField.moveFigure(false,true,false);
        }
        if(key == KeyEvent.VK_DOWN && !GameField.isBottom()){
            GameField.moveFigure(false,false,true);
        }
    }
}
