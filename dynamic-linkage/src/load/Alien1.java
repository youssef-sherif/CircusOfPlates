/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package load;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Youssef
 */
public class Alien1 extends Loadable {

    private static final int MAX_MSTATE = 1;

    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int x;
    private int y;
    
    private boolean visible = false;
    

    public void setPath(String path) {
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
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
        return y;
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
        return visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public void start(int x) {               
        this.setPath("/alien1.png");
        this.visible = true;
        this.x = x;        
        this.y = this.world.getHeight() - spriteImages[0].getHeight();   
        this.world.getConstantObjects().add(this);
    }

    @Override
    public boolean intersects(GameObject o2) {
        return (Math.abs((this.getX() + this.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= this.getWidth()) && (Math.abs((this.getY() + this.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= this.getHeight());
    }

}
