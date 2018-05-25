/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Youssef
 */
public class ProxyAlien implements GameObject {

    private Loadable loadable;
    private World world;
    private static final int MAX_MSTATE = 1;
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int x;

    public ProxyAlien(World world) {
        this.world = world;
        this.x = 300 + new Random().nextInt(world.getWidth()) - 300;

        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("/rocket.png"));
        } catch (IOException ex) {
            Logger.getLogger(ProxyAlien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return world.getHeight() - spriteImages[0].getHeight();
    }

    @Override
    public void setY(int y) {
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    public void drawImage(int alienId) {
        try {
            world.getConstantObjects().remove(this);
            loadable = (Loadable) Class.forName("load.Alien" + alienId).newInstance();
            loadable.setEnvironment(world);
            loadable.start(x);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProxyAlien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ProxyAlien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProxyAlien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean intersects(GameObject o) {
        return loadable.intersects(o);
    }
    
    public void removeImage(){        
        loadable.
    }
}
