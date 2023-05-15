package tris;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tris {
    private Simbolo[][] tabella = new Simbolo[3][3];
    private Simbolo turno = Simbolo.X;
    private RisultatoPartita risultatoPartita = RisultatoPartita.PartitaNonConclusa;

    // Costruttore per inizializzare la tabella con sole caselle vuote
    public Tris() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                tabella[i][j] = Simbolo.Nessuno;
    }

    public void mossa(int x, int y) {
        if(risultatoPartita != RisultatoPartita.PartitaNonConclusa)
            return;

        if(tabella[x][y] == Simbolo.Nessuno)
            tabella[x][y] = turno;
        turno = turno == Simbolo.X ? Simbolo.O : Simbolo.X; // cambio turno

        risultatoPartita = controllaVincitore();
    }

    public RisultatoPartita controllaVincitore() {
        List<Integer> valori = new ArrayList<>();
        // Righe e colonne
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                valori.add(tabella[i][j].getValue()); // riga
                valori.add(tabella[j][i].getValue()); // colonna
            }
        }
        for(int i = 0; i < 3; i++) {
            valori.add(tabella[i][i].getValue()); // diagonale
            valori.add(tabella[2-i][2-i].getValue()); // diagonale opposta
        }
        // Righe e diagonale
        for(int i = 0; i < valori.size(); i+=6) {
            int somma = 0;
            for(int j = i;  j < i + 6; j+=2)
                somma += valori.get(j);

            if(somma == 3)
                return RisultatoPartita.daSimbolo(Simbolo.X);
            if(somma == -3)
                return RisultatoPartita.daSimbolo(Simbolo.O);
        }

        // Colonne e diagonale opposta
        for(int i = 1; i < valori.size(); i+=6) {
            int somma = 0;
            for(int j = i;  j < i + 6; j+=2)
                somma += valori.get(j);

            if(somma == 3)
                return RisultatoPartita.daSimbolo(Simbolo.X);
            if(somma == -3)
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

                if(simbolo == Simbolo.X)
                    string.append("X");
                else if (simbolo == Simbolo.O)
                    string.append("O");
                else
                    string.append(" ");
            }
        }
        return string.toString();
    }
}
