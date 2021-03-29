/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.DynamicBodies.Bullet;
import game.Walkers.Enemy;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class BulletCollision implements CollisionListener {
    private Enemy enemy;
    /**
     * Instance of Eenemy
     */
    private static SoundClip hit;
    /**
     * This is to declare the soundclip variable and declare it later
     */
    private static SoundClip death;
    /**
     * This is to declare the soundclip variable and declare it later
     */


    public BulletCollision(Enemy e) {
        this.enemy = e;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Bullet) {
            enemy.IncrementHit();
            playHit();
            e.getOtherBody().destroy();
            if (enemy.returnHit() == 10) {
                playDeath();
                e.getReportingBody().destroy();
            }
        }
    }
    public void playHit(){
        try {
            hit = new SoundClip("data/bulletcollision.wav");
            hit.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
    }
    public void playDeath(){
        try {
            death = new SoundClip("data/deadZombie.wav");
            death.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
    }



}