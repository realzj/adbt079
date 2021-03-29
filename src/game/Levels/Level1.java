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
import game.DynamicBodies.Bomb;
import game.DynamicBodies.Gun;
import game.DynamicBodies.Spikes;
import game.Main.Game;
import org.jbox2d.common.Vec2;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Level1 extends GameLevel implements ActionListener {
    private SoundClip Music;

    public Level1(Game game) {
        super(game);

        try {
            Music = new SoundClip("data/Mayhen.wav");
            Music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }

        getEnemy().setPosition(new Vec2(5, -10));
        getStickman().setPosition(new Vec2(-5, -10));
        getDoor().setPosition(new Vec2(-14f,-11));
        getBullet().destroy();
        getBoss().destroy();
        getSniper().destroy();
        getStickman().addCollisionListener(new BombPickup(getStickman()));
        getEnemy().addCollisionListener(new BulletCollision(getEnemy()));


        //Makes the First Platform
        Shape Floor = new BoxShape(6f, 0.7f);
        StaticBody floor = new StaticBody(this, Floor);
        floor.setPosition(new Vec2(-10, -14.5f));
        //Color transparency
        floor.setFillColor(new Color(0f, 0f, 0f, 0f));
        floor.setLineColor(new Color(1f, 0f, 0f, .0f));
        //Makes the Second Platform
        Shape Floor2 = new BoxShape(6f, 0.7f);
        StaticBody floor2 = new StaticBody(this, Floor2);
        floor2.setPosition(new Vec2(10, -14.5f));
        floor2.setFillColor(new Color(0f, 0f, 0f, 0f));
        floor2.setLineColor(new Color(1f, 0f, 0f, .0f));
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

        //Makes the spikes platform
        Shape SpikeShape = new BoxShape(5, 0.7f);
        StaticBody spike = new StaticBody(this, SpikeShape);
        spike.setPosition(new Vec2(0, -16f));
        spike.setFillColor(new Color(0f, 0f, 0f, 0f));
        spike.setLineColor(new Color(1f, 0f, 0f, .0f));


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

        //Creates spike object
        Spikes spikes = new Spikes(this);
        spikes.setPosition(new Vec2(0, -13));
        spikes.addCollisionListener(new Collision(getStickman()));

        Timer t = new Timer(5000,this);
        t.start();

        //Supposed to make the stickman reappear 3 times
        while (getStickman().intersects(spikes)){
            getStickman().setPosition(new Vec2(-5,-10));
            if(getStickman().getLifes() > 1){
                System.out.println("You lost");
                System.exit(0);
            }
        }
    }

                            //MUSIC

    private void stopMusic(){
        Music.stop();
    }

    public void getMusic() {
        stopMusic();
    }



                  //Background and flooring

    @Override
    public Image paintBackground() {
        Image background = new ImageIcon("data/back.jpg").getImage();
        return background;
    }

    @Override
    public Image paintFloor() {
        Image ground = new ImageIcon("data/plataforma2.png").getImage();
        return ground;
    }

    //Boolean to check if the player has 2 bombs
    @Override
    public boolean isComplete() {
        if (getStickman().getBombCount() == 2 && getEnemy().returnHit()== 10) {
            return true;
        } else
            return false;
    }

    @Override
    public String getLevelName() {
        return "Level1";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Timer");
    }
}
