package programa;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Cuadro {

    private boolean golpeado; //Para saber si el cuadro fue golpeado o no
    private boolean per_barco; //Para saber si un el cuadro pertenece a un barco no
    private Coordenada coordenada; //En que parte de cuadro se encuentra el cuadro
    private Rectangle rectangulo; //Rectangulo del cuadro, dectecta si ha sido golpeado. 

    public Cuadro(Coordenada coordenada, int tam_cuadros) {
        this.coordenada = coordenada;
        this.rectangulo = new Rectangle(coordenada.getX(), coordenada.getY(),
                tam_cuadros, tam_cuadros);
        this.golpeado = false;
        this.per_barco = false;
    }

    public Coordenada coordenada_golpeado(Point p) {
        Coordenada aux = new Coordenada(0, 0);
        if (rectangulo.contains(p)) {
            aux = this.coordenada;
        }
        return aux;
    }

    public boolean isGolpeado() {
        return golpeado;
    }

    public void setGolpeado(boolean golpeado) {
        this.golpeado = golpeado;
    }

    public boolean isPer_barco() {
        return per_barco;
    }

    public void setPer_barco(boolean per_barco) {
        this.per_barco = per_barco;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Rectangle getRectangulo() {
        return rectangulo;
    }

    public void setRectangulo(Rectangle rectangulo) {
        this.rectangulo = rectangulo;
    }

}
