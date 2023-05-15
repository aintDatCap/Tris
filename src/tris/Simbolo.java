package tris;

public enum Simbolo {
    X(1),
    O(-1),
    Nessuno(0);

    private int value;
    Simbolo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
