/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Point;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import mushroomwarjava.Circle;
import mushroomwarjava.GenerateUnity;
import mushroomwarjava.Player;
import mushroomwarjava.gameUI;

/**
 * Composant Maison
 * @author Jonathan Germain
 */
public class House extends javax.swing.JPanel {

    /**
     * Instance de la partie en cours
     */
    private gameUI game;
    
    /**
     * Joueur possédant la maison
     */
    private Player currentPlayer;
    
    /**
     * Boolean indiquant si la maison est sélectionnée pas le joueur
     */
    private boolean isSelected = false;
    
    /**
     * Liste d'unitées contenant dans la maison
     */
    private List<Unity> unities;
    
    /**
     * Thread générant les unitées
     */
    private GenerateUnity generation;
    
    /**
     * Composant graphique gérant la hitbox de la maison
     */
    private Circle hitBox;
    
    /**
     * Creates new form House
     */
    public House() {
        initComponents();
        this.unities = new ArrayList<>();
    }
    
    /**
     * Mets à jour le nombre d'unitées de la maison
     * @param score Score à afficher
     */
    public void setScore(int score) {
        this.countHouse.setText(score + "");
    }
    
    /**
     * Permet d'ajouter plusieurs unitées à la maison
     * @param nbUnities nombre d'unitées à ajouter à la maison
     */
    public void setUnit(int nbUnities) {
        for(int i =0 ;i < nbUnities; i++) {
            this.unities.add(new Unity(this.currentPlayer));
        }
    }
    
    /**
     * Appelé à l'intialisation du jeu
     * Permet d'associer l'instance de la partie à la maison
     * @param game instance de la partie
     */
    public void setupGame(gameUI game) {
        this.game = game;
    }
    
    /**
     * Appelé par le thread de génération d'unité
     * Permet d'avoir le nombre d'unitées en jeu
     * @return Nombre d'unitées en jeu
     */
    public int getCountUnitiesOfTheGame() {
        return this.game.getCountUnitiesOfTheGame();
    }
    
    /**
     * Permet d'associé un joueur à la maison
     * @param p Joueur
     */
    public void setPlayer(Player p) {
        this.currentPlayer = p;
        if(this.currentPlayer.getTeam() == Player.TEAM_BLUE) {
            mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueMushroom.png"))); // NOI18N
        } else {
            mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redMushroom.png"))); // NOI18N
        }
        // Si il existe une instance de génération on l'a détruit puis on en recréer une dans tous les cas
        if(this.generation != null) {
            this.destroyGeneration();
        }
        this.generation = new GenerateUnity(this, this.game);
        this.generation.start();
    }
   
    /**
     * Renvoie le joueur associé à la maison
     * @return Joueur associé à la maison
     */
    public Player getPlayer() {
        return this.currentPlayer;
    }
    
    /**
     * Test sur la hitbox de la maison
     * @param unit Unité à tester
     * @return  Vrai si l'untié est contenue dans la hitbox
     */
    public boolean isOnHitbox(Unity unit) {
        return this.hitBox.contains(unit.getX(), unit.getY());
    }
    
   /**
    * Ajout une unitée à la maison
    * @param newUnit  unité à ajouter à la maison
    */
    public void addUnit(Unity newUnit) {
        if(newUnit.getPlayer() == this.currentPlayer) {
            this.unities.add(newUnit);
        } else {
            if(this.currentPlayer == null) {
                this.setPlayer(newUnit.getPlayer());
            } else {
                this.unities.remove(this.unities.size()-1);
            }
        }
        this.refreshScore();
    }
    
    /**
     * Renvoie la liste d'unitée de la maison
     * @return La liste d'untiées de cette maison
     */
    public List<Unity> getUnities() {
        return this.unities;
    }
    
    /**
     * Rafraichi le score d'unité de la maison
     */
    public void refreshScore() {
        this.countHouse.setText(this.unities.size() + "");
    }
    
    /**
     * Détruit le thread de génération d'unité
     */
    public void destroyGeneration() {
        if(this.generation != null) {
            this.generation.stopGenerate();
        }
    }
    
    /**
     * Reprend la génération d'unité
     * Appelé lors de l'attaque d'une maison
     */
    public void restartGeneration() {
        if(this.generation != null) {
            this.generation.restartGenerate();
        }            
    }
    
    /**
     * Permet relancé la génération d'unité après une pause dans le jeu
     */
    public void pauseGeneration() {
        if(this.generation != null) {
            this.generation = new GenerateUnity(this, this.game);
            this.generation.start();            
        }
    }
    
    /**
     * Permet de définir un point de spawn pour une unité
     * @param source Maison attaquante
     * @return Renvoie un point qui servira de spawn à une unité
     */
    public Point setRandomSpawn(House source) {
        // On récupère le centre de la maison source
        Point spawn = new Point((source.getLocation().x + 30), (source.getLocation().y + 60));
        Random rdm = new Random();
        // On calcule une angle aléatoire
        double angleRad = rdm.nextDouble() * (Math.PI * 2);
        // on calcule les coordonnées du point dans un rayon de 30 pixels
        // autour du centre la maison à l'aide de l'angle aléatoire calculé precedement 
        double x = (spawn.x + 30 * Math.cos(angleRad));
	double y = (spawn.y + 30 * Math.sin(angleRad));
        spawn.setLocation(x, y);
        return spawn;
    }
    
