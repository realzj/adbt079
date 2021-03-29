/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Collisions.BombPickup;
import game.Collisions.BossCollision;
import game.Collisions.BulletCollision;
import game.Collisions.Collision;
import game.DynamicBodies.Bomb;
import game.DynamicBodies.Gun;
import game.Main.Game;
import game.Walkers.Boss1;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level3 extends GameLevel {
    private SoundClip Music;

    public Level3(Game game) {
        super(game);
        try {
            Music = new SoundClip("data/level3.wav");
            Music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }


        getEnemy().setPosition(new Vec2(5, -10));
        getStickman().setPosition(new Vec2(-5, -10));
        getStickman().addCollisionListener(new BombPickup(getStickman()));
        getBullet().destroy();
        getBoss().destroy();
        getDoor().setPosition(new Vec2(-14f,-11));
        getSniper().destroy();
        getEnemy().addCollisionListener(new BulletCollision(getEnemy()));


        //Makes the First Platform
        Shape Floor = new BoxShape(25f, 3.2f);
        StaticBody floor = new StaticBody(this, Floor);
        floor.setPosition(new Vec2(-10, -14.5f));
        //Color transparency
        floor.setFillColor(new Color(0f, 0f, 0f, 0f));
        floor.setLineColor(new Color(1f, 0f, 0f, .0f));
        //Makes the  Wall
        Shape wallShape = new BoxShape(0.5F, 14F);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-15.5F, 0.5F));
        wall1.setFillColor(new Color(0f, 0f, 0f, 0f));
        wall1.setLineColor(new Color(1f, 0f, 0f, .0f));
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(15.5F, 0.5F));
        wall2.setFillColor(new Color(0f, 0f, 0f, 0f));
        wall2.setLineColor(new Color(1f, 0f, 0f, .0f));

        //Makes Ceiling
        Shape CeilingShape = new BoxShape(15, 0.7f);
        StaticBody ceiling = new StaticBody(this, CeilingShape);
        ceiling.setPosition(new Vec2(0, 15.5f));
        ceiling.setFillColor(new Color(0f, 0f, 0f, 0f));
        ceiling.setLineColor(new Color(1f, 0f, 0f, .0f));


        //Loop to create and position Guns
        for (int i = 0; i < 2; i++) {
            Gun gun = new Gun(this);
            gun.setPosition(new Vec2(16 * i - 7, -10));
            gun.addCollisionListener(new Collision(getStickman()));
        }

        //Loop to create and position Bombs
        for (int i = 0; i < 2; i++) {
            Bomb bomb = new Bomb(this);
            bomb.setPosition(new Vec2(17 * i - 10, -12));
            bomb.addCollisionListener(new Collision(getStickman()));
        }
        Boss1 boss = new Boss1(this);
        boss.setPosition(new Vec2(10,-10));
        boss.addCollisionListener(new BossCollision(getBoss()));
    }

    @Override
    public Image paintBackground() {
        Image background = new ImageIcon("data/3back2.png").getImage();
        return background;
    }

    @Override
    public Image paintFloor() {
        return null;
    }

    public void stopMusic () {
        Music.stop();
    }

    public void getMusic () {
        stopMusic();
    }


    public boolean isComplete() {
        if (getStickman().getBombCount() == 2 && getEnemy().returnHit() == 10 && getBoss().returnHit() == 25)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "Level3";
    }

}
