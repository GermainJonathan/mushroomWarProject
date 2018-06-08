/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class botIA extends Player {
    
    private gameUI game;
    private IA intelligence;
    
    public botIA(int team, String name, gameUI game) {
        super(team, name);
        this.game = game;
        this.intelligence = new IA(this, this.game);
        this.intelligence.start();
    }
    
    public void attackInGame(House myHouse, House targetHouse) {
        
    }
    
    public boolean isAlive() {
        boolean alive = false;
        this.parseBotHouse();
        if(this.houses.size() != 0) {
            alive = true;
        }
        System.out.println(this.houses.size());
        System.out.println(alive);
        return alive;
    }
    
    public void parseBotHouse() {
        this.houses.clear();
        for(House elem: this.game.getHouses()) {
            System.out.println(elem.getPlayer());
            if(elem.getPlayer() != null) {
                if(elem.getPlayer().getTeam() == this.getTeam()) {
                    this.houses.add(elem);
                }
            }
        }
    }
}
