import tris.Statistiche;
import ui.Menu;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Main {
    public static void main(String[] args) {
        new Menu();

        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream("statistiche.data"));
            Statistiche.statistiche = (Statistiche) file.readObject();
            file.close();
        } catch (Exception exception) {
            Statistiche.statistiche = new Statistiche();
        }
    }
}