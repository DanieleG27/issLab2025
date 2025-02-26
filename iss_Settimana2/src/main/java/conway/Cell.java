package conway;

public class Cell {
    private int row;
    private int col;
    private boolean alive;

    // Costruttore: imposta la posizione e lo stato della cella (viva o morta)
    public Cell(int row, int col, boolean alive) {
        this.row = row;
        this.col = col;
        this.alive = alive;
    }

    // Restituisce lo stato della cella (viva o morta)
    public boolean isAlive() {
        return alive;
    }

    // Imposta lo stato della cella (viva o morta)
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // Restituisce la riga della cella
    public int getRow() {
        return row;
    }

    // Restituisce la colonna della cella
    public int getCol() {
        return col;
    }
}