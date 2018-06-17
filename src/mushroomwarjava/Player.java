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
 * Joueur
 * @author Jonathan Germain
 */
public class Player {
    
    /**
     * Constante permetant la définition des équipes
     * 0 pour l'équipe Rouge
     * 1 pour l'équipe Bleu
     */
    public static int TEAM_RED = 0;
    
    /**
     * Constante permetant la définition des équipes
     * 0 pour l'équipe Rouge
     * 1 pour l'équipe Bleu
     */
    public static int TEAM_BLUE = 1;
    
    /**
     * Equipe du joueur
     */
    protected final int team;
    
    /**
     * Nom du joueur
     */
    protected final String name;
    
    /**
     * Liste des maisons lui appartenant
     */
    protected List<House> houses;
    
    /**
     * Maison selectionné par le joueur
     */
    protected House selectedHouse;

    /**
     * Constructeur
     * @param team Entier couleur de l'équipe
     * @param name Nom du joueur
     */
    public Player(int team, String name) {
        this.houses = new ArrayList<>();
        this.team = team;
        this.name = name;
    }
    
    /**
     * Retourne le nombre total d'unité du joueur
     * @return Entier indiquant le nombre d'unité du joueur
     */
    public int getUnities() {
        int compt = 0;
        for(House elem : houses) {
            compt += elem.getUnities().size();
        }
        return compt;
    }

    /**
     * Retourne l'équipe du joueur
     * @return Entier indiquant l'équipe du joueur
     */
    public int getTeam() {
        return team;
    }

    /**
     * Retourne le nom du joueur
     * @return String indiquant nom du joueur
     */
    public String getName() {
        return name;
    }

    /**
     * Permet d'ajouter une maison à la liste 
     * @param theMaison Maison à ajouter à la liste du joueur
     */
    public void addHouse(House theMaison) {
        this.houses.add(theMaison);
    }
    
    /**
     * Retourne la maison sélectionné par le joueur
     * @return La maison selectionné
     */
    public House getSelectedHouse() {
        return this.selectedHouse;
    }
    
    /**
     * Selection de la maison active
     * @param selection Maison à sélectionner
     */
    public void setHouseSelected(House selection) {
        if(this.selectedHouse != null) {
            this.selectedHouse.unSelectHouse();
        }
        this.selectedHouse = selection;
    }
    
    /**
     * Retourne la liste des maisons du joueur
     * @return Liste de maison du joueur
     */
    public List<House> getHouses() {
        return houses;
    }

    /**
     * Setter de la liste de maisons
     * @param houses 
     */
    public void setHouses(List<House> houses) {
        this.houses = houses;
    }
    
    /**
     * Override de la méthode toString()
     * @return le nom du joueur
     */
    @Override
    public String toString() {
        return name;
    }
    
}
