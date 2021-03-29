/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Walkers;

import city.cs.engine.*;


public class Enemy extends Walker {
    //Enemy shape and coords
    private static final Shape EnemyShape = new PolygonShape(
            0.58f, 1.81f, 1.24f, -2.27f, -0.41f, -2.23f, -1.07f, -1.09f, -1.13f, 2.12f
    );

    private static final BodyImage image =
            new BodyImage("data/enemy.png", 5f);

    private int hit;


    public Enemy(World world) {
        super(world, EnemyShape);
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

