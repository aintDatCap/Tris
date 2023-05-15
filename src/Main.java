import tris.Tris;

public class Main {
    public static void main(String[] args) {
        Tris tris = new Tris();
        tris.mossa(1, 0);
        tris.mossa(0,0);
        tris.mossa(1,0);
        tris.mossa(1,1);
        tris.mossa(1,2);
        tris.mossa(2,2);

        System.out.print(tris);
        System.out.println("\n"+tris.controllaVincitore());

    }
}