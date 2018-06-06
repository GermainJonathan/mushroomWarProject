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
        if(this.getHouses().size() != 0) {
            alive = true;
        }
        return alive;
    }
}
