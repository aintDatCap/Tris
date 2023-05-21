package tris.bot;

import tris.RisultatoPartita;
import tris.Simbolo;
import tris.Tris;

import java.util.ArrayList;
import java.util.List;

public class DifficultBot implements Bot{

    @Override
    public Coordinate mossa(Simbolo[][] tabella) {


        return null;
    }

    private int punteggioMossa(Simbolo[][] tabella) {
        List<Coordinate> mossePossibili = new ArrayList<>();
        for(int i = 0; i < tabella.length; i++) {
            for (int j = 0; j < tabella.length; j++) {
                if(tabella[i][j] == Simbolo.Nessuno)
                    mossePossibili.add(new Coordinate(i, j));
            }
        }
        int punteggio = 0;
        for(Coordinate mossa: mossePossibili) {
            Tris testTris = new Tris(tabella);
            testTris.mossa(mossa.getX(), mossa.getY());
            RisultatoPartita risultato = testTris.controllaVincitore();



            switch (risultato) {
                case Pareggio -> punteggio = 0;
                case VinceX -> punteggio = -1;
                case VinceO -> punteggio = 1;
                case PartitaNonConclusa -> punteggio = - punteggioMossa(testTris.getTabella());
            }
        }
        return punteggio;
    }
}
