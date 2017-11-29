/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author juanm
 */
public class panel_Configuracion extends JPanel {

    JButton regresar;
    JRadioButton sonidofondo, efectosonido;
    JComboBox eleccioncolor;

    public panel_Configuracion() {
        this.regresar = new JButton();
        this.sonidofondo = new JRadioButton();
        this.efectosonido = new JRadioButton();
        this.eleccioncolor = new JComboBox(new String[]{"LIGHTGRAY", "GREEN", "ORANGE", "RED", "YELLOW"});
        this.add(this.regresar);
        this.add(this.sonidofondo);
        this.add(this.efectosonido);
        this.add(this.eleccioncolor);
        agregar_componentes();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("src\\imagenes_fondos\\configuracion.jpg");
        g.drawImage(fondo, 0, 0, null);
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    public void agregar_componentes() {
        regresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        regresar.setForeground(new java.awt.Color(255, 255, 255));
        regresar.setText("REGRESAR");
        regresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        regresar.setContentAreaFilled(false);
        efectosonido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        efectosonido.setForeground(new java.awt.Color(255, 255, 255));
        efectosonido.setText("EFECTOS DE SONIDO");
        efectosonido.setContentAreaFilled(false);

        sonidofondo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sonidofondo.setForeground(new java.awt.Color(255, 255, 255));
        sonidofondo.setText("SONIDO DE FONDO");
        sonidofondo.setContentAreaFilled(false);

        eleccioncolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eleccioncolor.setForeground(new java.awt.Color(0, 153, 153));
        eleccioncolor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(sonidofondo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                .addComponent(efectosonido)
                                .addGap(151, 151, 151))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(310, 310, 310)
                                                .addComponent(eleccioncolor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(efectosonido)
                                        .addComponent(sonidofondo))
                                .addGap(101, 101, 101)
                                .addComponent(eleccioncolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(153, Short.MAX_VALUE))
        );
    }
}
