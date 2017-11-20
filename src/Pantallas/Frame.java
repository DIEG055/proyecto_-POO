/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import javax.swing.JFrame;

/**
 *
 * @author juanm
 */
public class Frame extends JFrame {
        public Frame() {

        initUI();
    }

    private void initUI() {
        add(new Paneles());
        setSize(730, 478);
        setTitle("pantalla1");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }    
    
    public static void main(String[] args) {
        Frame ex = new Frame();
        ex.setVisible(true);
       
    }
}
