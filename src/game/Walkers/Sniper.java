/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Walkers;

import city.cs.engine.*;


public class Sniper extends Walker {
    //Shape and coords of sniper
    private static final Shape SniperShape = new PolygonShape(
            0.59f,1.81f, 2.1f,0.43f, 1.92f,-1.92f, -0.31f,-1.9f, -2.0f,-0.96f, -1.67f,1.6f
    );

    private static final BodyImage image =
            new BodyImage("data/sniper.png", 4f);

    private int hit;


    public Sniper(World world) {
        super(world, SniperShape);
        hit = 0;
        addImage(image);
    }

    public void IncrementHit(){
        hit++;
    }

    public int returnHit(){
        return hit;
    }
}

