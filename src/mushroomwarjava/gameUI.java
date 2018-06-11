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
import javax.swing.JPanel;

/**
 *
 * @author Jonathan Germain
 */
public class gameUI extends javax.swing.JFrame {
    
    public static int MAX_UNITIES_SPAWNABLE = 300;
    private List<House> housesOfGame;
    private List<Unity> redUnit;
    private List<Unity> blueUnit;
    private Player actionPlayer;
    private botIA bot;
    private targetHouse targetAttack;
    private stateOfGame progressGame;
    
    /**
     * Creates new form gameUI
     */
    public gameUI() {
        initComponents();
        initGame();
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
        unitiesProgessBar1 = new component.UnitiesProgessBar();
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
        setMaximumSize(new java.awt.Dimension(1095, 610));
        setMinimumSize(new java.awt.Dimension(1095, 610));
        setResizable(false);
        setSize(new java.awt.Dimension(1095, 610));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(1095, 610));
        jPanel1.setMinimumSize(new java.awt.Dimension(1095, 610));
        jPanel1.setLayout(null);

        unitiesProgessBar1.setColor1(java.awt.Color.blue);
        unitiesProgessBar1.setColor2(java.awt.Color.red);
        unitiesProgessBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(unitiesProgessBar1);
        unitiesProgessBar1.setBounds(400, 0, 300, 15);
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
    
    public JPanel getActiveStateGame() {
        return this.jPanel1;
    }
    
    public void gameBegin() {
        this.progressGame.start();
    }
    
    private void chooseSpawn() {
        if(this.actionPlayer.getTeam() == Player.TEAM_BLUE) {
            this.bot = new botIA(Player.TEAM_RED, "IA", this);
            this.spawnBlue.setPlayer(this.actionPlayer);
            this.spawnRed.setPlayer(this.bot);
            this.bot.intelligenceStart();
            for(int i = 0; i < 10; i++) {
                this.spawnBlue.addUnit(new Unity(this.actionPlayer));
                this.spawnRed.addUnit(new Unity(this.bot));
            }
        } else {
            this.bot = new botIA(Player.TEAM_BLUE, "IA", this);
            this.spawnRed.setPlayer(this.actionPlayer);
            this.spawnBlue.setPlayer(this.bot);
            this.bot.intelligenceStart();
            for(int i = 0; i < 10; i++) {
                this.spawnRed.addUnit(new Unity(this.actionPlayer));
                this.spawnBlue.addUnit(new Unity(this.bot));
            }
        }
    }
    
    public void addUnitToGame(Unity unit, int x, int y, House target) {
        if(unit.getPlayer().getTeam() == Player.TEAM_BLUE) {
            this.setBlueUnit(unit);
        } else {
            this.setRedUnit(unit);
        }
        jPanel1.add(unit);
        jPanel1.setComponentZOrder(unit, 0);
        unit.setLocation(x, y);
        this.goToAttackedHouse(unit, target);
    }
    
    private void goToAttackedHouse(Unity unit, House target) {
        this.targetAttack = new targetHouse(this.jPanel1, unit, target);
        this.targetAttack.start();
    }
    
    private void initGame() {
        this.housesOfGame = new ArrayList<>();
        this.blueUnit = new ArrayList<>();
        this.redUnit = new ArrayList<>();
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
        this.progressGame = new stateOfGame(this, unitiesProgessBar1);
    } 
        
    public int getCountUnitiesOfTheGame() {
        return (this.blueUnit.size() + this.redUnit.size());
    }
    
    public int getBlueUnities() {
        return this.blueUnit.size();
    }
    
    public int getRedUnities() {
        return this.redUnit.size();
    }

    public void setRedUnit(Unity redUnit) {
        this.redUnit.add(redUnit);
    }
    
    private void removeRedUnit(Unity unit) {
        this.redUnit.remove(this.redUnit.size()-1);
    }
 
    public void setBlueUnit(Unity blueUnit) {
        this.blueUnit.add(blueUnit);
    }
    
    private void removeBlueUnit() {
        this.blueUnit.remove(this.blueUnit.size()-1);
    }
    
    public void removeFromUnitList(Unity unit) {
        if(unit.getPlayer().getTeam() == Player.TEAM_BLUE) {
            this.removeBlueUnit();
        } else {
            this.removeRedUnit(unit);
        }
    }
    
    public void endOfTheGame(int TeamWinner) {
        new GameOver(this, TeamWinner).setVisible(true);
        for(House elem: this.housesOfGame) {
            elem.destroyGeneration();
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
    private component.UnitiesProgessBar unitiesProgessBar1;
    // End of variables declaration//GEN-END:variables
}
