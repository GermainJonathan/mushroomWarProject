/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

/**
 *
 * @author Jonathan Germain
 */
public class UnitiesProgessBar extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public UnitiesProgessBar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(300, 15));
        setMinimumSize(new java.awt.Dimension(300, 15));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(300, 15));
        setLayout(new java.awt.BorderLayout());

        jProgressBar1.setBackground(new java.awt.Color(255, 0, 0));
        jProgressBar1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jProgressBar1.setToolTipText("");
        jProgressBar1.setValue(50);
        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jProgressBar1.setOpaque(true);
        add(jProgressBar1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
