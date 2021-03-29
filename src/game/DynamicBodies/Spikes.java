/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.DynamicBodies;

import city.cs.engine.*;

public class Spikes extends DynamicBody {
    //Shape and coords of Spikes
    private static final Shape SpikeShape = new PolygonShape(-3.79f,-0.642f,
            -3.253f,0.754f, 3.238f,0.723f, 3.698f,-0.642f

    );
    private static final BodyImage image =
            new BodyImage("data/Spikes.png", 1.6f);


    public Spikes(World world) {
        super(world, SpikeShape);
        addImage(image);
    }
}