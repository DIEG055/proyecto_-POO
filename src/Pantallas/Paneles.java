/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.*;
import programa.Coordenada;
import programa.Tablero;

/**
 *
 * @author juanm
 */
public class Paneles  extends JPanel implements ActionListener{

    private  int xref1=380;
    private  int yref1=100;
    private  int tam_cuadrado=30;
    private Coordenada ct1= new Coordenada(this.xref1,this.yref1);  
    
    
    panel_1 p1= new panel_1();
    Panel_2 p2 = new Panel_2(); 
    Panel_3 p3 = new Panel_3();
    Tablero tablero_local=p3.tablero1;
    Panel_4 p4 = new Panel_4(xref1-350,xref1,yref1,yref1,tam_cuadrado); 
    
    
    public Paneles() {
        super( new BorderLayout ());
        add(p4);
        
        p1.iniciar.addActionListener(this);
        p1.configuracion.addActionListener(this);
        p1.add(p1.iniciar);
        p1.add(p1.configuracion);
        
        p2.ONLINE.addActionListener(this);
        p2.VSLOCAL.addActionListener(this);
        p2.vsCOM.addActionListener(this);
        p2.REGRESAR.addActionListener(this);
        p2.add(p2.ONLINE);
        p2.add(p2.VSLOCAL);
        p2.add(p2.vsCOM);
        p2.add(p2.REGRESAR);
        
        p3.REGRESAR.addActionListener(this);
        p3.add(p3.REGRESAR);
        p3.horizontal.addActionListener(this);
        p3.vertical.addActionListener(this);
        p3.poner.addActionListener(this);
        p3.add(p3.vertical);
        p3.add(p3.horizontal);
        p3.add(p3.poner);
        p3.COMENZAR.addActionListener(this);
        p3.add(p3.COMENZAR);
    }
   
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(p1.iniciar)){
            remove(p1);
            add(p2);  
        }
        if(e.getSource().equals(p2.REGRESAR)){
            remove(p2);
            add(p1);
        }
        if(e.getSource().equals(p2.ONLINE)){
            remove(p2);
            add(p3);
        }
        if(e.getSource().equals(p2.VSLOCAL)){
            remove(p2);
            add(p3);
        }
        if(e.getSource().equals(p2.vsCOM)){
            remove(p2);
            add(p3);
        }
        if(e.getSource().equals(p3.REGRESAR)){
            remove(p3);
            add(p2);
        }
        if(e.getSource().equals(p3.poner)){
            p3.poner();
        }
        if(e.getSource().equals(p3.COMENZAR)){
            if(p3.tablero1.getbarcos_creados()==5){
            remove(p3);
            add(p4);
        }
           
        }

        repaint();
        revalidate();
    }
    
}
