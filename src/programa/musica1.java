package programa;


import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FAMILIA
 */
public class musica1 implements Runnable {
    String f;
            InputStream in;
            AudioStream audio;
            boolean parar;
    public musica1(String f) {
        this.f = f;
        this.parar=true;
        try {       
            this.in=new FileInputStream(f);
            this.audio=new AudioStream(in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(musica1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(musica1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void run() {
        if(parar){
             AudioPlayer.player.start(audio);
        }             
    }        

    public void setParar(boolean parar) {
        this.parar = parar;
    }

    
}
