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
import game.Walkers.Boss1;
import game.Walkers.Enemy;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//Class to destroy the enemies, snipers and bosses that are gonna come up

public class BossCollision implements CollisionListener {
    private Boss1 boss1;
    /**
     *Instance of Boss1
     */
    private static SoundClip hit;
    /**
     * This is to declare the soundclip variable and declare it later
     */


    public BossCollision(Boss1 boss1) {
        this.boss1 = boss1;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Bullet) {
            boss1.IncrementHit();
            playHit();
            e.getOtherBody().destroy();
            if (boss1.returnHit() >= 25) {
                e.getReportingBody().destroy();
            }
        }
    }
    public void playHit(){
        try {
            hit = new SoundClip("data/bosshit.wav");
            hit.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
    }

}