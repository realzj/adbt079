/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.HighScore;

import game.Levels.*;
import game.Main.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaverLoader {

    public static void save(GameLevel level, String fileName)
            throws IOException
    {
        boolean append = false;
        FileWriter writer = null;
        try{
            writer = new FileWriter(fileName,append);
            writer.write(level.getLevelName()+","+level.getStickman().getBombCount());
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    public static GameLevel load(Game game, String fileName, MyView view)
            throws IOException
    {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            int bombCount = Integer.parseInt(tokens[1]);


            GameLevel level = null;
            if (name.equals("Level1")) {
                level = new Level1(game);
                view.setBack(level.paintBackground());
                view.setGround(level.paintFloor());
            }else if(name.equals("Level2")) {
                level = new Level2(game,level);
                view.setBack(level.paintBackground());
                view.setGround(level.paintFloor());
            }else if (name.equals("Level3")) {
                level = new Level3(game);
                view.setBack(level.paintBackground());
                view.setGround(level.paintFloor());
            }
            level.getStickman().setBombCount(bombCount);

            return level;


        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }    }
}
