/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Buttons;

import game.Main.Game;
import game.Levels.GameLevel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Functions {
    private Game game;
    /**
     *This is an instance of Game
     */
    private GameLevel level;
    /**
     * This is an instance of Game level
     */
    private JButton Save;
    /**
     * This is a button that will save the game in which ever level the user clicks in
     */
    private JButton Load;
    /**
     *This is to load the game from wherever the game was saved from
     */
    private JPanel Function;
    /**
     * This is th name of the jpanel
     */
    private JButton muteButton;
    /**
     * this is to mute the music from the game
     */

    public Functions(Game game, GameLevel level) {
        this.game = game;
        this.level = level;

        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.save(game);
            }});
        Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.load(game);
            }
        });
        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.mute();
            }
        });
    }

    public JPanel getFunction() {
        return Function;

    }
}
