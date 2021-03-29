/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.DynamicBodies;

import city.cs.engine.*;

public class Gun extends DynamicBody {
    //Shape and coords of Gun
    private static final Shape GunShape = new PolygonShape(1.481f,0.156f,
            1.444f,-0.194f,
            0.681f,-0.344f,
            0.094f,-0.319f,
            -1.531f,0.075f,
            -1.537f,0.125f,
            -0.894f,0.338f,
            0.506f,0.325f
    );

    private static final BodyImage image =
            new BodyImage("data/Gun.png", 0.75f);



    public Gun(World world) {
        super(world, GunShape);
        addImage(image);
    }
}
