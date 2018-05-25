/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

/**
 *
 * @author Jonathan Germain
 */
public class Player {
    
    public static int TEAM_RED = 0;
    public static int TEAM_BLUE = 1;
    private final int team;
    private final String name; 
    private int unities;

    public Player(int unities, int team, String name) {
        this.unities = unities;
        this.team = team;
        this.name = name;
    }
    
    public int getUnities() {
        return unities;
    }

    public void setUnities(int unities) {
        this.unities = unities;
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