    /**
     * Action lorsqu'une unité attaquante arrive à destination
     * @param unit Unité attaquante
     * @param id Numéro du thread de Mouvement
     */
    public void isAttackBy(Unity unit, int id) {   
        // Si la maison est vide on associe le joueur attaquant
        if(this.unities.isEmpty()) {
            this.setPlayer(unit.getPlayer());
        }
        this.addUnit(unit);
        unit.setVisible(false);
        this.game.getActiveStateGame().remove(unit); // suppression de l'entité
        this.game.removeFromUnitList(unit); // suppression de l'untié
        this.game.removeFromThreadList(id); // suppression du thread de mouvement
    }
    
    /**
     * Désélection d'une maison
     */
    public void unSelectHouse() {
        this.isSelected = false;
        if(this.currentPlayer.getTeam() == Player.TEAM_BLUE) {
            mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueMushroom.png"))); // NOI18N
        } else {
            mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redMushroom.png"))); // NOI18N
        }
    }
    
    /**
     * Permet de créer la hitbox de la maison
     * @param x position x
     * @param y position y
     * @param width Largeur 
     * @param height Hauteur
     */
    @Override
    public void setBounds(int x, int y, int width, int height){
        super.setBounds(x, y, width, height);
        this.hitBox = new Circle(this.getX(), this.getY(), this.getWidth());
    }
    
    /**
     * Actions réalisées lors d'une attaque
     * @param source Maison attaquante
     */
    public void isTarget(House source) {
        source.destroyGeneration(); // On arrete le thread de la maison attaquante
        try {
            // On définit des points de spawn pour chaque unitées de la maison attaquante
            // Puis on les ajoutes au jeu via l'instance de la partie en cours
            for(int i = 0; i < source.getUnities().size(); i++) {
               Point spawn;
               spawn = setRandomSpawn(source);
               Unity elem = source.getUnities().get(i);
               this.game.addUnitToGame(elem, spawn.x, spawn.y, this);
           }
        } catch(ConcurrentModificationException e) {
            System.out.println(e.getMessage());
        }
        source.getUnities().clear(); // On vide la liste d'unité de la maison attaquant
        source.refreshScore(); // On rafraîchi le score d'unité de la maison attaquant
        source.restartGeneration(); // On redémarre la génération d'unité de la maison attaquante
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        countHouse = new javax.swing.JLabel();
        mushroom = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(64, 90));
        setMinimumSize(new java.awt.Dimension(64, 90));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(64, 90));
        setLayout(new java.awt.BorderLayout(0, 10));

        countHouse.setBackground(new java.awt.Color(255, 255, 255));
        countHouse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countHouse.setText("0");
        countHouse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        countHouse.setMaximumSize(new java.awt.Dimension(6, 20));
        countHouse.setMinimumSize(new java.awt.Dimension(6, 20));
        countHouse.setOpaque(true);
        countHouse.setPreferredSize(new java.awt.Dimension(6, 20));
        add(countHouse, java.awt.BorderLayout.PAGE_START);

        mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/emptyMushroom.png"))); // NOI18N
        mushroom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mushroom.setMaximumSize(new java.awt.Dimension(64, 90));
        mushroom.setMinimumSize(new java.awt.Dimension(64, 90));
        mushroom.setPreferredSize(new java.awt.Dimension(64, 90));
        mushroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mushroomMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mushroomMousePressed(evt);
            }
        });
        add(mushroom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Evenement lors du click sur une maison
     * @param evt Evenement
     */
    private void mushroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mushroomMouseClicked
        if(this.currentPlayer != null && this.game.getActionPlayer() == this.currentPlayer) {
            if(this.currentPlayer.getTeam() == Player.TEAM_BLUE) {
                if(!this.isSelected) {
                    this.isSelected = true;
                    mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueMushroomActive.png"))); // NOI18N
                    this.game.getActionPlayer().setHouseSelected(this);
                } else {
                    this.isSelected = false;
                    this.game.getActionPlayer().setHouseSelected(null);
                    mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueMushroom.png"))); // NOI18N
                }
            }
            if(this.currentPlayer.getTeam() == Player.TEAM_RED) {
                if(!this.isSelected) {
                    mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redMushroomActive.png"))); // NOI18N
                    this.isSelected = true;
                    this.game.getActionPlayer().setHouseSelected(this);
                } else {
                    mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redMushroom.png"))); // NOI18N
                    this.isSelected = false;
                }
            }           
        }
    }//GEN-LAST:event_mushroomMouseClicked

    /**
     * Evenement lors d'un click droit sur une maison
     * @param evt Evenement
     */
    private void mushroomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mushroomMousePressed
        if(evt.getButton() == 3 && this.game.getActionPlayer().getSelectedHouse() != this && this.game.getActionPlayer().getSelectedHouse() != null) {
            this.isTarget(this.game.getActionPlayer().getSelectedHouse());
        }
    }//GEN-LAST:event_mushroomMousePressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countHouse;
    private javax.swing.JLabel mushroom;
    // End of variables declaration//GEN-END:variables
}
