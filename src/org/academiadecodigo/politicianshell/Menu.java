package org.academiadecodigo.politicianshell;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    private Game.Status status;
    private Picture menu;


    public Menu() {

        menu = new Picture(0, 0, "resources/Menu.png");
        new MenuHandler();
        status = Game.Status.MENU;

    }

    public Game.Status play() throws InterruptedException {

        menu.draw();

        while (status == Game.Status.MENU) {
            Thread.sleep(50);
        }

        menu.delete();
        return status;
    }

    private class MenuHandler implements KeyboardHandler {

        private Keyboard k;

        public MenuHandler() {
            k = new Keyboard(this);
            mapKeys();
        }

        private void mapKeys() {
            KeyboardEvent pressGame = new KeyboardEvent();
            pressGame.setKey(KeyboardEvent.KEY_P);
            pressGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            k.addEventListener(pressGame);

            KeyboardEvent pressQuit = new KeyboardEvent();
            pressQuit.setKey(KeyboardEvent.KEY_Q);
            pressQuit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            k.addEventListener(pressQuit);
        }

        @Override
        public void keyPressed(KeyboardEvent e) {

            switch (e.getKey()) {
                case KeyboardEvent.KEY_P:
                    status = Game.Status.PLAY;
                    break;
                case KeyboardEvent.KEY_Q:
                    status = Game.Status.QUIT;
                    break;
                default:
                    System.err.println("MENU KEYS NOT WORKING.");
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }
}
