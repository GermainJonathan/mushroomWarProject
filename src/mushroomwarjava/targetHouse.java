/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import component.Unity;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan
 */
public class targetHouse extends Thread {

    private Unity unit;
    private House target;
    private Point dest;
    
    public targetHouse(Unity unit, House target) {
        this.unit = unit;
        this.target = target;
    }
    
    public void chooseDirection() {
        this.dest = new Point(this.unit.getX(), this.unit.getY());
        if(this.unit.getX() == this.target.getX() + 30) {
            if(this.unit.getY() < this.target.getY() + 60) {
                this.dest.y++;
            } else {
                this.dest.y--;
            }
        } else {
            if(this.unit.getX() < this.target.getX() + 30) {
                this.dest.x++;
            } else {
                this.dest.x--;
            }
        }
        if(this.unit.getY() == this.target.getY() + 60) {
            if(this.unit.getX() < this.target.getX() + 30) {
                this.dest.x++;
            } else {
                this.dest.x--;
            }
        } else {
            if(this.unit.getY() < this.target.getY() + 60) {
                this.dest.y++;
            } else {
                this.dest.y--;
            }
        }
    }
    
    @Override
    public void run() {
        while(this.unit.getLocation() != this.target.getLocation()) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(targetHouse.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.chooseDirection();
            this.unit.setLocation(this.dest);
            this.unit.repaint();  
            if(this.target.isOnHitbox(unit)) {
                this.target.isAttackBy(this.unit);
            }
        }
    }
    
}
