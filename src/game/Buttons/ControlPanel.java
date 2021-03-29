/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Buttons;

import game.Main.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    //All buttons needed for GUI
    private JPanel mainPanel;
    /**
     * This is the mainPanel for the GUI
     */
    private JButton pauseButton;
    /**
     *This is a button that if its pressed it will pause the game
     */
    private JButton NextLevelButton;
    /**
     * this is a button that if its pressed it will go to the next level
     */
    private JButton quitButton;
    /**
     * this is a button that if its pressed it will quit the game
     */
    private JButton resumeButton;
    /**
     * this is to resume the game after it is paused
     */
    private JButton restartButton;
    /**
     *this is to restart the game completely from level 1
     */
    private Game game;
    /**
     * This is an instance of game
     */

    /**
     * GUI and controls for the game
     * <p>
     * This is used to pause and resume the game
     *
     * @param  game gets the game
     * @return the actions clicked in the GUI are performed: pause,restart,exit,nextLevel and reset.
     */

    //ALL actions performed when the subroutines in the Game class are called

    public ControlPanel(Game game) {
        this.game = game;
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        NextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goToNextLevel();
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.reset();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
