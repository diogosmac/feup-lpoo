package com.aor.ghostrumble.play.view.lanterna;

import com.aor.ghostrumble.play.controller.event.*;
import com.aor.ghostrumble.play.model.HauntedHouse;
import com.aor.ghostrumble.play.view.ViewGame;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class ViewGameLanterna extends ViewGame {

    private Screen screen;
    private DrawLanternaGame drawer;
    private int width;
    private int height;

    public ViewGameLanterna(Screen screen, int width, int height) {
        this.screen = screen;
        this.drawer = new DrawLanternaGame(screen);
        this.width = width;
        this.height = height;
    }

    private void createEvent(KeyStroke key) {

        switch(key.getKeyType()) {

            case Character:

                switch(key.getCharacter()) {

                    case 'w':
                        queue.raiseEvent(new EventPlayerUp());
                        break;

                    case 'a':
                        queue.raiseEvent(new EventPlayerLeft());
                        break;

                    case 's':
                        queue.raiseEvent(new EventPlayerDown());
                        break;

                    case 'd':
                        queue.raiseEvent(new EventPlayerRight());
                        break;

                    default:
                        break;

                }
                break;

            case ArrowUp:
                queue.raiseEvent(new EventBulletUp());
                break;

            case ArrowDown:
                queue.raiseEvent(new EventBulletDown());
                break;

            case ArrowLeft:
                queue.raiseEvent(new EventBulletLeft());
                break;

            case ArrowRight:
                queue.raiseEvent(new EventBulletRight());
                break;

            case Escape:
                queue.setClose(true);
                break;

            default:
                break;

        }
    }

    @Override
    public void prepareStateChange() {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#32204E"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

    }

    @Override
    public void handleInput() {

        try {
            KeyStroke key = screen.readInput();
            createEvent(key);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void drawAll(HauntedHouse house) {

        try {
            drawer.drawAll(house);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
