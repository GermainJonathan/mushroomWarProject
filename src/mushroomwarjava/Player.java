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
 * @author Jonathan Germain
 */
public class Player {
    
    public static int TEAM_RED = 0;
    public static int TEAM_BLUE = 1;
    protected final int team;
    protected final String name;
    
    protected List<House> houses;
    protected House selectedHouse;

    public Player(int team, String name) {
        this.houses = new ArrayList<>();
        this.team = team;
        this.name = name;
    }
    
    public int getUnities() {
        int compt = 0;
        for(House elem : houses) {
            compt += elem.getUnities().size();
        }
        return compt;
    }

    public int getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public void addHouse(House theMaison) {
        this.houses.add(theMaison);
    }
    
    public House getSelectedHouse() {
        return this.selectedHouse;
    }
    
    public void setHouseSelected(House selection) {
        if(this.selectedHouse != null) {
            this.selectedHouse.unSelectHouse();
        }
        this.selectedHouse = selection;
    }
    
    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
