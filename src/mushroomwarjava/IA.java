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

    @Override
    public void run() {
        for(House elem: this.bot.getHouses()) {
            if(elem.getUnities().size() > 15) {
                this.bot.setHouseSelected(elem);
            }
        }
    }
        
}
