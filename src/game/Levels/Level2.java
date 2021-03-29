/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Levels;

import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import game.Collisions.BombPickup;
import game.Collisions.BulletCollision;
import game.Collisions.Collision;
import game.Collisions.SniperCollision;
import game.DynamicBodies.Bomb;
import game.DynamicBodies.Gun;
import game.Main.Game;
import game.Walkers.Sniper;
import game.Walkers.Stickman;
import org.jbox2d.common.Vec2;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level2 extends GameLevel {
    private SoundClip Music;
    private GameLevel level;
    private Stickman stickman;


    public Level2(Game game, GameLevel level) {
        super(game);
        this.level = level;
        try {
            Music = new SoundClip("data/Level2.wav");
            Music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }


        getEnemy().setPosition(new Vec2(5, -10));
        getStickman().setPosition(new Vec2(-5, -10));
        getDoor().setPosition(new Vec2(12.5f,-11));
        getBullet().setPosition(getStickman().getPosition().add(new Vec2(0.5f,0f)));
        getBullet().destroy();
        getBoss().destroy();
        getSniper().destroy();
        getStickman().addCollisionListener(new BombPickup(getStickman()));
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

        //Make Platfomr for Sniper
        Shape PlatformShape = new BoxShape(2,0.5f);
        StaticBody platform = new StaticBody(this,PlatformShape);
        platform.setPosition(new Vec2(13,3.5f));
        platform.setFillColor(new Color(0f, 0f, 0f, 0f));
        platform.setLineColor(new Color(1f, 0f, 0f, .0f));

        Sniper sniper = new Sniper(this);
        sniper.setPosition(new Vec2(12,4));
        sniper.addCollisionListener(new SniperCollision(getSniper()));


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
    }
    private void stopMusic(){
        Music.stop();
    }

    public void getMusic() {
        stopMusic();
    }

    @Override
    public Image paintBackground() {
        Image background = new ImageIcon("data/back2.png").getImage();
        return background;
    }

    @Override
    public Image paintFloor() {
        return null;
    }

    @Override
    public boolean isComplete() {
        if (getStickman().getBombCount() == 2 && getEnemy().returnHit() == 10 && getSniper().returnHit() == 15)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "Level2";
    }
}

