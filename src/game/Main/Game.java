/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 * @author      realzj.github.io
 */

package game.Main;

import game.Buttons.*;
import game.Collisions.Collision;
import game.HighScore.GameSaverLoader;
import game.Levels.*;
import game.Walkers.Stickman;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


/**
 * A world with some bodies.
 */
public class Game {
    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel level;
    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;
    private Controller controller;
    private Collision collision;
    private JFrame frame;
    private GameSaverLoader saverLoader;
    private Game game;
    private HighScores scores;


    public Game() {
        level = new Level1(this);
        view = new MyView(level, 600, 600, level.getStickman(), this);
        controller = new Controller(level.getStickman(), level, level.getBomb(), this);
        collision = new Collision(level.getStickman());
        view.setBack(level.paintBackground());
        view.setGround(level.paintFloor());
        view.addKeyListener(controller);
        view.addMouseListener(new Focus(view));


        //view.setGridResolution(1);
        view.addMouseListener(new MouseHandler(view));

        frame = new JFrame("BTEC stickfight infinity");
        ControlPanel controlPanel = new ControlPanel(this);
        Functions functions = new Functions(this, level);
        frame.add(controlPanel.getMainPanel(), BorderLayout.SOUTH);
        frame.add(functions.getFunction(), BorderLayout.WEST);
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        //JFrame debugView = new DebugViewer(level, 600, 600);

        level.start();

    }

    public void setLevel(GameLevel level) {
        //stop the current level
        this.level.stop();
        //((Level1) level).getMusic();
        //create the new (appropriate) level
        //level now refers to new level
        this.level = level;
        //change the view to look into new level
        controller.updateStickman(level.getStickman());
        controller.updateController(level);
        view.setWorld(this.level);
        //start the simulation in the new level
        this.level.start();
    }

    public void goToNextLevel() {

        if (level instanceof Level1) {
            //stop the current level
            level.stop();
            ((Level1) level).getMusic();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this, level);
            //change the view to look into new level
            view.setWorld(level);
            view.setBack(level.paintBackground());
            view.setGround(level.paintFloor());
            //change the controller to control the
            //student in the new world
            controller.updateStickman(level.getStickman());
            controller.updateController(level);
            frame.add(view);
            frame.setVisible(true);
            //start the simulation in the new level
            level.start();
        } else if (level instanceof Level2) {
            level.stop();
            ((Level2) level).getMusic();
            level = new Level3(this);
            view.setWorld(level);
            view.setBack(level.paintBackground());
            view.setGround(level.paintFloor());
            controller.updateStickman(level.getStickman());
            collision = new Collision(level.getStickman());
            controller.updateController(level);
            level.start();
        } else if (level instanceof Level3) {
            level.stop();
            /**
             * Press Resize Button on Top LEFt after finishing level 3
             */
            JDialog diaScore = new JDialog(frame, true);
            HighScores highScores = new HighScores(this);
            diaScore.getContentPane().add(highScores.getPnlScores());
            diaScore.setVisible(true);
        }
    }

    //Pauses the level
    public void pause() {
        level.stop();
    }

    //Resumes the level
    public void restart() {
        level.start();
    }

    public void mute() {
        if (level instanceof Level1) {
            ((Level1) level).getMusic();
        } else if (level instanceof Level2) {
            ((Level2) level).getMusic();
        } else if (level instanceof Level3) {
            ((Level3) level).getMusic();
        }
    }


    public void save(Game game){
        this.game = game;
        try {
            GameSaverLoader.save(game.getLevel(),"data/save.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void load(Game game){
        this.game = game;
        try {
            GameLevel level =  GameSaverLoader.load(game,"data/save.txt",view);
            game.setLevel(level);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    public GameLevel getLevel()  {
        return level;
    }

    //Reset the level from level1
    public void  reset(){
        level.stop();
        level = new Level1(this);
        view.setWorld(level);
        view.setBack(level.paintBackground());
        view.setGround(level.paintFloor());
        controller.updateStickman(level.getStickman());
        controller.updateController(level);
        level.start();
    }

    public Stickman getStickman() {
        return level.getStickman();
    }

    public static void main(String[] args) {
        new Game();
    }

}
