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
 * Gestion du déroulement du jeu
 * @author jgermain
 */
public class stateOfGame extends Thread {

    /**
     * Instance de la partie
     */
    private gameUI game;
    
    /**
     * BAr de progression du jeu
     */
    private UnitiesProgessBar progressBar;
    
    /**
     * Liste de maison rouge
     */
    private List<House> redHouses;
    
    /**
     * Liste de maison bleu
     */
    private List<House> blueHouse;
    
    /**
     * Permet d'arreter le thread au cours d'une partie
     */
    private boolean forceFinish;
    
    /**
     * Nombre d'unité total de la partie
     */
    private int count;
    
    /**
     * Constructeur
     * @param game Instance du jeu
     * @param progressBar Bar de progression du jeu
     */
    public stateOfGame(gameUI game, UnitiesProgessBar progressBar) {
        this.game = game;
        this.forceFinish = false;
        this.progressBar = progressBar;
        this.redHouses = new ArrayList<>();
        this.blueHouse = new ArrayList<>();
    }
    
    /**
     * Calcule du nombre d'unité bleu et le nombre d'unité total
     * Permet de mettre à jour la bar de progression
     * @return Entier indiquant le nombre d'unité bleu
     */
    private int ratioHouse() {
        int redUnit = 0;
        int blueUnit = 0;
        for(House elem: this.redHouses) {
            redUnit += elem.getUnities().size();
        }
        for(House elem: this.blueHouse) {
            blueUnit += elem.getUnities().size();
        }
        blueUnit += this.game.getBlueUnities();
        redUnit += this.game.getRedUnities();
        this.count = blueUnit + redUnit;
        return blueUnit;
    }

    /**
     * Déroulement du thread
     */
    @Override
    public void run() {
        // Tant qu'il n'y a pas de gagnant
        do {
            // Initialisation
            this.redHouses.clear();
            this.blueHouse.clear();
            this.count = 0;
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(stateOfGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<House> list = this.game.getHouses(); // On récupère toute les maisons du jeu
            // On trie les maisons rouge et bleu
            for(House elem : list) {
                if(elem.getPlayer() != null) {
                    if(elem.getPlayer().getTeam() == Player.TEAM_BLUE) {
                        this.blueHouse.add(elem);
                    } else {
                        this.redHouses.add(elem);
                    }   
                }
            }
            this.progressBar.refreshProgressBar(this.ratioHouse(), this.count); // Mise à jour de la bar de progression
        } while(!this.progressBar.isTwoPlayerAlive() || this.forceFinish);
        // Action lors de la fin du jeu
        System.out.println("Fin du jeu");
        if(!this.forceFinish) {
            int winner = this.progressBar.whoWin();
            this.game.endOfTheGame(winner);
        }
    }
    
    /**
     * Permet de terminer la partie en cours
     */
    public void stopGame() {
        this.forceFinish = true;
    }
    
}
