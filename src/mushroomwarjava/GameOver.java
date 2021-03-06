/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;
import java.awt.Toolkit;

/**
 *  Fenêtre de fin du jeu
 * @author jgermain
 */
public class GameOver extends javax.swing.JFrame {

    /**
     * instance de la partie qui viens d'être jouée
     */
    private gameUI oldGame;
    
    /**
     * Creates new form GameOver
     */
    public GameOver(gameUI oldGame, int teamWiner) {
        initComponents();
        this.oldGame = oldGame;
        // On affiche l'équipe gagnante
        if(teamWiner == Player.TEAM_BLUE) {
            this.icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/blueWin.jpg")));
        } else {
            this.icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mushroomwarjava/assets/redWin.jpg")));
        }
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
        replay = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Partie terminé");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/mushroomwarjava/assets/mushroomWarIcon.gif")));
        setMaximumSize(new java.awt.Dimension(700, 300));
        setMinimumSize(new java.awt.Dimension(700, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 300));

        jPanel1.setMaximumSize(new java.awt.Dimension(700, 394));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 394));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 394));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

        replay.setText("Rejouer");
        replay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replayActionPerformed(evt);
            }
        });
        jPanel1.add(replay);
        replay.setBounds(110, 220, 120, 40);

        quit.setText("Quitter");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        jPanel1.add(quit);
        quit.setBounds(500, 220, 120, 40);
        jPanel1.add(icon);
        icon.setBounds(0, 0, 700, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evenement lors du click sur le bouton Rejouer
     * @param evt Evenement jouer
     */
    private void replayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replayActionPerformed
        this.setVisible(false);
        this.oldGame.setVisible(false);
        new gameSetting().setVisible(true);
    }//GEN-LAST:event_replayActionPerformed
    /**
     * Evenement lors du click sur le bouton Quitter
     * @param evt Evenement jouer
     */
    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton quit;
    private javax.swing.JButton replay;
    // End of variables declaration//GEN-END:variables
}
