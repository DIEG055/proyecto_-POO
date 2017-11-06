package programa;
public class Barco {
    private Coordenada[] coordenadas;
    private int vidas;
    private boolean orientacion; // 0 horizontal y 1 vertical 
    private int tamano;
    private int tamanoCuadrados;
    
    public Barco(Coordenada cabeza_barco, boolean orientacion, int tamano,int tam_barcos){
        this.vidas=tamano;
        this.orientacion=orientacion;
        this.tamano=tamano;
        this.tamanoCuadrados =tam_barcos;
        this.coordenadas= new Coordenada[tamano];
        for(int i =0; i<tamano; i++){
            if(orientacion){
                coordenadas[i]=new Coordenada(cabeza_barco.getX(),(i*tam_barcos)+ cabeza_barco.getY());
            }
            else{
                coordenadas[i]=new Coordenada((i*tam_barcos)+cabeza_barco.getX(), cabeza_barco.getY());
            }
        }
    }
    
    public boolean coordenadaPertenece(Coordenada coordenada){
        boolean aux = false;
        for (Coordenada coordenada01 : coordenadas) {
            if((coordenada01.getX() == coordenada.getX()) && (coordenada01.getY() == coordenada.getY())){
                aux=true;
            }
        }
        return aux;
    }

    public int getVidas() {return vidas;}

    public boolean getOrientacion() {return orientacion;}

    public int getTamano() {return tamano;}

    public int cabezaX(){return this.coordenadas[0].getX();}
    
    public int cabezaY(){return this.coordenadas[0].getY();}

    public Coordenada[] getCoordenadas() {return coordenadas;}
    
    public Coordenada getCoordenada(int i) {return coordenadas[i];}
    
    public int getTamanoCuadrados() {return tamanoCuadrados;}
    
    public void quitarVida(){
        if(this.vidas >0){
            this.vidas = this.vidas -1;
        }
    }
    
        
}
