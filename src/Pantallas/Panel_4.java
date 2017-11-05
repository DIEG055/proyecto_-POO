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
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import programa.Coordenada;
import programa.Jugador;
import programa.Maquina;

/**
 *
 * @author juanm
 */
public class Panel_4 extends JPanel implements MouseListener {
    private Jugador jugador01;
    private Jugador jugador02;
    private Maquina maquina;
    private boolean turno; // true para jugador 1, false para jugador2 o la maquina
    private boolean estado; //True si aun se puede jugar, false si no se puede jugar.
    private boolean modo; //True para jugador vs maquina, false para jugador 01 vs jugador 02
    int xref1,xref2,yref1,yref2,tam_cuadrado;
    Coordenada c1,c2;

    public Panel_4(int xref1, int xref2, int yref1, int yref2, int tam_cuadros) {
        this.xref1 = xref1;
        this.xref2 = xref2;
        this.yref1 = yref1;
        this.yref2 = yref2;
        this.tam_cuadrado = tam_cuadros;
        this.c1 = new Coordenada(xref1,yref1);
        this.c2 = new Coordenada(xref2,yref2);
    }
    
    
    
    public Panel_4(Jugador jugador, Maquina maquina){
        this.jugador01 = jugador;
        this.jugador02 = null;
        this.maquina = maquina;
        this.turno= true;
        this.estado= true;
        this.modo = true;
        this.tam_cuadrado=jugador.getTablero().getTamanoCuadrados();
        
        this.c1 = jugador.getTablero().getUbicacionPanel();
        this.c2 = maquina.getTablero().getUbicacionPanel();
        this.xref1 = jugador.getTablero().getUbicacionPanel().getX();
        this.yref1 = jugador.getTablero().getUbicacionPanel().getY();
        this.xref2 = maquina.getTablero().getUbicacionPanel().getX();
        this.yref2 = maquina.getTablero().getUbicacionPanel().getY();
    }
    
    public Panel_4(Jugador jugador01, Jugador jugador02){
        this.jugador01 = jugador01;
        this.jugador02 = jugador02;
        this.maquina = null;
        this.turno= true;
        this.estado= true;
        this.modo = false;
        this.tam_cuadrado=jugador01.getTablero().getTamanoCuadrados();
        
        this.c1 = jugador01.getTablero().getUbicacionPanel();
        this.c2 = jugador02.getTablero().getUbicacionPanel();
        this.xref1 = jugador01.getTablero().getUbicacionPanel().getX();
        this.yref1 = jugador01.getTablero().getUbicacionPanel().getY();
        this.xref2 = jugador02.getTablero().getUbicacionPanel().getX();
        this.yref2 = jugador02.getTablero().getUbicacionPanel().getY();
    }
    
    
    
    
        @Override
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
                c.drawRect(this.xref1+(i*this.tam_cuadrado),this.yref1+(j*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado); 
                c.drawRect(this.xref2+(i*this.tam_cuadrado),this.yref2+(j*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);
            }
        }
        
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
            
            }
        }
        
        
    }
       
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(modo){
            //Aqui usamos la informacion para detectar donde pulso el jugador
            //Pintamos o modificamos donde el usuario jugo
            //Modificamos el golpeado del cuadrado CAMILO
            //Las vidas de los barcos, para saber si ya se acabo el juego o no CAMILO
            
            //Hacemos que la maquina juegue
            //Pintamos o modificamos donde la maquina jugo
            //Modificamos el golpeado del cuadrado
            //Las vidas de los barcos, para saber si ya se acabo el juego o no
        }
        else{
            if(turno){
                //Aqui usamos la informacion para detectar donde pulso el jugador
                //Pintamos o modificamos donde el usuario jugo
                //Modificamos el golpeado del cuadrado
                //Las vidas de los barcos, para saber si ya se acabo el juego o no
                //Cambiamos turno
            }
            else{
                //Aqui usamos la informacion para detectar donde pulso el jugador
                //Pintamos o modificamos donde el usuario jugo
                //Modificamos el golpeado del cuadrado
                //Las vidas de los barcos, para saber si ya se acabo el juego o no
                //Cambiamos turno
            }
            
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
