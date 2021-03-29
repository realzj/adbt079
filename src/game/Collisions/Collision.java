/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Collisions;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.DynamicBodies.Gun;
import game.DynamicBodies.Spikes;
import game.Walkers.Stickman;

public class Collision implements CollisionListener {
    private Stickman stickman;



    public Collision(Stickman stickman) {
        this.stickman = stickman;
    }

    //Collision commands
    //Removes the gun or bomb if objects collide
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Gun && e.getOtherBody() == stickman) {
            e.getOtherBody().addImage(new BodyImage("data/stickman3.png", 5f));
            e.getReportingBody().destroy();
            stickman.pickupGun();
        } else if (e.getReportingBody() instanceof Spikes && e.getOtherBody() == stickman) {
            e.getOtherBody().destroy();
            stickman.decrementLifes();
        }
    }
}

