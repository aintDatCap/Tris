package tris.bot;

import tris.Simbolo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomBot implements Bot{

    @Override
    public Coordinate mossa(Simbolo[][] tabella) {
        List<Coordinate> celleVuote = new ArrayList<>();

        for(int i = 0; i < tabella.length; i++) {
            for (int j = 0; j < tabella.length; j++) {
                if(tabella[i][j] == Simbolo.Nessuno)
                    celleVuote.add(new Coordinate(i, j));
            }
        }

        Random random = new Random();
        return celleVuote.get(random.nextInt(celleVuote.size()));
    }

}
