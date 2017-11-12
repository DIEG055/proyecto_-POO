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
public class Panel_3_2 extends JPanel implements MouseListener {

    private int xref = 30;
    private int yref = 100;
    private int tam_cuadrado = 30;
    private boolean orientacion = true;
    private int x_aux, y_aux;
    private int tam = 0;
    private Coordenada c;
    private int t[] = new int[5];
    private boolean puesto = false;
    private Coordenada ct = new Coordenada(this.xref, this.yref);
    Tablero tablero1 = new Tablero(ct, this.tam_cuadrado);
    private boolean prueba = true;

    JButton REGRESAR = new JButton("REGRESAR");
    JButton poner = new JButton("Poner barco");
    JButton CONTINUAR = new JButton("CONTINUAR");
    JRadioButton vertical = new JRadioButton("VERTICAL");
    JRadioButton horizontal = new JRadioButton("HORIZONTAL");
    ButtonGroup grupo1 = new ButtonGroup();
    JLabel texto = new JLabel("SELECCIONE EL RECUADRO DONDE QUIERE UBICAR EL BARCO");

    public Panel_3_2() {
        this.add(this.vertical);
        this.add(this.horizontal);
        this.add(this.poner);
        this.add(this.CONTINUAR);
        addMouseListener(this);
        t[0] = 5;
        t[1] = 4;
        t[2] = 3;
        t[3] = 3;
        t[4] = 2;
        grupo1.add(vertical);
        grupo1.add(horizontal);
        CONTINUAR.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        CONTINUAR.setForeground(new java.awt.Color(255, 255, 255));
        CONTINUAR.setText("CONTINUAR");
        CONTINUAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        CONTINUAR.setContentAreaFilled(false);

        poner.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        poner.setForeground(new java.awt.Color(255, 255, 255));
        poner.setText("Ubicar barco");
        poner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        poner.setContentAreaFilled(false);

        REGRESAR.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setText("REGRESAR");
        REGRESAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        REGRESAR.setContentAreaFilled(false);

        horizontal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        horizontal.setForeground(new java.awt.Color(255, 255, 255));
        horizontal.setText("HORIZONTAL");
        horizontal.setContentAreaFilled(false);

        vertical.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vertical.setForeground(new java.awt.Color(255, 255, 255));
        vertical.setText("VERTICAL");
        vertical.setContentAreaFilled(false);

        texto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        texto.setText("UBIQUE LOS BARCOS, Y CONFIRME SU UBICACION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(REGRESAR, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CONTINUAR, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 420, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(horizontal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(vertical, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(25, 25, 25))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(poner, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(100, 100, 100))))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CONTINUAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(REGRESAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vertical, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(horizontal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(poner, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))
        );

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
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero1.getCuadrados()[i][j].isPer_barco()) {
                    Coordenada aux = tablero1.getCuadrados()[i][j].getCoordenada();
                    c.fillRect(aux.getX(), aux.getY(), this.tam_cuadrado, this.tam_cuadrado);
                }
                c.drawRect(xref + (i * this.tam_cuadrado), yref + (j * this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);
            }
        }
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    private void pinta_provicional(Graphics g) {
        Graphics2D c = (Graphics2D) g;
        c.setColor(Color.ORANGE);
        if (!(this.x_aux == 0) && prueba) {
            try {
                for (int i = 0; i < this.t[tam]; i++) {
                    if (orientacion) {
                        c.fillRect(x_aux, y_aux + (i * this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);
                    } else {
                        c.fillRect(x_aux + (i * this.tam_cuadrado), y_aux, this.tam_cuadrado, this.tam_cuadrado);
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public Coordenada cabeza(Point p) {
        Coordenada cabeza = new Coordenada(0, 0);
        Cuadro[][] aux = tablero1.getCuadrados();;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (aux[i][j].getRectangulo().contains(p)) {
                    cabeza = aux[i][j].getCoordenada();
                }
            }
        }
        return cabeza;
    }

    public void eleccion_orientacion() {
        if (vertical.isSelected()) {
            this.orientacion = true;
        } else {
            this.orientacion = false;
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
        Coordenada aux = cabeza(e.getPoint());
        this.eleccion_orientacion();
        if (tablero1.crear_barcovf(e.getPoint(), orientacion, t[this.tam])) {
            this.x_aux = aux.getX();
            this.y_aux = aux.getY();
            this.prueba = true;
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

    public void poner() {
        Point c = new Point(x_aux, y_aux);
        if (tam < 5) {
            tablero1.crear_barco(c, orientacion, t[this.tam]);
            tam++;
        }
        this.prueba = false;
        repaint();
    }

}
