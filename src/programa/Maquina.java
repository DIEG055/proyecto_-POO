/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 *
 * @author Asus-Pc
 */
public class Maquina {

    private String nombre;
    private Tablero tablero;

    public Maquina(Coordenada ubicacion, int tamano) {
        this.nombre = "CPU";
        this.tablero = new Tablero(ubicacion, this.generarBarcos(tamano));
        this.tablero.informarCuadradosBarcos();
    }

    public String getNombre() {
        return nombre;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Barco[] generarBarcos(int tamano) {
        Barco[] barcosMaquina = new Barco[5];
        barcosMaquina[0] = this.generarBarco(barcosMaquina, 5, 0, tamano);
        barcosMaquina[1] = this.generarBarco(barcosMaquina, 4, 1, tamano);
        barcosMaquina[2] = this.generarBarco(barcosMaquina, 3, 2, tamano);
        barcosMaquina[3] = this.generarBarco(barcosMaquina, 3, 3, tamano);
        barcosMaquina[4] = this.generarBarco(barcosMaquina, 2, 4, tamano);

        return barcosMaquina;
    }
        public void ataque_maquina(int cooordenadaX,int coordenadaY,Cuadro[][] c_barcos, boolean ac){
      if(c_barcos[cooordenadaX][coordenadaY].isPer_barco()){
             //pasa turno 
             if(ac){
                 int eleccion=((int) (Math.random() * 4 )+1);
                if(eleccion==1){
                    ataque_maquina(cooordenadaX+1, coordenadaY, c_barcos,false);
                }
                if(eleccion==2){
                    ataque_maquina(cooordenadaX-1, coordenadaY, c_barcos,false);
                }
                if(eleccion==3){
                    ataque_maquina(cooordenadaX, coordenadaY+1, c_barcos,false);
                }
                if(eleccion==4){
                    ataque_maquina(cooordenadaX, coordenadaY-1, c_barcos,false);
                }
             }else{
                if(c_barcos[cooordenadaX+1][coordenadaY].isPer_barco()){
                    ataque_maquina(cooordenadaX+1, coordenadaY, c_barcos,false);
                }
                if(c_barcos[cooordenadaX-1][coordenadaY].isPer_barco()){
                    ataque_maquina(cooordenadaX-1, coordenadaY, c_barcos,false);
                }
                if(c_barcos[cooordenadaX][coordenadaY+1].isPer_barco()){
                    ataque_maquina(cooordenadaX, coordenadaY+1, c_barcos,false);
                }
                if(c_barcos[cooordenadaX][coordenadaY-1].isPer_barco()){
                    ataque_maquina(cooordenadaX, coordenadaY-1, c_barcos,false);
                }
                if(c_barcos[cooordenadaX+1][coordenadaY+1].isPer_barco()){
                    ataque_maquina(cooordenadaX+1, coordenadaY, c_barcos,false);
                }
                if(c_barcos[cooordenadaX-1][coordenadaY-1].isPer_barco()){
                    ataque_maquina(cooordenadaX-1, coordenadaY, c_barcos,false);
                }
                if(c_barcos[cooordenadaX-1][coordenadaY+1].isPer_barco()){
                    ataque_maquina(cooordenadaX, coordenadaY+1, c_barcos,false);
                }
                if(c_barcos[cooordenadaX+1][coordenadaY-1].isPer_barco()){
                    ataque_maquina(cooordenadaX, coordenadaY-1, c_barcos,false);
                }
             }
         }else{
             coordenadaY = ((int) (Math.random() * 10 + 1)) - 1;
             cooordenadaX = ((int) (Math.random() * 10 + 1)) - 1;
             ataque_maquina(cooordenadaX, coordenadaY, c_barcos,true);
             
         }
     } //literalmente seria dificultad dios pero no se me ocurre otra forma

    public Barco generarBarco(Barco[] barcosGenerados, int tamano, int numeroBarcos, int tamano02) {
        Boolean barcoCreado = false;
        Boolean orientacion = (Math.random() > 0.5);
        Coordenada coordenadaCabeza = new Coordenada(0, 0);
        while (!(barcoCreado)) {
            int coordenadaY = ((int) (Math.random() * 10 + 1)) - 1;
            int coordenadaX = ((int) (Math.random() * 10 + 1)) - 1;
            coordenadaY = coordenadaY * tamano02;
            coordenadaX = coordenadaX * tamano02;
            coordenadaCabeza = new Coordenada(coordenadaX, coordenadaY);
            Boolean cordenadasValidas = true;
            Boolean orientacionValida = false;

            if (orientacion) {
                if ((coordenadaY + tamano) <= 10) {
                    orientacionValida = true;
                }
            } else {
                if ((coordenadaX + tamano) <= 10) {
                    orientacionValida = true;
                }
            }

            if (orientacionValida) {
                for (int i = 0; i < numeroBarcos; i++) {
                    if (orientacion) {
                        for (int j = 0; j < tamano; j++) {
                            if ((this.isCoordenada(new Coordenada((coordenadaX), (coordenadaY + (j * tamano02))), (barcosGenerados[i].getCoordenadas())))) {
                                cordenadasValidas = false;
                            }
                        }
                    } else {
                        for (int s = 0; s < tamano; s++) {
                            if ((this.isCoordenada(new Coordenada((coordenadaX + (s * tamano02)), (coordenadaY)), (barcosGenerados[i].getCoordenadas())))) {
                                cordenadasValidas = false;
                            }
                        }
                    }
                }
            }
            barcoCreado = cordenadasValidas && orientacionValida;
        }
        return new Barco(coordenadaCabeza, orientacion, tamano, tamano02);
    }

    public boolean isCoordenada(Coordenada coordenadaEvaluar, Coordenada[] coordenadas) {
        Boolean is = false;
        for (Coordenada cordenada : coordenadas) {
            if ((cordenada.getX() == coordenadaEvaluar.getX()) && (cordenada.getY() == coordenadaEvaluar.getY())) {
                is = true;
            }
        }
        return is;
    }

    //Pruebas pendejas
    public void MostarBarcos(Barco[] barcos) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int as = 0;
                for (int l = 0; l < 6; l++) {
                    for (Coordenada cor : (barcos[l].getCoordenadas())) {
                        if (((cor.getX() == j) && (cor.getY() == i))) {
                            as = l + 1;
                        }
                    }
                }
                System.out.print(as + " ");
            }
            System.out.println("");
        }
    }

}
