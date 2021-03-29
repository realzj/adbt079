/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Walkers;

import city.cs.engine.*;


public class Boss1 extends Walker {
    //Shape and coords of its shape
    private static final Shape BossShape = new PolygonShape(
            1.31f,3.42f, 1.93f,0.64f, 1.69f,-2.98f, -0.69f,-3.36f, -1.91f,-0.56f, -0.73f,3.3f
    );

    private static final BodyImage image =
            new BodyImage("data/boss.png", 7f);

    private int hit;


    public Boss1(World world) {
        super(world, BossShape);
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

