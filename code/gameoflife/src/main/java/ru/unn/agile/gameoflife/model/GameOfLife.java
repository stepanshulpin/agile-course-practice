package ru.unn.agile.GameOfLife.model;

public class GameOfLife {
    private char[][] grid;
    private int height;
    private int width;

    public GameOfLife(final int height, final int width) {
        if ((height < 0) && (width < 0)) {
            this.height = 0;
            this.width = 0;
        } else {
            this.height = height;
            this.width = width;
        }

        grid = new char[this.height][this.width];

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public GameOfLife(final String str, final int height, final int width) {
        this(height, width);

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                grid[i][j] = str.charAt(i * this.width + j);
            }
        }
    }

    public boolean isPointOnGrid(final int y, final int x) {
        return ((y >= 0) && (y < this.width) && (x >= 0) && (x < this.height));
    }

    public void setCell(final int y, final int x) {
        if (isPointOnGrid(y, x)) {
            grid[y][x] = '*';
        }
    }

    public void deleteCell(final int y, final int x) {
        grid[y][x] = '.';
    }

    public boolean isCellLive(final int y, final int x) {
        if (isPointOnGrid(y, x)) {
            return grid[y][x] == '*';
        } else {
            return false;
        }
    }

    public int getNeighborsNum(final int y, final int x) {
        int neighborsNum = 0;
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if ((i != 0) || (j != 0)) {
                    neighborsNum += this.isCellLive(i, j) ? 1 : 0;
                }
            }
        }

        return neighborsNum;
    }

    public void makeTurn() {
        final int maxNeighbours = 3;
        final int neighboursToReproduce = 3;
        final int minNeighbours = 2;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if ((getNeighborsNum(i, j) < minNeighbours)
                 || (getNeighborsNum(i, j) > maxNeighbours)) {
                    deleteCell(i, j);
                }
                if (getNeighborsNum(i, j) == neighboursToReproduce) {
                    setCell(i, j);
                }
            }
        }
    }

}
