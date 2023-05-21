package tris;


import tris.bot.Bot;
import tris.bot.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Tris {
    public static Statistiche statistiche;

    private Simbolo[][] tabella = new Simbolo[3][3];
    private Simbolo turno = Simbolo.X;
    private RisultatoPartita risultatoPartita = RisultatoPartita.PartitaNonConclusa;
    private Bot bot = null;

    private Consumer<Coordinate> dopoUnaMossa;
    private Consumer<RisultatoPartita> finitaLaPartita;

    // Costruttore per inizializzare la tabella con sole caselle vuote
    public Tris() {
        pulisciTabella();
    }

    public Tris(Simbolo[][] tabella) {
        this.tabella = tabella;
    }

    // callback
    public Tris(Consumer<Coordinate> dopoUnaMossa, Consumer<RisultatoPartita> finitaLaPartita) {
        this.dopoUnaMossa = dopoUnaMossa;
        this.finitaLaPartita = finitaLaPartita;
        pulisciTabella();
    }

    public Tris(Bot bot, Consumer<Coordinate> dopoUnaMossa, Consumer<RisultatoPartita> finitaLaPartita ) {
        this.dopoUnaMossa = dopoUnaMossa;
        this.finitaLaPartita = finitaLaPartita;
        pulisciTabella();
        this.bot = bot;
    }

    public void mossa(int x, int y) {
        if(risultatoPartita != RisultatoPartita.PartitaNonConclusa)
            return;

        if(tabella[x][y] == Simbolo.Nessuno){
            tabella[x][y] = turno;
            turno = turno == Simbolo.X ? Simbolo.O : Simbolo.X; // cambio turno

            dopoUnaMossa.accept(new Coordinate(x,y));

            risultatoPartita = controllaVincitore();

            if(risultatoPartita == RisultatoPartita.PartitaNonConclusa && bot != null && turno == Simbolo.O) {
                Coordinate coordinate = bot.mossa(tabella);
                mossa(coordinate.getX(), coordinate.getY());
            }
        }

        if(risultatoPartita != RisultatoPartita.PartitaNonConclusa) {
            finitaLaPartita.accept(risultatoPartita);
        }
    }

    public void pulisciTabella() {
        for(int i = 0; i < 3; i++)
            Arrays.fill(tabella[i], Simbolo.Nessuno);
    }

    public String carattereDellaCella(Coordinate coordinate){
        return tabella[coordinate.getX()][coordinate.getY()].asString();
    }

    public RisultatoPartita controllaVincitore() {
        List<Integer> valori = new ArrayList<>();

        // Righe e colonne
        for(int i = 0; i < 3; i++) {
            int sommaRiga = 0;
            int sommaColonna = 0;
            for(int j = 0; j < 3; j++) {
                sommaRiga += tabella[i][j].getValue(); // riga
                sommaColonna += tabella[j][i].getValue(); // colonna
            }
            valori.add(sommaRiga);
            valori.add(sommaColonna);
        }

        int sommaDiagonale1 = 0;
        int sommaDiagonale2 = 0;
        for(int i = 0; i < 3; i++) {
            sommaDiagonale1 += tabella[i][i].getValue(); // diagonale
            sommaDiagonale2 += tabella[2-i][i].getValue(); // diagonale opposta
        }
        valori.add(sommaDiagonale1);
        valori.add(sommaDiagonale2);

        for (int valore : valori) {
            if (valore == 3)
                return RisultatoPartita.daSimbolo(Simbolo.X);
            if (valore == -3)
                return RisultatoPartita.daSimbolo(Simbolo.O);
        }

        for(Simbolo[] simboli: tabella) // per ogni array di simboli nella tabella
            for(Simbolo simbolo: simboli) // prendiamo ogni simbolo in tale array
                if(simbolo == Simbolo.Nessuno) // e controlliamo se è vuoto
                    return RisultatoPartita.PartitaNonConclusa;

        return RisultatoPartita.Pareggio;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(Simbolo[] simboli: tabella) {
            string.append("\n");
            for(Simbolo simbolo: simboli) {
                string.append("\t");
                string.append(simbolo.asString()); // inserimento carattere
            }
        }
        return string.toString();
    }

    public Simbolo[][] getTabella() {
        return tabella;
    }
}
