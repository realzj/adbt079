/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Walkers;

import city.cs.engine.*;
import city.cs.engine.Shape;


public class Stickman extends Walker {
    //Shape and coords of the Stickman
    private static final Shape stickmanShape = new PolygonShape(
            0.22f, 1.98f, 0.37f, 1.61f, 0.4f, -0.33f, 0.2f, -2.07f, -0.27f, -2.09f, -0.43f, -0.39f, -0.49f, 1.8f
    );

    private static final BodyImage image =
            new BodyImage("data/stickman2.png", 5f);

    //All Variabels needed for the stickman
    private int BombCount;
    private boolean pickup;
    private int lifes;


    public Stickman(World world) {
        super(world, stickmanShape);
        BombCount = 0;
        lifes = 3;
        pickup = false;
        addImage(image);
    }

    //Increases the bomb count when one is picked up
    public void incrementBombCount() {
        BombCount++;
        if (getBombCount() < 2) {
            System.out.println("You have " + getBombCount() + " bomb");
        } else {
            System.out.println("You have " + getBombCount() + " bombs");

        }
    }

        public void setBombCount(int bc){
            BombCount = bc;
        }

    //decreases the life count whenever this subroutine is called
    public void decrementLifes() {
        lifes--;
    }

    //Returns how many lifes u have left
    public int getLifes() {
        return lifes;
    }

    //Decreases the bomb count by one when called
    public void decrementBombCount() {
        BombCount--;
    }

    //turns the boolean pickup into true when its called
    public void pickupGun(){
        pickup = true;
    }

    //Returns the bomb counter
    public int getBombCount() {
        return BombCount;
    }

    //Rrturns the boolean pickup
    public boolean returnPickup() {
        return pickup;
    }

}