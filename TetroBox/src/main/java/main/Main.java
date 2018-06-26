package main;

import logic.Game;
import ui.Display;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
