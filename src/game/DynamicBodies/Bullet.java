/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.DynamicBodies;

import city.cs.engine.*;

public class Bullet extends DynamicBody {
    //Shape and coords of the Bullet
    private static final Shape BulletShape = new PolygonShape(
            0.256f,0.196f, 0.924f,0.108f, 0.92f,-0.032f, 0.232f,-0.12f

    );

    private static final BodyImage image =
            new BodyImage("data/bullet.png", 0.75f);


    public Bullet(World world) {
        super(world, BulletShape);
        addImage(image);
    }
}
