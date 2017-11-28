package programa;

import java.awt.Point;
import java.awt.Rectangle;

public class Tablero {

    private Cuadro[][] cuadrados;
    private Barco[] barcos;
    private int barcos_creados;
    private Coordenada ubicacionPanel;
    private int tamanoCuadrados;
    private int barcosVivos;

    public Tablero(Coordenada ubicacion, int tamanoCuadrados) {
        this.cuadrados = new Cuadro[10][10];
        this.barcos = new Barco[5];
        this.barcos_creados = 0;
        this.ubicacionPanel = ubicacion;
        this.tamanoCuadrados = tamanoCuadrados;
        this.barcosVivos = 5;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Coordenada aux = new Coordenada(ubicacion.getX() + (tamanoCuadrados * j),
                        ubicacion.getY() + (tamanoCuadrados * i));
                cuadrados[i][j] = new Cuadro(aux, tamanoCuadrados);
            }
        }
    }

    public Tablero(Coordenada ubicacion, Barco[] barcos) {
        this.cuadrados = new Cuadro[10][10];
        this.barcos = barcos;
        this.barcos_creados = 5;
        this.ubicacionPanel = ubicacion;
        this.tamanoCuadrados = barcos[0].getTamanoCuadrados();
        this.barcos_creados = 5;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Coordenada aux = new Coordenada(ubicacion.getX() + (tamanoCuadrados * j),
                        ubicacion.getY() + (tamanoCuadrados * i));
                cuadrados[i][j] = new Cuadro(aux, tamanoCuadrados);

            }
        }
    }

    public void informarCuadradosBarcos() {
        for (Barco barco : barcos) {
            for (Coordenada coordenada : barco.getCoordenadas()) {
                cuadrados[(coordenada.getY()) / tamanoCuadrados][(coordenada.getX()) / tamanoCuadrados].setPer_barco(true);
            }
        }
    }

    public boolean desocupado_total(Coordenada c, int tam, boolean b) {
        boolean ac = true;
        int h = (c.getX() - ubicacionPanel.getX()) / tamanoCuadrados;
        int v = (c.getY() - ubicacionPanel.getY()) / tamanoCuadrados;
        try {
            for (int i = 0; i < tam; i++) {
                if (b) {
                    ac &= !cuadrados[v + i][h].isPer_barco();
                } else {
                    ac &= !cuadrados[v][h + i].isPer_barco();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return ac;
    }

    public boolean cabe_barco(Coordenada cabeza, int tam, boolean orientacion) {
        int t = this.tamanoCuadrados;
        boolean ac = false;
        if (orientacion) {
            if ((tam * t) + cabeza.getY() <= 10 * t + ubicacionPanel.getY()) {
                ac = true;
            }
        } else {
            if ((tam * t) + cabeza.getX() <= 10 * t + ubicacionPanel.getX()) {
                ac = true;
            }
        }
        return ac;
    }

    public Coordenada cabeza(Point p) {
        Coordenada cabeza = new Coordenada(0, 0);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (cuadrados[i][j].getRectangulo().contains(p)) {
                    cabeza = cuadrados[i][j].getCoordenada();
                }
            }
        }
        return cabeza;
    }

    public void crear_barco(Point click, boolean orientacion, int tamano) {
        Coordenada cabeza = cabeza(click);
        if (cabe_barco(cabeza, tamano, orientacion) && desocupado_total(cabeza, tamano, orientacion)) {
            barcos[this.barcos_creados] = new Barco(cabeza, orientacion, tamano, this.tamanoCuadrados);
            int h = (cabeza.getX() - ubicacionPanel.getX()) / tamanoCuadrados;
            int v = (cabeza.getY() - ubicacionPanel.getY()) / tamanoCuadrados;
            for (int i = 0; i < tamano; i++) {
                if (orientacion) {
                    this.cuadrados[v + i][h].setPer_barco(true);
                } else {
                    this.cuadrados[v][h + i].setPer_barco(true);
                }

            }
            this.barcos_creados++;
            int q = 0;
        }
    }

    public boolean crear_barcovf(Point click, boolean orientacion, int tamano) {
        boolean ac = false;
        Coordenada cabeza = cabeza(click);
        if (cabe_barco(cabeza, tamano, orientacion) && desocupado_total(cabeza, tamano, orientacion)) {
            ac = true;
        }
        return ac;
    }

    public Cuadro[][] getCuadrados() {
        return cuadrados;
    }

    public int getbarcos_creados() {
        return this.barcos_creados;
    }

    public Barco getbarco(int x) {
        return barcos[x];
    }

    public int getBarcos_creados() {
        return barcos_creados;
    }

    public Coordenada getUbicacionPanel() {
        return ubicacionPanel;
    }

    public int getBarcosVivos() {
        int barcosVivosAux = 0;
        for (Barco barco : barcos) {
            if (barco.getVidas() > 0) {
                barcosVivosAux++;
            }
        }
        this.barcosVivos = barcosVivosAux;
        return barcosVivos;
    }

//    public void setUbicacionPanel(Point newUbicacionPanel){
//        this.ubicacionPanel = newUbicacionPanel;
//        this.acutualizarRectangles(tamanoCuadrados, newUbicacionPanel);
//    }
    public int getTamanoCuadrados() {
        return tamanoCuadrados;
    }

//    public void setTamanoCuadrados(int newTamanoCuadrados) {
//        this.tamanoCuadrados = newTamanoCuadrados;
//        this.acutualizarRectangles(newTamanoCuadrados, ubicacionPanel);
//    }
    public void acutualizarRectangles(int newTamanoCuadrados, Point newUbicacionPanel) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                double ubicacionPanelX = ubicacionPanel.getX();
                int ubicacionPanelXint = (int) ubicacionPanelX;

                double ubicacionPanelY = ubicacionPanel.getY();
                int ubicacionPanelYint = (int) ubicacionPanelY;

                int posicion_x = (j * tamanoCuadrados) + ubicacionPanelXint;
                int position_y = (i * tamanoCuadrados) + ubicacionPanelYint;
                Rectangle rectanguloAuxiliar = new Rectangle(posicion_x, position_y, newTamanoCuadrados, newTamanoCuadrados);
                this.cuadrados[i][j].setRectangulo(rectanguloAuxiliar);
            }
        }
    }
    

    //public boolean isVivo(){}

    public Barco[] getBarcos() {
        return barcos;
    }

    public void setBarcos(Barco[] barcos) {
        this.barcos = barcos;
    }
}
