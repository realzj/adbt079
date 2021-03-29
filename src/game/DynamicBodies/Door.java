/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */


package game.DynamicBodies;

import city.cs.engine.*;

public class Door extends DynamicBody {
    //Shape and coords of the Bullet
    private static final Shape DoorShape = new PolygonShape(
            -1.58f,2.42f, 1.55f,2.38f, 1.46f,-2.45f, -1.53f,-2.43f

    );

    private static final BodyImage image =
            new BodyImage("data/door1.jpeg", 5f);


    public Door(World world) {
        super(world, DoorShape);
        addImage(image);
    }
}


