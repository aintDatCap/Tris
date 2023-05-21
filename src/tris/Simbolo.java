package tris;

public enum Simbolo {
    X(1, 'X'),
    O(-1, 'O'),
    Nessuno(0, ' ');

    private final int value;
    private final char c;
    Simbolo(int value, char c) {
        this.value = value;
        this.c = c;
    }

    public int getValue() {
        return value;
    }
    public String asString() {
        return String.valueOf(c);
    }
}
