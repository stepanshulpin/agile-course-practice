package ru.unn.agile.GameOfLife.model;

public class GameOfLife {
    private char[][] Grid;
    private int height;
    private int width;

    public GameOfLife(int height, int width){
        this.height = height;
        this.width = width;

        Grid = new char[this.height][this.width];

        for(int i = 0; i <this.height; i++)
            for(int j = 0; j <this.width; j++)
                Grid[i][j] = '.';
    }

    public boolean IsPointOnGrid(int y, int x){
        if((y >= 0) && (y < this.width) && (x >= 0) && (x < this.height))
            return true;
        else
            return false;
    }

    public void SetCell(int y, int x){
        if(IsPointOnGrid(y,x))
            Grid[y][x] = '*';
    }

    public void DeleteCell(int y, int x){
        Grid[y][x] = '.';
    }
    public boolean IsCellLive(int y, int x) {
        if(IsPointOnGrid(y,x))
            return Grid[y][x]=='*';
        else
            return false;
    }

    public int CheckNeighborsNum(int y, int x){
        int NeighborsNum = 0;
        for(int i = y-1; i <= y+1; i++)
            for(int j = x-1; j <= x+1; j++)
                    if ((i != 0) || (j != 0)) {
                        NeighborsNum += this.IsCellLive(i, j) ? 1 : 0;
                    }
        return NeighborsNum;
    }

    public void MakeTurn(){
        for(int i = 0; i <this.height; i++)
            for(int j = 0; j <this.width; j++)
                if (Grid[i][j] == '*')
                    Grid[i][j] = '.';
    }
}

