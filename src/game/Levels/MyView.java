/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Levels;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.Main.Game;
import game.Walkers.Stickman;

import java.awt.*;


public class MyView extends UserView {

    private Image back;
    /**
     * This is to declare the background image
     */
    private Image floor;
    /**
     * This is to declare the background image
     */
    private Stickman stickman;
    /**
     * Instance of Stickman
     */
    private Game game;
    /**
     * instance of Game
     */



    public MyView(World w, int width, int height, Stickman s, Game game) {
        super(w, width, height);
        this.stickman = s;
        this.game = game;
    }

    public void setBack(Image background){
        this.back = background;
    }

    public void setGround(Image ground){
        this.floor = ground;
    }


    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(back,0,0,getWidth(),getHeight(),this);
        g.drawImage(floor, 0, 560, 220, 50, this);
        g.drawImage(floor, 380, 560, 220, 50, this);
    }

    //Displays the bomb and life count
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("default", Font.BOLD, 16));
        g.setColor(Color.white);
        g.drawString("Bombs: " + stickman.getBombCount(), 10, 20);
        g.drawString("Lives: " + stickman.getLifes(),10,40);

    }
}