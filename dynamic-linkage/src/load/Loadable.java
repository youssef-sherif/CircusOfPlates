/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

/**
 *
 * @author Youssef
 */
public abstract class Loadable implements GameObject {

    World world;    

    //set the world to be loaded in
    public void setEnvironment(World world) {        
        this.world = world;
    }

    public abstract void start(int x);
    
    public abstract boolean intersects(GameObject o);
}
