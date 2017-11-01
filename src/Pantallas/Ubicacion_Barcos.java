/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import programa.*;
/**
 *
 * @author juanm
 */
public class Ubicacion_Barcos extends javax.swing.JPanel implements MouseListener {
    private  int xref=370;
    private  int yref=100;
    private  int tam_cuadrado=30;
    private boolean orientacion;
    private int xx,yy;
    private int tam=3;
    private Coordenada c;
 
    
   public void paintComponent(Graphics g) {
        initComponents();
        super.paintComponent(g);
        dibujarEscenario(g);   
    }

    public Ubicacion_Barcos() {
        this.addMouseListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        regresar = new javax.swing.JButton();
        verticall = new javax.swing.JRadioButton();
        horizontal = new javax.swing.JRadioButton();

        regresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        regresar.setForeground(new java.awt.Color(255, 255, 255));
        regresar.setText("REGRESAR");
        regresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        regresar.setContentAreaFilled(false);

        verticall.setText("vertical");
        verticall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticallActionPerformed(evt);
            }
        });

        horizontal.setText("horizontal");
        horizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horizontalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(horizontal)
                    .addComponent(verticall)
                    .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(611, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(verticall)
                .addGap(18, 18, 18)
                .addComponent(horizontal)
                .addContainerGap(310, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    private void verticallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verticallActionPerformed
        this.orientacion=true;
    }//GEN-LAST:event_verticallActionPerformed

    private void horizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horizontalActionPerformed
        this.orientacion=false;
    }//GEN-LAST:event_horizontalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton horizontal;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton regresar;
    private javax.swing.JRadioButton verticall;
    // End of variables declaration//GEN-END:variables
  
    
    private void dibujarEscenario(Graphics g) {
        Graphics2D c = (Graphics2D) g; 
        Image fondo = loadImage("fondo_partida.jpg");
        c.drawImage(fondo, 0, 0, null);
        c.setColor(Color.WHITE);
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){ 
                c.drawRect(xref+(i*this.tam_cuadrado),yref+(j*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);  
            }
        }
        for(int i=0;i<this.tam;i++){
            if(orientacion){
                c.setColor(Color.red);
                c.fillRect(xx+(i*this.tam_cuadrado), yy, this.tam_cuadrado, this.tam_cuadrado);
            }else{
                c.fillRect(xx, yy+(i*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);
            }
        }
    }
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    //CREAR TABLERO
    Coordenada ct= new Coordenada(this.xref,this.yref);   
    Tablero tablero1= new Tablero(ct,this.tam_cuadrado); 
     
    @Override
    public void mouseClicked(MouseEvent e) {
        tablero1.crear_barco(e.getPoint(), orientacion, tam);
        System.out.println(e.getX()+" "+e.getY());
        xx=e.getX();
        yy=e.getY();
        this.repaint();
        for(int i=0;i<3;i++){
            System.out.println(" X"+tablero1.getbarco(tablero1.getbarcos_creados()-1).cabezaX());
            System.out.println(" Y"+tablero1.getbarco(tablero1.getbarcos_creados()-1).cabezaY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }
    
}
