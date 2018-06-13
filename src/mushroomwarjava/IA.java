/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import java.awt.Point;

/**
 * Intelligence Artificiel du jeu
 * @author Jonathan
 */
public class IA extends Thread {
    
    /**
     * Joueur factice rataché à cette IA
     */
    private botIA bot;
    
    /**
     * instance du jeu en cours
     */
    private gameUI UI;
    
    /**
     * boolean permetant d'arrêter ou non le thread
     */
    private boolean activeIA;
    
    /**
     * constructeur
     * @param bot
     * @param game 
     */
    public IA(botIA bot, gameUI game) {
        this.activeIA = true;
        this.UI = game;
        this.bot = bot;
    }

    /**
     * Attaque d'une autre maison
     * @param source
     * @param target 
     */
    private void attackNeighbor(House source, House target) {
        target.isTarget(source);
    }
    
    /**
     * Permet d'arrêter le thread
     */
    public void stopIA(){
        this.activeIA = false;
    }
    
    /**
     * Action du thread
     * Une attaque sera lancée si une des maisons appartenant au bot possède plus de 15 unitées
     */
    @Override
    public void run() {
        while(this.bot.isAlive() && this.activeIA) {
            for(House elem: this.UI.getHouses()) {
                if(elem.getPlayer() == null || elem.getPlayer() != this.bot) {
                   House sourceHouse = this.bot.houseCanAttack();
                   if(sourceHouse != null) {
                       this.attackNeighbor(sourceHouse, elem);
                   }
                }
            }            
        }

    }
        
}
