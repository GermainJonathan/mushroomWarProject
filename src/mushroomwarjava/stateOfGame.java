/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import component.UnitiesProgessBar;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jgermain
 */
public class stateOfGame extends Thread {

    private gameUI game;
    private UnitiesProgessBar progressBar;
    private List<House> redHouses;
    private List<House> blueHouse;
    private int count;
    
    
    public stateOfGame(gameUI game, UnitiesProgessBar progressBar) {
        this.game = game;
        this.progressBar = progressBar;
        this.redHouses = new ArrayList<>();
        this.blueHouse = new ArrayList<>();
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
        this.count = blueUnit + redUnit;
        return blueUnit;
    }

    @Override
    public void run() {
        do {
            this.redHouses.clear();
            this.blueHouse.clear();
            this.count = 0;
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(stateOfGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<House> list = this.game.getHouses();
            for(House elem : list) {
                if(elem.getPlayer() != null) {
                    if(elem.getPlayer().getTeam() == Player.TEAM_BLUE) {
                        this.blueHouse.add(elem);
                    } else {
                        this.redHouses.add(elem);
                    }   
                }
            }
            this.progressBar.refreshProgressBar(this.ratioHouse(), this.count);
        } while(this.progressBar.isTwoPlayerAlive());
        System.out.println("Fin du jeu");
    }
    
}
