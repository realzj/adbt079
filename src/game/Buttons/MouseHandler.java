package game.Buttons;

import city.cs.engine.*;
import game.DynamicBodies.Bomb;
import game.Levels.GameLevel;
import game.Vec2;
import game.Walkers.Stickman;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MouseHandler implements MouseMotionListener, MouseListener {
    public static Vec2 position;
    public static boolean leftMouseButton = false;
    public static boolean rightMouseButton = false;
    private Bomb bomb;
    private Stickman stickman;
    private GameLevel level;

    public MouseHandler(Bomb bomb, Stickman stickman, GameLevel level) {
        this.bomb = bomb;
        this.stickman = stickman;
        this.level = level;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        position.setX(e.getX());
        position.setY(e.getY());
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        position.setX(e.getX());
        position.setY(e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            leftMouseButton = true;
        System.out.println("Pressed");

        if (e.getButton() == MouseEvent.BUTTON3)
            rightMouseButton = true;
        System.out.println("pressedA");

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftMouseButton = false;
        if(e.getButton() == MouseEvent.BUTTON3)
            rightMouseButton = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}

    private WorldView view;

    public MouseHandler(WorldView view) {
        this.view = view;
    }

    public void mousePressed() {
        position.getX();
    }
}