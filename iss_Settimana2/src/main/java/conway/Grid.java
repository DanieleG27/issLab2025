package conway;

public class Grid {
    private int rows;
    private int cols;
    private int[][] grid;
    private int[][] nextGrid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        createGrids();
    }

    private void createGrids() {
        grid = new int[rows][cols];
        nextGrid = new int[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getCellState(int row, int col) {
        return grid[row][col];
    }

    public void setCellState(int row, int col, int state) {
        grid[row][col] = state;
    }

    public void resetGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = 0;
                nextGrid[i][j] = 0;
            }
        }
    }

    public int countNeighborsLive(int row, int col) {
        int count = 0;
        // Checking all 8 neighbors
        if (row - 1 >= 0 && grid[row - 1][col] == 1) count++;  // North
        if (row + 1 < rows && grid[row + 1][col] == 1) count++;  // South
        if (col - 1 >= 0 && grid[row][col - 1] == 1) count++;  // West
        if (col + 1 < cols && grid[row][col + 1] == 1) count++;  // East
        if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 1) count++;  // North-West
        if (row - 1 >= 0 && col + 1 < cols && grid[row - 1][col + 1] == 1) count++;  // North-East
        if (row + 1 < rows && col - 1 >= 0 && grid[row + 1][col - 1] == 1) count++;  // South-West
        if (row + 1 < rows && col + 1 < cols && grid[row + 1][col + 1] == 1) count++;  // South-East
        return count;
    }

    public void copyAndResetGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = nextGrid[i][j];
                nextGrid[i][j] = 0;
            }
        }
    }

    public void applyRules(int row, int col, int numNeighbors) {
        if (grid[row][col] == 1) {  // Cell is alive
            if (numNeighbors < 2) {
                nextGrid[row][col] = 0;  // Dies due to under-population
            } else if (numNeighbors == 2 || numNeighbors == 3) {
                nextGrid[row][col] = 1;  // Survives
            } else if (numNeighbors > 3) {
                nextGrid[row][col] = 0;  // Dies due to over-population
            }
        } else {  // Cell is dead
            if (numNeighbors == 3) {
                nextGrid[row][col] = 1;  // Becomes alive due to reproduction
            }
        }
    }

    public void switchCellState(int row, int col) {
        grid[row][col] = (grid[row][col] == 0) ? 1 : 0;
    }

    public void displayGrid(IOutDev outdev) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                outdev.displayCell("" + grid[i][j]);
            }
            outdev.displayCell("\n");
        }
    }
}
