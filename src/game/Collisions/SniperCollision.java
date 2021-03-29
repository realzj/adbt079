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
import game.Walkers.Sniper;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//Class to destroy the enemies, snipers and bosses that are gonna come up

public class SniperCollision implements CollisionListener {
    private Sniper sniper;
    /**
     * Instance of Sniper
     */

    public SniperCollision(Sniper sniper) {
        this.sniper = sniper;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Bullet) {
            sniper.IncrementHit();
            e.getOtherBody().destroy();
            if (sniper.returnHit() >= 15) {
                e.getReportingBody().destroy();
            }
        }
    }
}