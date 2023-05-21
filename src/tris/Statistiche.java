package tris;

public class Statistiche {
    public static Statistiche statistiche;
    private int vittorieX;
    private int vittorieO;
    private int partiteTotali;

    public Statistiche() {
        vittorieX = 0;
        vittorieO = 0;
        partiteTotali = 0;
    }

    public void aggiungiVittoriaX() {
        vittorieX++;
        partiteTotali++;
    }

    public void aggiungiVittoriaO() {
        vittorieO++;
        partiteTotali++;
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
}
