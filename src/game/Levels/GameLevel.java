/**
 * @author      Jhonny Medrano jhonny.medrano-chuquirima@city.ac.uk
 * @version     1.0
 * @since       MAR 2021
 */

package game.Levels;

import city.cs.engine.World;
import game.DynamicBodies.Bomb;
import game.DynamicBodies.Bullet;
import game.DynamicBodies.Door;
import game.DynamicBodies.Gun;
import game.Collisions.EnemyEncounter;
import game.Main.Game;
import game.Walkers.Boss1;
import game.Walkers.Enemy;
import game.Walkers.Sniper;
import game.Walkers.Stickman;

import java.awt.*;

public abstract class GameLevel extends World {
    private Stickman stickman;
    /**
     * Instance of Stickman
     */
    private Enemy enemy;
    /**
     * Instance of Enemy
     */
    private Bomb bomb;
    /**
     * Instance of Bomb
     */
    private Boss1 boss;
    /**
     * Instance of Boss1
     */
    private Sniper sniper;
    /**
     * Instance of Sniper
     */
    private Gun gun;
    /**
     * Instance of Gun
     */
    private Bullet bullet;
    /**
     * instance of Bullet
     */
    private Door door;
    /**
     * Instance of Door
     */


    public GameLevel(Game game) {
        stickman = new Stickman(this);
        enemy = new Enemy(this);
        door = new Door(this);
        bullet = new Bullet(this);
        boss = new Boss1(this);
        sniper = new Sniper(this);
        //bomb = new Bomb(this);
        //gun = new Gun(this);
        EnemyEncounter encounter = new EnemyEncounter(this, game,stickman, boss);
        NextLevel nextLevel = new NextLevel(this,game);
        stickman.addCollisionListener(nextLevel);
        stickman.addCollisionListener(encounter);
    }


    public Stickman getStickman() {
        return stickman;
    }

    public Door getDoor() {
        return door;
    }


    public Bullet getBullet(){
        return bullet;
    }

    public Gun getGun() {
        return gun;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public Sniper getSniper() {
        return sniper;
    }


    public abstract Image paintBackground();

    public abstract Image paintFloor();

    public Boss1 getBoss() {
        return boss;
    }

    public abstract boolean isComplete();

    public abstract String getLevelName();

}