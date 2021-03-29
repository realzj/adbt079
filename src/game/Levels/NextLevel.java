/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Levels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.DynamicBodies.Door;
import game.Main.Game;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class NextLevel implements CollisionListener {

    private GameLevel level;
    /**
     * Instance of Game Level
     */
    private Game game;
    /**
     * Instance of Game
     */
    private SoundClip unlock;
    /**
     * This is to declare the sounclip variable name after
     */
    private SoundClip locked;
    /**
     * This is to declare the sounclip variable name after
     */
    public NextLevel(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }

    //Condition used to indicate the advacement to other levels
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Door && level.isComplete()) {
            playSound();
            game.goToNextLevel();
        } else if(e.getOtherBody() instanceof Door){
            Sound2();
        }
    }
    public void playSound() {
        try {
            unlock = new SoundClip("data/unlock.wav");
            unlock.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
    }

    public void Sound2() {
        try {
            locked = new SoundClip("data/locked.wav");
            locked.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.print(e);
        }
    }

}