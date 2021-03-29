/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Levels.GameLevel;
import game.Main.Game;
import game.Walkers.Boss1;
import game.Walkers.Enemy;
import game.Walkers.Stickman;

public class EnemyEncounter implements CollisionListener {

    private GameLevel level;
    /**
     * Instance of GameLevel
     */
    private Game game;
    /**
     * Instance of Game
     */
    private Stickman stickman;
    /**
     * Instance of Stickman
     */
    private Boss1 boss1;
    /**
     * Instnace of Boss1
     */

    public EnemyEncounter(GameLevel level, Game game, Stickman stickman, Boss1 boss1) {
        this.level = level;
        this.game = game;
        this.boss1 = boss1;
        this.stickman = stickman;
    }

    //Condition used to indicate the advacement to other levels
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Enemy) {
            stickman.decrementLifes();
            if (stickman.getLifes() == 0) {
                e.getReportingBody().destroy();
            }
        } else if (e.getOtherBody() instanceof Boss1) {
            stickman.decrementLifes();
            if (stickman.getLifes() == 0) {
                e.getReportingBody().destroy();
            }
        }
    }
}
