package conway;

public class Life {
    private int rows;
    private int cols;
    private Grid grid;

    public Life(int rowsNum, int colsNum) {
        this.rows = rowsNum;
        this.cols = colsNum;
        this.grid = new Grid(rows, cols);  // Create grid instance
    }

    public int getRowsNum() {
        return rows;
    }

    public int getColsNum() {
        return cols;
    }

    public void resetGrids() {
        grid.resetGrid();
    }

    protected void computeNextGen(IOutDev outdev) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int numNeighbors = grid.countNeighborsLive(i, j);
                grid.applyRules(i, j, numNeighbors);
                //outdev.displayCell("" + grid.getCellState(i, j));  // Display cell state
            }
            //outdev.displayCell("\n");
        }
        grid.copyAndResetGrid();  // Copy nextGrid to grid and reset nextGrid
    }

    public void switchCellState(int i, int j) {
        grid.switchCellState(i, j);  // Switch cell state
    }

    public int getCellState(int i, int j) {
        return grid.getCellState(i, j);  // Get cell state
    }
}
