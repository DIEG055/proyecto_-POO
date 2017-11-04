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
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author juanm
 */
public class Paneles  extends JPanel implements ActionListener{

   panel_1 p1= new panel_1();
   Panel_2 p2 = new Panel_2(); 
   Panel_3 p3 = new Panel_3();
    public Paneles() {
        super( new BorderLayout ());
        add(p1);
        
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
        repaint();
        revalidate();
    }
    
}
