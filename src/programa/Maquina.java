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
    private FuncionesMaquina funciones;
    
    public Maquina(Coordenada ubicacion, int tamano){
        this.nombre= "CPU";
        this.funciones= new FuncionesMaquina();
        this.tablero = new Tablero(ubicacion, funciones.generarBarcos(tamano) );
        this.tablero.informarCuadradosBarcos();
    }

    public String getNombre() {return nombre;}

    public Tablero getTablero() {return tablero;}

    public FuncionesMaquina getFunciones() {
        return funciones;
    }
    
    
    
    
    
    
}
