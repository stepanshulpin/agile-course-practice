package ru.unn.agile.GameOfLife.model;

public class GameOfLife {
    private char[][] grid;
    private int height;
    private int width;

    public GameOfLife(int height, int width) {
        if ((height < 0) && (width < 0)) {
            this.height = 0;
            this.width = 0;
        }
        else {
            this.height = height;
            this.width = width;
        }

        grid = new char[this.height][this.width];

        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < this.width; j++)
                grid[i][j] = '.';
    }

    public GameOfLife(String str, int height, int width) {
        this(height, width);

        for(int i = 0; i <this.height; i++)
            for(int j = 0; j <this.width; j++)
                grid[i][j] = str.charAt(i*this.width+j);
    }

    public boolean isPointOnGrid(int y, int x) {
        if((y >= 0) && (y < this.width) && (x >= 0) && (x < this.height))
            return true;
        else
            return false;
    }

    public void setCell(int y, int x) {
        if(isPointOnGrid(y, x))
            grid[y][x] = '*';
    }

    public void deleteCell(int y, int x) {
        grid[y][x] = '.';
    }
    public boolean isCellLive(int y, int x) {
        if(isPointOnGrid(y, x))
            return grid[y][x] == '*';
        else
            return false;
    }

    public int getNeighborsNum(int y, int x) {
        int NeighborsNum = 0;
        for(int i = y-1; i <= y+1; i++)
            for(int j = x-1; j <= x+1; j++)
                    if ((i != 0) || (j != 0)) {
                        NeighborsNum += this.isCellLive(i, j) ? 1 : 0;
                    }
        return NeighborsNum;
    }

    public void makeTurn() {
        for(int i = 0; i < this.height; i++)
            for(int j = 0; j < this.width; j++) {
                if ((getNeighborsNum(i, j) < 2) || (getNeighborsNum(i, j) > 3))
                    deleteCell(i, j);
                if (getNeighborsNum(i, j) == 3)
                    setCell(i,j);
            }
    }

}


