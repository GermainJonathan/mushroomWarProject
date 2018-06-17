/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import component.Unity;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Générateur d'unité associé à une maison
 * @author Jonathan Germain
 */
public class GenerateUnity extends Thread {
    
    /**
     * Instance du jeu en cours
     */
    private gameUI game;
    
    /**
     * Maison rattaché au thread de génération d'unité
     */
    private House currentHouse;
    
    /**
     * Boolean permettant d'arrêter le Thread
     */
    private boolean isRun;
    
    /**
     * Constructeur
     * @param currentHouse Maison associé à la génération
     * @param game instance du jeu en cours
     */
    public GenerateUnity(House currentHouse, gameUI game) {
        this.currentHouse = currentHouse;
        this.game= game;
        this.isRun = true;
    }
    
    /**
     * Arrêt du thread
     */
    public void stopGenerate() {
        this.isRun = false;
    }
    
    /**
     * Tentative de redemarage du thread
     * Permet de supprimer une unitée sans recréer de thread lors d'une attaque
     */
    public void restartGenerate() {
        this.isRun = true;
    }
    
    /**
     * Action du thread
     */
    @Override
    public void run() {
        while(this.isRun) {
            if(this.currentHouse.getCountUnitiesOfTheGame() < gameUI.MAX_UNITIES_SPAWNABLE) {
                /**
                 * Si le nombre d'unité en jeu est inférieur à 300 on génère une unité par seconde
                 */
                int playerTeam = this.currentHouse.getPlayer().getTeam();
                Unity unit = new Unity(this.currentHouse.getPlayer());
                this.currentHouse.addUnit(unit);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(House.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
        }
    }
    
}
