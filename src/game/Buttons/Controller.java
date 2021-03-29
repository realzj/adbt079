/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */
package game.Buttons;

import city.cs.engine.BodyImage;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.DynamicBodies.Bomb;
import game.DynamicBodies.Bullet;
import game.Levels.GameLevel;
import game.Main.Game;
import game.Walkers.Stickman;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Controller extends World implements KeyListener {
    private static final float WALKING_SPEED = 4f;
    /**
     * This is to get the walking speed
     */
    private Stickman stickman;
    /**
     * This is an instance of the Stickman
     */
    private GameLevel level;
    /**
     * This is an instance of the Gamelevel
     */
    private Bomb bomb;
    /**
     * Instance of bomb
     */
    private Game game;
    /**
     * Instance of Game
     */

    private static SoundClip shoot;
    /**
     * This is to declare the soundclip variable and declare it later
     */
    private static SoundClip jump;
    /**
     *  This is to declare the soundclip variable and declare it later
     */
    private static SoundClip throw1;
    /**
     *  * This is to declare the soundclip variable and declare it later
     */

    /**
     * Controls for the game
     * <p>
     * This is what makes the character perform all the controls.
     *
     * @param  s gets the Stickman
     * @param  level level that im in
     * @param bomb gets the bomb
     * @param game gets the game
     * @return the input of the contorls e.g. right makes the characters moves right.
     */

    public Controller(Stickman s, GameLevel level, Bomb bomb,Game game) {
        stickman = s;
        this.level = level;
        this.bomb = bomb;
        this.game = game;
    }
    //Movement commands
    //

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) {
            Vec2 v = stickman.getLinearVelocity();
            if (Math.abs(v.y) < 0.6f) {
                stickman.jump(20);
                playJump();
            }
        } else if (code == KeyEvent.VK_LEFT) {
            boolean gun = stickman.returnPickup();
            stickman.startWalking(-WALKING_SPEED);
            stickman.removeAllImages();
            stickman.addImage(new BodyImage("data/stickman5.png", 5f));
            //checks if the gun has been picked up, if it has then
            //it will apply another image making it look like the character has picked up the gun
            if (gun == true) {
                stickman.removeAllImages();
                stickman.addImage(new BodyImage("data/stickman4.png", 5f));
            }
        } else if (code == KeyEvent.VK_RIGHT) {
            boolean gun1 = stickman.returnPickup();
            stickman.startWalking(WALKING_SPEED);
            stickman.removeAllImages();
            stickman.addImage(new BodyImage("data/stickman2.png", 5f));
            //checks if the gun has been picked up, if it has then
            //it will apply another image making it look like the character has picked up the gun
            if (gun1 == true) {
                stickman.removeAllImages();
                stickman.addImage(new BodyImage("data/stickman3.png", 5f));
            }
        } else if (code == KeyEvent.VK_DOWN) {
            stickman.startWalking(WALKING_SPEED - WALKING_SPEED);
            //Checks for how many bombs the player has
        } else if (code == KeyEvent.VK_SPACE) {
            if (stickman.getBombCount() >= 1) {
                bomb = new Bomb(level);
                //bomb is set to be positioned where the player is making ir look like he is
                //throwing a bomb
                bomb.setPosition(level.getStickman().getPosition().add(new Vec2(0.5f,2.5f)));
                bomb.setGravityScale(1.5f);
                bomb.setAngularVelocity(10);
                bomb.setLinearVelocity(new Vec2(10,20));
                //Calls the subroutine to play the sound
                Throw();
                stickman.decrementBombCount();
            } else {
                System.out.println("You don't have bombs");
            }
        } else if (code == KeyEvent.VK_ENTER) {
            boolean gun2 = stickman.returnPickup();
            //checks if the player has the gun equipped, if it does then it will shoot
            if(gun2 ==true){
                Bullet bullet = new Bullet(level);
                //Bullet is set at the same position as the player and shoots from the gun perspective
                bullet.setPosition(level.getStickman().getPosition().add(new Vec2(0.5f,0f)));
                //velocity
                bullet.setLinearVelocity(new Vec2(40,1));
                //Calls the subroutine to play the sound
                playSound();
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            stickman.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            stickman.stopWalking();
        }
    }

                                    //SOUNDS FOR ACTIONS
    public void playSound(){
        try {
            shoot = new SoundClip("data/Gunshot.wav");
            shoot.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
    }

    public void playJump(){
        try {
            jump = new SoundClip("data/jumping.wav");
            jump.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
    }

    public void Throw(){
        try {
            throw1  = new SoundClip("data/throw.wav");
            throw1.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
    }
    public void updateStickman(Stickman stickman){
        this.stickman = stickman;
    }
    //Updates the whole controller class as whole
    public void updateController(GameLevel level){
        this.level = level;
    }
}