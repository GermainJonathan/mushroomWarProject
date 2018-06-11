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
import mushroomwarjava.Circle;
import mushroomwarjava.GenerateUnity;
import mushroomwarjava.Player;
import mushroomwarjava.gameUI;

/**
 *
 * @author Jonathan Germain
 */
public class House extends javax.swing.JPanel {

    private gameUI game;
    private Player currentPlayer;
    private boolean isSelected = false;
    private List<Unity> unities;
    private boolean unitiesBusy = false;
    private GenerateUnity generation;
    private Circle hitBox;
    
    /**
     * Creates new form House
     */
    public House() {
        initComponents();
        this.unities = new ArrayList<>();
    }
    
    public void setScore(int score) {
        this.countHouse.setText(score + "");
        
    }
    
    public void setUnit(int nbUnities) {
        for(int i =0 ;i < nbUnities; i++) {
            this.unities.add(new Unity(this.currentPlayer));
        }
    }
    
    public void setupGame(gameUI game) {
        this.game = game;
    }
    
    public int getCountUnitiesOfTheGame() {
        return this.game.getCountUnitiesOfTheGame();
    }
    
    public void setPlayer(Player p) {
        this.currentPlayer = p;
        if(this.currentPlayer.getTeam() == Player.TEAM_BLUE) {
            mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueMushroom.png"))); // NOI18N
        } else {
            mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redMushroom.png"))); // NOI18N
        }
        if(this.generation != null) {
            this.destroyGeneration();
        }
        this.generation = new GenerateUnity(this, this.game);
        this.generation.start();
    }
   
    public Player getPlayer() {
        return this.currentPlayer;
    }
    
    public boolean isOnHitbox(Unity unit) {
        return this.hitBox.contains(unit.getX(), unit.getY());
    }
    
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
    
    public List<Unity> getUnities() {
        return this.unities;
    }
    
    public void refreshScore() {
        this.countHouse.setText(this.unities.size() + "");
    }
    
    public void destroyGeneration() {
        if(this.generation != null) {
            this.generation.stopGenerate();
        }
    }
    
    public void restartGeneration() {
        this.generation.restartGenerate();
    }
    
    public Point setRandomSpawn(House source) {
        Point spawn = new Point((source.getLocation().x + 30), (source.getLocation().y + 60));
        Random rdm = new Random();
        double angleRad = rdm.nextDouble() * (Math.PI * 2);
        double x = (spawn.x + 30 * Math.cos(angleRad));
	double y = (spawn.y + 30 * Math.sin(angleRad));
        spawn.setLocation(x, y);
        return spawn;
    }
    
    public void isAttackBy(Unity unit) {       
        if(this.unities.size() == 0) {
            this.setPlayer(unit.getPlayer());
        }
        this.addUnit(unit); 
        unit.setVisible(false);
        this.game.getActiveStateGame().remove(unit); // suppression de l'entité
        this.game.removeFromUnitList(unit);
    }
    
    public void unSelectHouse() {
        this.isSelected = false;
        if(this.currentPlayer.getTeam() == Player.TEAM_BLUE) {
            mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueMushroom.png"))); // NOI18N
        } else {
            mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redMushroom.png"))); // NOI18N
        }
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height){
        super.setBounds(x, y, width, height);
        this.hitBox = new Circle(this.getX(), this.getY(), this.getWidth());
    }
    
    public void isTarget(House source) {
        source.destroyGeneration();
        try {
            for(int i = 0; i < source.getUnities().size(); i++) {
               Point spawn;
               spawn = setRandomSpawn(source);
               Unity elem = source.getUnities().get(i);
               this.game.addUnitToGame(elem, spawn.x, spawn.y, this);
           }
        } catch(ConcurrentModificationException e) {
            System.out.println(e.getMessage());
        }
        source.getUnities().clear();
        source.refreshScore();
        source.restartGeneration();
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

    private void mushroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mushroomMouseClicked
        // TODO add your handling code here:
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

    private void mushroomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mushroomMousePressed
        // TODO add your handling code here:
        if(evt.getButton() == 3 && this.game.getActionPlayer().getSelectedHouse() != this) {
            this.isTarget(this.game.getActionPlayer().getSelectedHouse());
        }
    }//GEN-LAST:event_mushroomMousePressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countHouse;
    private javax.swing.JLabel mushroom;
    // End of variables declaration//GEN-END:variables
}
