/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import programa.Coordenada;
import programa.Tablero;
import programa.Cuadro;
/**
 *
 * @author juanm
 */
public class Panel_3 extends JPanel implements MouseListener {

    
    private  int xref=370;
    private  int yref=100;
    private  int tam_cuadrado=30;
    private boolean orientacion;
    private int x_aux,y_aux;
    private int tam=5;
    private Coordenada c;
    
    Coordenada ct= new Coordenada(this.xref,this.yref);   
    Tablero tablero1= new Tablero(ct,this.tam_cuadrado);
    
    JButton REGRESAR = new JButton("REGRESAR");
    JRadioButton vertical = new JRadioButton("VERTICAL");
    JRadioButton horizontal = new JRadioButton("HORIZONTAL");
    ButtonGroup grupo1= new ButtonGroup();
   
    public Panel_3() {
        grupo1.add(vertical);
        grupo1.add(horizontal);
        REGRESAR.setSize(200, 100);
        REGRESAR.setLocation(300,300);
        REGRESAR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        REGRESAR.setContentAreaFilled(false);
        this.addMouseListener(this);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarEscenario(g);   
    }
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
       }
       
    public Coordenada cabeza(Point p){
        Coordenada cabeza= new Coordenada(0,0);
        Cuadro[][] aux= tablero1.getCuadrados();;    
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){       
                if(aux[i][j].getRectangulo().contains(p)){
                    cabeza=aux[i][j].getCoordenada();
                }
            }
        }
        return cabeza;
    }
       
       private void pinta_provicional(Graphics g){
           Graphics2D c = (Graphics2D) g; 
           for(int i=0;i<this.tam;i++){
            if(orientacion){
                c.setColor(Color.red);
                c.fillRect(x_aux+(i*this.tam_cuadrado), y_aux, this.tam_cuadrado, this.tam_cuadrado);
            }else{
                c.fillRect(x_aux, y_aux+(i*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);
            }
        }
       }
        
    
    public void eleccion_orientacion(){
        if(vertical.isSelected()){
            this.orientacion= true;
        }
        if(horizontal.isSelected()){
            this.orientacion= false;
        }
    }
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      Coordenada aux= cabeza(e.getPoint());
      if(tablero1.cabe_barco(aux,this.tam,this.orientacion)&&(aux.getX()>=this.xref) && (aux.getY()>=this.yref &&
         (aux.getX()<=(this.xref+(10*this.tam_cuadrado))) && (aux.getY()>=(this.xref+(10*this.tam_cuadrado))))){
        this.x_aux=aux.getX();
        this.y_aux=aux.getY();
          System.out.println("x= "+this.x_aux+" y= "+ this.y_aux);
      }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
