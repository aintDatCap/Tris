package tris;

import java.io.*;

public class Statistiche implements Serializable {
    private int vittorieX;
    private int vittorieO;
    private int pareggiTotali;
    private int partiteTotali;

    public Statistiche() {
        vittorieX = 0;
        vittorieO = 0;
        partiteTotali = 0;
    }

    public Statistiche(String nomeFile) {
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(nomeFile));
            Tris.statistiche = (Statistiche) file.readObject();
            file.close();
        } catch (Exception exception) {
            Tris.statistiche = new Statistiche();
        }
    }

    public void salvaStatistiche(String nomeFile) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(nomeFile));
            file.writeObject(this);
            file.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void aggiungiVittoriaX() {
        vittorieX++;
        partiteTotali++;
        salvaStatistiche("./statistiche.data");
    }

    public void aggiungiVittoriaO() {
        vittorieO++;
        partiteTotali++;
        salvaStatistiche("./statistiche.data");
    }

    public void aggiungiPareggio() {
        pareggiTotali++;
        partiteTotali++;
        salvaStatistiche("./statistiche.data");
    }

    public int getVittorieX() {
        return vittorieX;
    }

    public int getVittorieO() {
        return vittorieO;
    }

    public int getPartiteTotali() {
        return partiteTotali;
    }

    public int getPareggiTotali() {
        return pareggiTotali;
    }
}
