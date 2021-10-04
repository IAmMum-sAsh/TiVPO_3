package test3;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class PlayerThread extends Thread{

    public void run(){
        try {
            FileInputStream fileInputStream = new FileInputStream("7qdT.mp3");
            Player player = new Player(fileInputStream);
            player.play();

        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(JavaLayerException e) {
            e.printStackTrace();
        }

    }

}