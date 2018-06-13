/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import java.awt.Point;

/**
 *
 * @author Jonathan
 */
public class IA extends Thread {
    
    private botIA bot;
    private gameUI UI;
    private boolean activeIA;
    
    public IA(botIA bot, gameUI game) {
        this.activeIA = true;
        this.UI = game;
        this.bot = bot;
    }

    private void attackNeighbor(House source, House target) {
        target.isTarget(source);
    }
    
    public void stopIA(){
        this.activeIA = false;
    }
    
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
