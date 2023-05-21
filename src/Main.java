import tris.Statistiche;
import tris.Tris;
import ui.Menu;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Main {

    public static void main(String[] args) {
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("statistiche.data"));
            Tris.statistiche = (Statistiche) file.readObject();
            file.close();
        } catch (Exception exception) {
            System.out.println("statistiche.data non trovato");
            Tris.statistiche = new Statistiche();
        }

        new Menu();
    }
}