/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.DynamicBodies.Bomb;
import game.Walkers.Stickman;

public class BombPickup implements CollisionListener {

    private Stickman stickman;
    /**
     * Instance of Stickman
     */
    public BombPickup(Stickman s){
        this.stickman = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Bomb) {
            stickman.incrementBombCount();
            e.getOtherBody().destroy();
        }
    }
}