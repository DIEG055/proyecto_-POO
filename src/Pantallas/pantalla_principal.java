/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author juanm
 */
public class pantalla_principal extends javax.swing.JPanel {

    /**
     * Creates new form pantalla_principal
     */
    public pantalla_principal() {
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

        iniciar_partida = new javax.swing.JButton();

        iniciar_partida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        iniciar_partida.setForeground(new java.awt.Color(255, 255, 255));
        iniciar_partida.setText("INICIAR PARTIDA");
        iniciar_partida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        iniciar_partida.setContentAreaFilled(false);
        iniciar_partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciar_partidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(iniciar_partida, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(iniciar_partida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void iniciar_partidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciar_partidaActionPerformed
     Eleccion_partida x= new Eleccion_partida();
     x.setVisible(true);
     pantalla_principal.this.setVisible(false);
    }//GEN-LAST:event_iniciar_partidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciar_partida;
    // End of variables declaration//GEN-END:variables

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("pantalla_inicio.png");
        g.drawImage(fondo, 0, 0, null);
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
 
}