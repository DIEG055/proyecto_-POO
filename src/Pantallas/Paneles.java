/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import com.sun.corba.se.spi.activation.Server;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import programa.Coordenada;
import programa.Tablero;
import programa.Maquina;
import programa.Jugador;

/**
 *
 * @author juanm
 */
public class Paneles extends JPanel implements ActionListener {

    private int xref1 = 30;
    private int yref1 = 100;
    private int tam_cuadrado = 30;
    private boolean online;
    private boolean local;
//    private Coordenada ct1= new Coordenada(this.xref1,this.yref1);  

    Panel_Inicial p1 = new Panel_Inicial();
    Panel_Eleccion p2 = new Panel_Eleccion();
    Panel_Ubi_Barcos_Jug2 p31 = new Panel_Ubi_Barcos_Jug2();
    Panel_Ubi_Barcos_Jug1 p32 = new Panel_Ubi_Barcos_Jug1();
    Panel_Ubi_barcos_vsPc p3 = new Panel_Ubi_barcos_vsPc();
    Panel_Partida p4;
    Panel_Online p5 = new Panel_Online();
    Panel_Informacion pi = new Panel_Informacion();
    panel_Configuracion pc = new panel_Configuracion();
    Tablero tablero_local = p3.tablero1;
    Tablero tablero_jugador1 = p32.tablero1;
    Tablero tablero_jugador2 = p31.tablero1;
    private Jugador jugador01;
    private Jugador jugador02;
    private Maquina maquina;
    private int tipo_juego;
//    private ServerSocket servidor;
//    private Socket cliente;
//    private DataOutputStream toServerlocal,toServervisitante;
//    private DataInputStream fromServerlocal,fromServervisitante;

    public Paneles() {
        super(new BorderLayout());
        add(p1);

        p1.iniciar.addActionListener(this);
        p1.configuracion.addActionListener(this);
        p1.informacion.addActionListener(this);

        p2.ONLINE.addActionListener(this);
        p2.VSLOCAL.addActionListener(this);
        p2.VSCOM.addActionListener(this);
        p2.REGRESAR.addActionListener(this);

        p3.REGRESAR.addActionListener(this);

        p3.horizontal.addActionListener(this);
        p3.vertical.addActionListener(this);
        p3.poner.addActionListener(this);

        p3.CONTINUAR.addActionListener(this);

        p31.CONTINUAR.addActionListener(this);

        p31.poner.addActionListener(this);
        p31.horizontal.addActionListener(this);
        p31.vertical.addActionListener(this);

        p32.CONTINUAR.addActionListener(this);

        p32.poner.addActionListener(this);
        p32.horizontal.addActionListener(this);
        p32.vertical.addActionListener(this);

        pi.regresar.addActionListener(this);
        pc.regresar.addActionListener(this);

        p5.REGRESAR.addActionListener(this);
        p5.LOCAL.addActionListener(this);
        p5.INVITADO.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(p1.iniciar)) {
            remove(p1);
            add(p2);
        }
        if (e.getSource().equals(p1.configuracion)) {
            remove(p1);
            add(pc);
        }
        if (e.getSource().equals(pc.regresar)) {
            remove(pc);
            add(p1);
        }
        if (e.getSource().equals(p1.informacion)) {
            remove(p1);
            add(pi);
        }
        if (e.getSource().equals(pi.regresar)) {
            remove(pi);
            add(p1);
        }
        if (e.getSource().equals(p2.REGRESAR)) {
            remove(p2);
            add(p1);
        }
        if (e.getSource().equals(p2.ONLINE)) {
            remove(p2);
            add(p5);
            this.tipo_juego = 1;
            this.online = true;
        }
        if (e.getSource().equals(p5.REGRESAR)) {
            remove(p5);
            add(p2);
            this.online = false;
        }
//        if (e.getSource().equals(p5.LOCAL)) {
//            remove(p5);
//            add(p32);
//            try {
//                this.servidor = new ServerSocket(8000);
//                this.cliente = this.servidor.accept();
//                fromServerlocal = new DataInputStream(cliente.getInputStream());
//                toServerlocal = new DataOutputStream(cliente.getOutputStream());
//            } catch (IOException ex) {
//                System.out.println("error en el servidor");
//            }
        //     }
//        if (e.getSource().equals(p5.INVITADO)) {
//            remove(p5);
//            add(p31);
        //  String direccion = JOptionPane.showInputDialog(null, "ingrese la direccion IP");
//            try {
//                this.cliente = new Socket("LocalHost", 8000);
//                fromServervisitante = new DataInputStream(cliente.getInputStream());
//                toServervisitante = new DataOutputStream(cliente.getOutputStream());
//            } catch (IOException ex) {
//                System.out.println("Problemas en la conexion");
//            }
        //    }
        if (e.getSource().equals(p2.VSLOCAL)) {
            remove(p2);
            add(p32);
            this.tipo_juego = 2;
        }
        if (e.getSource().equals(p32.poner)) {
            p32.poner();
        }
        if (e.getSource().equals(p32.CONTINUAR)) {
            //    if (!online) {
            if (p32.tablero1.getBarcos_creados() == 5) {
                remove(p32);
                add(p31);
            }
//            } else {
//                if (p32.tablero1.getBarcos_creados() == 5) {
//                    remove(p32);
//                    this.jugador01 = new Jugador("jugador 1", this.tablero_jugador1);
//                    p4 = new Panel_Partida(this.jugador01, false,this.fromServerlocal,this.toServerlocal);
//                    add(p4);
//                }
//            }
        }
        if (e.getSource().equals(p31.CONTINUAR)) {
            //  if (!online) {
            if (p31.tablero1.getBarcos_creados() == 5) {
                remove(p31);
                this.jugador01 = new Jugador("jugador 1", this.tablero_jugador1);
                this.jugador02 = new Jugador("jugador 2", this.tablero_jugador2);
                p4 = new Panel_Partida(this.jugador01, this.jugador02);
                add(p4);
            }
//            } else {
//                if (p31.tablero1.getBarcos_creados() == 5) {
//                    remove(p31);
//                    this.jugador02 = new Jugador("jugador 2", this.tablero_jugador2);
//                    p4 = new Panel_Partida(this.jugador02, false,this.fromServervisitante,this.toServervisitante);
//                    add(p4);
//                }
//            }
        }
        if (e.getSource().equals(p2.VSCOM)) {
            remove(p2);
            add(p3);
            this.tipo_juego = 3;
            System.out.println("Pantallas.Paneles.actionPerformed()");
        }
        if (e.getSource().equals(p3.REGRESAR)) {
            remove(p3);
            add(p2);
        }
        if (e.getSource().equals(p3.poner)) {
            p3.poner();
        }
        if (e.getSource().equals(p31.poner)) {
            p31.poner();
        }
        if (e.getSource().equals(p3.CONTINUAR)) {
            if (p3.tablero1.getbarcos_creados() == 5) {
                remove(p3);
                this.jugador01 = new Jugador("jugador 1", this.tablero_local);
                this.maquina = new Maquina(new Coordenada(xref1 + 350, yref1), this.tam_cuadrado);
                p4 = new Panel_Partida(this.jugador01, this.maquina);
                add(p4);
            }
            if (e.getSource().equals(p4.INICIO)) {
                remove(p4);
                add(p1);
            }
        }

    

    repaint();

    revalidate();
}

public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("panel_online.png");
        g.drawImage(fondo, 0, 0, null);
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}