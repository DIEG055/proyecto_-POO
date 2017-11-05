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
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import programa.Coordenada;
import programa.Tablero;
import programa.Cuadro;
/**
 *
 * @author juanm
 */
public class Panel_3_1 extends JPanel implements MouseListener {
    
    private  int xref=380;
    private  int yref=100;
    private  int tam_cuadrado=30;
    private boolean orientacion= true;
    private int x_aux,y_aux;
    private int tam=0;
    private Coordenada c;
    private int t[]= new int[5];
    private boolean puesto=false;
    private Coordenada ct= new Coordenada(this.xref,this.yref);   
    Tablero tablero1= new Tablero(ct,this.tam_cuadrado);
    private  boolean prueba= true;
    
    JButton REGRESAR = new JButton("REGRESAR");
    JButton poner = new JButton("Poner barco");
    JButton COMENZAR = new JButton("JUGADOR 1");
    JRadioButton vertical = new JRadioButton("VERTICAL");
    JRadioButton horizontal = new JRadioButton("HORIZONTAL");
    ButtonGroup grupo1= new ButtonGroup();
    JLabel texto =new JLabel("SELECCIONE EL RECUADRO DONDE QUIERE UBICAR EL BARCO");
    
    public Panel_3_1() {  
       t[0]=5;
       t[1]=4;
       t[2]=3;
       t[3]=3;
       t[4]=2;
        grupo1.add(vertical);
        grupo1.add(horizontal);
        REGRESAR.setSize(200, 100);
        REGRESAR.setLocation(300,300);
        REGRESAR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        REGRESAR.setContentAreaFilled(false);
        COMENZAR.setSize(200, 100);
        COMENZAR.setLocation(300,300);
        COMENZAR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        COMENZAR.setForeground(new java.awt.Color(255, 255, 255));
        COMENZAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        COMENZAR.setContentAreaFilled(false);
        addMouseListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarEscenario(g);   
        pinta_provicional(g);
    }
    
    private void dibujarEscenario(Graphics g) {
        Graphics2D c = (Graphics2D) g; 
        Image fondo = loadImage("fondo_partida.jpg");
        c.drawImage(fondo, 0, 0, null);
        c.setColor(Color.WHITE);
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(tablero1.getCuadrados()[i][j].isPer_barco()){
                    Coordenada aux= tablero1.getCuadrados()[i][j].getCoordenada();
                    c.fillRect(aux.getX(),aux.getY(), this.tam_cuadrado, this.tam_cuadrado);
                }
                c.drawRect(xref+(i*this.tam_cuadrado),yref+(j*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);  
            }
        }
    }
       
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    private void pinta_provicional(Graphics g){
        Graphics2D c = (Graphics2D) g; 
        c.setColor(Color.ORANGE);
        if(!(this.x_aux==0) && prueba){
        try{
            for(int i=0;i<this.t[tam];i++){
                if(orientacion){
                    c.fillRect(x_aux, y_aux+(i*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);
                }else{
                    c.fillRect(x_aux+(i*this.tam_cuadrado), y_aux, this.tam_cuadrado, this.tam_cuadrado);
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){}
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
       
    public void eleccion_orientacion(){
        if(vertical.isSelected()){
            this.orientacion= true;
        }
        else{
            this.orientacion= false;
        }
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
        this.eleccion_orientacion();
        if(tablero1.crear_barcovf(e.getPoint(), orientacion,t[this.tam])){
            this.x_aux=aux.getX();
            this.y_aux=aux.getY();
            this.prueba=true;
            repaint();
        } 
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
     
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    public void setPuesto(boolean puesto) {
        this.puesto = puesto;
    }
    
    public void poner(){
        Point c= new Point(x_aux,y_aux);
        if(tam<5){
            tablero1.crear_barco(c, orientacion, t[this.tam]); 
            tam++;
        }
        this.prueba=false;
        repaint();      
    }

    
}
