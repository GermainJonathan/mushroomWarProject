/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import component.Unity;
import java.awt.Point;
import javax.swing.JPanel;
import vectormove.EvtMove;
import vectormove.Movement;
import vectormove.Vector;

public class targetHouse extends Thread implements EvtMove{

   public int id;
   private Unity unit;
   private House target;
   private JPanel map;
   public Movement move;
   private Point destination;
   
   public targetHouse(JPanel map, Unity unit, House target, int id) {
       this.unit = unit;
       this.target = target;
       this.map = map;
       this.id = id;
   }
   
   @Override
   public void run() {
        int x = target.getLocation().x + (target.getWidth()/2) - (unit.getWidth()/2);
        int y = (target.getLocation().y + (target.getHeight()/2) - (unit.getHeight()/2)) + 35;
        this.destination = new Point(x, y);
        this.move = new Movement(this.map, this.unit, new Vector(unit.getLocation(), this.destination), 10);
        this.move.addListener(this);
        this.move.startMovement();
   }
   
   public void pauseMove() {
       this.move.pauseMovement();
   }
   
   public void continueMove() {
        this.move = new Movement(this.map, this.unit, new Vector(unit.getLocation(), this.destination), 10);
        this.move.addListener(this);
        this.move.startMovement();
   }

   @Override
   public void evtStartMove(Movement m) {}

   @Override
   public void evtPauseMove(Movement m) {}

   @Override
   public void evtFinishMove(Movement m) {
       this.target.isAttackBy(this.unit, this.id);
   }

   @Override
   public void evtPositionMove(Movement m, int x, int y) {}
   
}