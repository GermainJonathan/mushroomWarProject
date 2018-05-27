/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import component.Unity;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Germain
 */
public class gameUI extends javax.swing.JFrame {
    
    public static int MAX_UNITIES_SPAWNABLE = 300;
    private List<House> housesOfGame;
    private Player playerRed;
    private Player playerBlue;
    private Player actionPlayer;
    
    /**
     * Creates new form gameUI
     */
    public gameUI() {
        initComponents();
        initGame();
        initPlayers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        unitiesProgessBar2 = new component.UnitiesProgessBar();
        spawnBlue = new component.House();
        spawnRed = new component.House();
        house7 = new component.House();
        house6 = new component.House();
        house5 = new component.House();
        house4 = new component.House();
        house3 = new component.House();
        house2 = new component.House();
        house1 = new component.House();
        map = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mushroom War Java Project");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/mushroomwarjava/assets/mushroomWarIcon.gif")));
        setMinimumSize(new java.awt.Dimension(1095, 610));
        setResizable(false);
        setSize(new java.awt.Dimension(1095, 610));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(1095, 610));
        jPanel1.setMinimumSize(new java.awt.Dimension(1095, 610));
        jPanel1.setLayout(null);

        unitiesProgessBar2.setBackground(java.awt.Color.red);
        unitiesProgessBar2.setForeground(java.awt.Color.green);
        unitiesProgessBar2.setToolTipText("");
        jPanel1.add(unitiesProgessBar2);
        unitiesProgessBar2.setBounds(410, 0, 300, 15);
        jPanel1.add(spawnBlue);
        spawnBlue.setBounds(30, 10, 64, 90);
        jPanel1.add(spawnRed);
        spawnRed.setBounds(890, 500, 64, 90);
        jPanel1.add(house7);
        house7.setBounds(330, 40, 64, 90);
        jPanel1.add(house6);
        house6.setBounds(60, 300, 64, 90);
        jPanel1.add(house5);
        house5.setBounds(620, 350, 64, 90);
        jPanel1.add(house4);
        house4.setBounds(1020, 300, 64, 90);
        jPanel1.add(house3);
        house3.setBounds(740, 40, 64, 90);
        jPanel1.add(house2);
        house2.setBounds(550, 170, 64, 90);
        jPanel1.add(house1);
        house1.setBounds(310, 480, 64, 90);

        map.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/map.jpg"))); // NOI18N
        map.setToolTipText("");
        map.setAlignmentY(0.0F);
        map.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        map.setName(""); // NOI18N
        jPanel1.add(map);
        map.setBounds(0, 0, 1095, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gameUI().setVisible(true);
            }
        });
    }

    public void setActionPlayer(Player playable) {
        this.actionPlayer = playable;
        this.chooseSpawn();
    }
    
    public Player getActionPlayer() {
        return this.actionPlayer;
    }
    
    public List<House> getHouses() {
        return this.housesOfGame;
    }
    
    private void chooseSpawn() {
        if(this.actionPlayer.getTeam() == Player.TEAM_BLUE) {
            this.spawnRed.addUnit(new Unity()); // Reglage du compteur d'unité
            this.spawnBlue.setPlayer(this.actionPlayer);
        } else {
            this.spawnBlue.addUnit(new Unity());
            this.spawnRed.setPlayer(this.actionPlayer);
        }
    }
    
    public void addUnitToGame(Unity unit, int x, int y) {
        jPanel1.add(unit);
        jPanel1.setComponentZOrder(unit, 0);
        unit.setLocation(x, y);
        this.goToAttackedHouse(unit);
    }
    
    private void goToAttackedHouse(Unity unit) {
        new targeHouse();
    }
    
    private void initPlayers() {
        this.playerRed = new Player(Player.TEAM_RED, "redPlayer");
        this.playerBlue = new Player(Player.TEAM_BLUE, "bluePlayer");  
        this.spawnBlue.setPlayer(this.playerBlue);
        this.spawnBlue.setUnit(10);
        this.spawnRed.setPlayer(this.playerRed);
        this.spawnRed.setUnit(10);
    }
    
    private void initGame() {
        this.housesOfGame = new ArrayList<>();
        this.housesOfGame.add(house1);
        this.housesOfGame.add(house2);
        this.housesOfGame.add(house3);
        this.housesOfGame.add(house4);
        this.housesOfGame.add(house5);
        this.housesOfGame.add(house6);
        this.housesOfGame.add(house7);
        this.housesOfGame.add(spawnBlue);
        this.housesOfGame.add(spawnRed);
        for(House elem: housesOfGame) {
            elem.setupGame(this);
        }
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.House house1;
    private component.House house2;
    private component.House house3;
    private component.House house4;
    private component.House house5;
    private component.House house6;
    private component.House house7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel map;
    private component.House spawnBlue;
    private component.House spawnRed;
    private component.UnitiesProgessBar unitiesProgessBar2;
    // End of variables declaration//GEN-END:variables
}
