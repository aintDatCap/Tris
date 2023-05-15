package tris;

public enum RisultatoPartita {
    VinceX,
    VinceO,
    Pareggio,
    PartitaNonConclusa;

    public static RisultatoPartita daSimbolo(Simbolo simbolo) {
        switch (simbolo) {
            case O -> {
                return VinceO;
            }
            case X -> {
                return VinceX;
            }
            default -> {
                return PartitaNonConclusa;
            }
        }
    }
}
