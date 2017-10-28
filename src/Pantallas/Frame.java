/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 *
 * @author juanm
 */
public class Frame extends JFrame {
        public Frame() {

        initUI();
    }

    private void initUI() {
        add(new Ubicacion_Barcos());
        setSize(730, 480);
        setTitle("Ejercicio 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        Frame ex = new Frame();
        ex.setVisible(true);
       
    }
}
