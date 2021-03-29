/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Buttons;

import game.HighScore.HighScoreReader;
import game.HighScore.HighScoreWriter;
import game.Main.Game;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HighScores {
    private JPanel pnlScores;
    private JPanel pnlControls;
    private JLabel lblPlayerName;
    private JTextField txtName;
    private JLabel lblScoreTitle;
    private JLabel lblScore;
    private JButton SaveButton;
    private JList<String> lstScores;
    private JScrollPane scrScores;
    private JButton exitButton;

    private Game game;
    private HighScoreWriter highScoreWriter;
    private HighScoreReader highScoreReader;
    private final String fileName = "data/highscores.txt";

    public HighScores(Game game) {
        this.game = game;

        lblScore.setText(game.getStickman().getBombCount() + "");

        File scores = new File(fileName);
        try {
            scores.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        highScoreWriter = new HighScoreWriter(fileName);
        highScoreReader = new HighScoreReader(fileName);

        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    highScoreWriter.writeHighScore(
                            txtName.getText(),
                            game.getStickman().getBombCount()
                    );
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        DefaultListModel<String> model = new DefaultListModel<>();
        try {
            model.addAll(highScoreReader.readScores());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        lstScores.setModel(model);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getPnlScores() {
        return pnlScores;
    }

}
