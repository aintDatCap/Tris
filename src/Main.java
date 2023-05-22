import tris.Statistiche;
import tris.Tris;
import ui.Menu;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Main {

    public static void main(String[] args) {
        Tris.statistiche = new Statistiche("./statistiche.data");
        new Menu();
    }
}