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

    /**
     * Numéro du thread
     */
   public int id;
   
   /**
    * Unité à gérer
    */
   private Unity unit;
   
   /**
    * Maison cible
    */
   private House target;
   
   /**
    * Composants graphique du jeu
    */
   private JPanel map;
   
   /**
    * Vecteur de mouvement
    */
   public Movement move;
   
   /**
    * Point de destination
    */
   private Point destination;
   
   /**
    * Constructeur
    * @param map JPanel représentant le carte du jeu
    * @param unit Unité à gérer
    * @param target Maison Cible
    * @param id Numéro du thread
    */
   public targetHouse(JPanel map, Unity unit, House target, int id) {
       this.unit = unit;
       this.target = target;
       this.map = map;
       this.id = id;
   }
   
   /**
    * Déroulement du thread
    */
   @Override
   public void run() {
       // On construit la destination de l'unité
        int x = target.getLocation().x + (target.getWidth()/2) - (unit.getWidth()/2);
        int y = (target.getLocation().y + (target.getHeight()/2) - (unit.getHeight()/2)) + 35;
        this.destination = new Point(x, y);
        // Création du vecteur de mouvement
        this.move = new Movement(this.map, this.unit, new Vector(unit.getLocation(), this.destination), 10);
        this.move.addListener(this); // On ajoute un contrôleur qui va permettre de mettre en pause le mouvement
        this.move.startMovement(); // Lancement du mouvement
   }
   
   /**
    * Permet d'arreter le vecteur de mouvement
    */
   public void pauseMove() {
       this.move.pauseMovement();
   }
   
   /**
    * Permet de redémarrer le vecteur de mouvement
    */
   public void continueMove() {
        this.move = new Movement(this.map, this.unit, new Vector(unit.getLocation(), this.destination), 10);
        this.move.addListener(this);
        this.move.startMovement();
   }

   @Override
   public void evtStartMove(Movement m) {}

   @Override
   public void evtPauseMove(Movement m) {}

   /**
    * Evenement lorsque l'unité atteint sa cible 
    * @param m Vecteur de mouvement
    */
   @Override
   public void evtFinishMove(Movement m) {
       this.target.isAttackBy(this.unit, this.id);
   }

   @Override
   public void evtPositionMove(Movement m, int x, int y) {}
   
}