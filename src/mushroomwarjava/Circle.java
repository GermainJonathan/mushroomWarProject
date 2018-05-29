/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import java.awt.Component;

/**
 *
 * @author jgermain
 */
public class Circle {
    private int posX;
    private int posY;
    private int radius;

    public Circle(int posX, int posY, int radius) {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getRadius() {
        return radius;
    }
    
    public boolean contains(Component c){
        return contains(c.getX(), c.getY());
    }
   
    public boolean contains(int posX, int posY){
        return (posX >= this.posX &&
               posX <  this.posX + (getRadius() * 2) &&
               posY >= this.posY &&
               posY <  this.posY + (getRadius() * 2));
   }
}
