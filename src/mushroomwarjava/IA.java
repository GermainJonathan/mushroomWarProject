/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;

/**
 *
 * @author Jonathan
 */
public class IA extends Thread {
    
    private botIA bot;
    private gameUI UI;
    private IA intelligence;
    
    public IA(botIA bot, gameUI game) {
        this.UI = game;
        this.bot = bot;
    }

    private void attackNeighbor(House source) {
        
    }
    
    @Override
    public void run() {
        System.out.println("mushroomwarjava.IA.run()");
        while(this.bot.isAlive()) {
            System.out.println("IA is alive");
            for(House elem: this.bot.getHouses()) {
                System.out.println("IA have houses");
                if(elem.getUnities().size() > 15) {
                    System.out.println("bot want to attack with" + elem);
                    this.bot.setHouseSelected(elem);
                    this.attackNeighbor(elem);
                }
            }            
        }

    }
        
}
