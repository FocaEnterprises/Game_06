package net.dinastiafoca.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private boolean[] keysPressed = new boolean[KeyEvent.KEY_LAST];
    private boolean[] keysReleased = new boolean[KeyEvent.KEY_LAST];;

    public boolean getKeyPressed(int index) {
        return keysPressed[index];
    }

    public boolean getKeyReleased(int index) {
        return keysReleased[index];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keysPressed[e.getKeyCode()] = true;
        keysReleased[e.getKeyCode()] = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed[e.getKeyCode()] = false;
        keysReleased[e.getKeyCode()] = true;
    }
}
