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
public class Frame2 extends JFrame {
        public Frame2() {

        initUI();
    }

    private void initUI() {
        add(new Eleccion_partida());
        setSize(730, 480);
        setTitle("pantalla2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        Frame2 ex = new Frame2();
        ex.setVisible(true);
       
    }
}