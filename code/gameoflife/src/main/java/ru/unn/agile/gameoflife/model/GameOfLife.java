package ru.unn.agile.GameOfLife.model;

public class GameOfLife {
    public char[][] Grid;

    public GameOfLife(int height, int width){
        Grid = new char[height][width];

        for(int i = 0; i <height; i++)
            for(int j = 0; j <width; j++)
                Grid[i][j] = '.';
    }

    public void SetCell(int y, int x){
        Grid[y][x] = '*';
    }

    public void DeleteCell(int y, int x){
        Grid[y][x] = '.';
    }
    public char GetCell(int y, int x) {
        return Grid[y][x];
    }
}

