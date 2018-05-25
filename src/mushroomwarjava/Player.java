/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.Unity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Germain
 */
public class Player {
    
    public static int TEAM_RED = 0;
    public static int TEAM_BLUE = 1;
    private final int team;
    private final String name;
    
    private List<Unity> unities;

    public Player(int baseUnities, int team, String name) {
        this.unities = new ArrayList<>();
        for(int i = 0; i < baseUnities; i++) {
            this.unities.add(new Unity(this));
        }
        this.team = team;
        this.name = name;
    }
    
    public int getUnities() {
        return unities.size();
    }

    public void setUnities(int unities) {
        for(int i =0; i<unities; i++) {
            this.unities.add(new Unity(this));
        }
    }


    public int getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
