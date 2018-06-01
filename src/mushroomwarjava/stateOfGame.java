/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import component.UnitiesProgessBar;
import java.util.List;

/**
 *
 * @author jgermain
 */
public class stateOfGame extends Thread {

    private gameUI game;
    private UnitiesProgessBar progressBar;
    private List<House> redHouses;
    private List<House> blueHouse;
    
    
    public stateOfGame(gameUI game, UnitiesProgessBar progressBar) {
        this.game = game;
        this.progressBar = progressBar;
    }
    
    private int ratioHouse() {
        int redUnit = 0;
        int blueUnit = 0;
        for(House elem: this.redHouses) {
            redUnit += elem.getUnities().size();
        }
        for(House elem: this.blueHouse) {
            blueUnit += elem.getUnities().size();
        }
        return Math.abs(redUnit/blueUnit);
    }

    @Override
    public void run() {
        do {
            List<House> list = this.game.getHouses();
            for(House elem : list) {
                
            }
        } while(this.progressBar.getValue() != 0 || this.progressBar.getValue() == 100);
    }
    
}
