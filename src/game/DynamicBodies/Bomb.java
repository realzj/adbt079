/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.DynamicBodies;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Bomb extends DynamicBody {
    //Radius of bomb
    private static final float RADIUS = 0.5f;
    //Shape of bomb

    private static final Shape BombShape
            = new CircleShape(RADIUS);

    private static final BodyImage image
            = new BodyImage("data/Bomb2.png", 2*RADIUS);


    public Bomb(World world) {
        super(world, BombShape);
        addImage(image);
    }
}
