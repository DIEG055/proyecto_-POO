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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import programa.Coordenada;
import programa.Cuadro;
import programa.Jugador;
import programa.Maquina;
import programa.Tablero;

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
        addMouseListener(this);
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
        addMouseListener(this);
    }
    
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarEscenario(g);   
        pintar_golpe(g);

    }

    private void pintar_golpe(Graphics g) {
        Graphics2D c = (Graphics2D) g; 
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(modo){
                    if(maquina.getTablero().getCuadrados()[i][j].isGolpeado()){
                        Coordenada aux= maquina.getTablero().getCuadrados()[i][j].getCoordenada();
                        if(maquina.getTablero().getCuadrados()[i][j].isPer_barco()){
                            c.setColor(Color.BLUE);
                            c.fillRect(aux.getX(),aux.getY(), this.tam_cuadrado, this.tam_cuadrado);
                            c.setColor(Color.ORANGE);
                            c.drawRect(aux.getX(),aux.getY(), this.tam_cuadrado, this.tam_cuadrado);
                        }else{
                            c.setColor(Color.CYAN);
                            c.fillRect(aux.getX(),aux.getY(), this.tam_cuadrado, this.tam_cuadrado);
                        }
                        
                    }
                }else{
                    if(jugador02.getTablero().getCuadrados()[i][j].isGolpeado()){
                        Coordenada aux= jugador02.getTablero().getCuadrados()[i][j].getCoordenada();
                        if(jugador02.getTablero().getCuadrados()[i][j].isPer_barco()){
                            c.setColor(Color.BLUE);
                        }else{
                            c.setColor(Color.CYAN);
                        }
                        c.fillRect(aux.getX(),aux.getY(), this.tam_cuadrado, this.tam_cuadrado);
                    }
                }
                if(jugador01.getTablero().getCuadrados()[i][j].isGolpeado()){
                    Coordenada aux= jugador01.getTablero().getCuadrados()[i][j].getCoordenada();
                    if(jugador01.getTablero().getCuadrados()[i][j].isPer_barco()){
                            c.setColor(Color.BLUE);
                        }
                    else{
                            c.setColor(Color.CYAN);
                    }
                    c.fillRect(aux.getX(),aux.getY(), this.tam_cuadrado, this.tam_cuadrado);
                    
                }
            }
        } 
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
    }
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    public Coordenada golpe(Point p, Tablero tablero){
        Coordenada cabeza= new Coordenada(0,0);
        Cuadro[][] aux= tablero.getCuadrados();;    
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(aux[i][j].getRectangulo().contains(p)){
                    cabeza=aux[i][j].getCoordenada();
                }
            }
        }
        return cabeza;
    }
    
    //Nos arroja un i, j 
    public Coordenada golpe02(Point p, Tablero tablero){
        Coordenada cabeza= new Coordenada(0,0);
        Cuadro[][] aux= tablero.getCuadrados();   
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(aux[i][j].getRectangulo().contains(p)){
                    cabeza=new Coordenada(i, j);
                }
            }
        }
        return cabeza;
    }
    
    //Este golpe me arroja las coordenadas sin la ubicacion del panel. Es importante ya que la maquina
    //Genera un tablero y no tiene la ubicacion
    public Coordenada golpe03(Point p, Tablero tablero){
        Coordenada cabeza= new Coordenada(0,0);
        Cuadro[][] aux= tablero.getCuadrados();;    
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(aux[i][j].getRectangulo().contains(p)){
                    cabeza=new Coordenada(((aux[i][j].getCoordenada().getX())-tablero.getUbicacionPanel().getX()), 
                                          (((aux[i][j].getCoordenada().getY())-tablero.getUbicacionPanel().getY())));
                }
            }
        }
        return cabeza;
    }
    
   
    
    public void setCuadroGolpeado(Point p, String jugador){
        Coordenada coordenada;
        Coordenada coordenada02;
        if(jugador.equals("Jugador01")){
            coordenada = golpe02(p, jugador01.getTablero());
            coordenada02 = golpe(p, jugador01.getTablero());
            jugador01.getTablero().getCuadrados()[coordenada.getX()][coordenada.getY()].setGolpeado(true);
            for(int i=0; i<5; i++){
                if(jugador01.getTablero().getbarco(i).coordenadaPertenece(coordenada02)){
                    jugador01.getTablero().getbarco(i).quitarVida();
                }
            }
            
        }
        else{
            if(jugador.equals("Jugador02")){
                coordenada = golpe02(p, jugador02.getTablero());
                coordenada02 = golpe(p, jugador02.getTablero());
                jugador02.getTablero().getCuadrados()[coordenada.getX()][coordenada.getY()].setGolpeado(true);
                for(int i=0; i<5; i++){
                    if(jugador02.getTablero().getbarco(i).coordenadaPertenece(coordenada02)){
                        jugador02.getTablero().getbarco(i).quitarVida();
                    }
                }
            }
            else{
                if(jugador.equals("Maquina")){
                    coordenada = golpe02(p, maquina.getTablero());
                    coordenada02 = golpe03(p, maquina.getTablero());
                    maquina.getTablero().getCuadrados()[coordenada.getX()][coordenada.getY()].setGolpeado(true);
                    for(int i=0; i<5; i++){
                        if(maquina.getTablero().getbarco(i).coordenadaPertenece(coordenada02)){
                            maquina.getTablero().getbarco(i).quitarVida();
                        }
                    }
                }
            }
        }
    }
    
    
    public void actualizarEstadoJuego(){
        boolean estadoAux = true;
        if(jugador01.getTablero().getBarcosVivos() == 0){ estadoAux = false;}
        else{}
        
        if(modo){if(maquina.getTablero().getBarcosVivos() == 0){ estadoAux = false;}}
        else{if(jugador02.getTablero().getBarcosVivos() == 0){ estadoAux = false;}}
        
        this.estado =estadoAux;
    }
    
    public boolean golpeValido(Point p, Tablero tablero){
        boolean valido;
        Coordenada dondeGolpeo= golpe(p, tablero);
        if((dondeGolpeo.getX()>= tablero.getUbicacionPanel().getX()) && ((dondeGolpeo.getY()>= tablero.getUbicacionPanel().getY()))){
            if((dondeGolpeo.getX()<((tablero.getUbicacionPanel().getX())+(10*tablero.getTamanoCuadrados()))) &&
               (dondeGolpeo.getY()<((tablero.getUbicacionPanel().getY())+(10*tablero.getTamanoCuadrados())))){
                valido=true;
            }
            else{valido=false;}
        }
        
        else{ valido=false;}
        
        return valido;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p= new Point();
        Coordenada lugar_golpe= new Coordenada(0,0);
        if(estado){
            if(modo){
                //this.Recorrer(jugador01.getTablero());
                p= e.getPoint();
                if(golpeValido(p, maquina.getTablero())){
                    lugar_golpe= golpe(p,maquina.getTablero());
                    this.setCuadroGolpeado(p, "Maquina");
                    this.actualizarEstadoJuego();
                    repaint(); 
                }
                //listo//Aqui usamos la informacion para detectar donde pulso el jugador
                //listo//Pintamos o modificamos donde el usuario jugo
                //Listo//Modificamos el golpeado del cuadrado CAMILO
                //Las vidas de los barcos, para saber si ya se acabo el juego o no CAMILO

                //Hacemos que la maquina juegue
                //Coordenada dada por la maquina       

                //listo    //Pintamos o modificamos donde la maquina jugo
                //Modificamos el golpeado del cuadrado
                //Las vidas de los barcos, para saber si ya se acabo el juego o no
            }//If modo
            else{
                if(turno){
                    p= e.getPoint();
                    if(golpeValido(p, jugador02.getTablero())){
                        lugar_golpe= golpe(p,jugador02.getTablero());
                        this.setCuadroGolpeado(p, "Jugador02");
                        this.actualizarEstadoJuego();
                        this.turno = false;
                        repaint();
                    }
                    
                    //Aqui usamos la informacion para detectar donde pulso el jugador
                    //Pintamos o modificamos donde el usuario jugo
                    //Modificamos el golpeado del cuadrado
                    //Las vidas de los barcos, para saber si ya se acabo el juego o no
                    //Cambiamos turno
                    
                }//IF TURNO
                
                else{
                     p= e.getPoint();
                     if(golpeValido(p, jugador01.getTablero())){
                        lugar_golpe= golpe(p,jugador01.getTablero());
                        this.setCuadroGolpeado(p, "Jugador01");
                        this.actualizarEstadoJuego();   
                        this.turno = true;
                        repaint();
                     }
                   //listo    //Aqui usamos la informacion para detectar donde pulso el jugador
                    //listo   //Pintamos o modificamos donde el usuario jugo
                    //Modificamos el golpeado del cuadrado
                    //Las vidas de los barcos, para saber si ya se acabo el juego o no
                    //Cambiamos turno
                    
                    
                }//ELSE TURNO
            }//ELSE MODO
        }//IF ESTADO
        
        else{
            System.out.println("FIN DEL JUEGO CHAVAL");
        }//ELSE ESTADO
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
