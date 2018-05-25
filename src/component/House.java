/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mushroomwarjava.GenerateUnity;
import mushroomwarjava.Player;

/**
 *
 * @author Jonathan Germain
 */
public class House extends javax.swing.JPanel {

    private Player currentPlayer;
    private boolean isSelected = false;
    private List<Unity> unities;
    private GenerateUnity generation;
    
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
    
    public void setPlayer(Player p) {
        this.currentPlayer = p;
        if(this.generation != null) {
            this.destroyGeneration();
        }
        this.generation = new GenerateUnity(this);
        this.generation.start();
    }
   
    public Player getPlayer() {
        return this.currentPlayer;
    }
    
    public void addUnit(Unity newUnit) {
        this.unities.add(newUnit);
        this.refreshScore();
    }
    
    public List<Unity> getUnities() {
        return this.unities;
    }
    
    public void refreshScore() {
        this.countHouse.setText(this.unities.size() + "");
    }
    
    public void destroyGeneration() {
        this.generation.stopGenerate();
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
        });
        add(mushroom, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void mushroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mushroomMouseClicked
        // TODO add your handling code here:
        if(this.currentPlayer != null) {
            if(this.currentPlayer.getTeam() == Player.TEAM_BLUE) {
                if(!this.isSelected) {
                    mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueMushroomActive.png"))); // NOI18N
                    this.isSelected = true;
                } else {
                    mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueMushroom.png"))); // NOI18N
                    this.isSelected = false;
                }
            }
            if(this.currentPlayer.getTeam() == Player.TEAM_RED) {
                if(!this.isSelected) {
                    mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redMushroomActive.png"))); // NOI18N
                    this.isSelected = true;
                } else {
                    mushroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redMushroom.png"))); // NOI18N
                    this.isSelected = false;
                }
            }           
        }
    }//GEN-LAST:event_mushroomMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countHouse;
    private javax.swing.JLabel mushroom;
    // End of variables declaration//GEN-END:variables
}
