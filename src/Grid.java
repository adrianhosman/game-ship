import org.testng.annotations.Test;

public class Grid {
    private int size;
    private char[][] grid;

    public Grid(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initGrid();
    }

    private void initGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '_';
            }
        }
    }

    public void shipPos(int x, int y) {
        grid[x][y] = 'B';
    }

    public void updateGrid(int x, int y) {
        if (grid[x][y] == 'B') {
            grid[x][y] = 'X';
        } else {
            grid[x][y] = 'O';
        }
    }

    public void displayGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getTotalHits() {
        int hits = 0;
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == 'X') {
                    hits++;
                }
            }
        }
        return hits;
    }
}
