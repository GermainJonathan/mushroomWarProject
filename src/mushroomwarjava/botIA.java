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
 * Joueur factice
 * @author Jonathan
 */
public class botIA extends Player {
    
    /**
     * instance du jeu en cours
     */
    private gameUI game;
    
    /**
     * thread prenant les décisions
     */
    private IA intelligence;
    
    /**
     * constructeur
     * @param team équipe du bot
     * @param name nom du bot ( héritage de Player )
     * @param game instance de la partie
     */
    public botIA(int team, String name, gameUI game) {
        super(team, name);
        this.game = game;
        this.intelligence = new IA(this, this.game);
    }
       
    /**
     * renvoie true si le bot est vivant
     * @return boolean
     */
    public boolean isAlive() {
        boolean alive = false;
        this.parseBotHouse();
        if(this.houses.size() != 0) {
            alive = true;
        }
        return alive;
    }
    
    /**
     * Mise à jour de la liste de Maison du bot
     */
    public void parseBotHouse() {
        this.houses.clear();
        for(House elem: this.game.getHouses()) {
            if(elem.getPlayer() != null) {
                if(elem.getPlayer().getTeam() == this.getTeam()) {
                    this.houses.add(elem);
                }
            }
        }
    }
    
    /**
     * permet de démarré le thread
     */
    public void intelligenceStart() {
        this.intelligence.start();
    }
    
    /**
     * Permet de recréer une instance d'IA
     */
    public void restartIntelligence() {
        this.intelligence = new IA(this, this.game);
        this.intelligenceStart();
    }
    
    /**
     * Arrêt le thread
     */
    public void intelligencePause() {
        this.intelligence.stopIA();
    }
    
    /**
     * Renvoie une Maison si elle est en mesure d'attaquer
     * Si son nombre d'unité est supérieur à 15
     * @return House
     */
    public House houseCanAttack() {
        for(House elem: this.houses) {
            if(elem.getUnities().size() > 15) {
                return elem;
            }
        }
        return null;
    }
}
