package ru.unn.agile.GameOfLife.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {
    @Test
    public void canCreateGrid() {
        GameOfLife g = new GameOfLife(4,4);

        assertNotNull(g.Grid);
    }

    @Test
    public void canSetCell(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(1,1);

        assertEquals('*', g.GetCell(1,1));
    }

    @Test
    public void areAllStartCellsDead(){
        int size = 4;
        GameOfLife g = new GameOfLife(size,size);

        for(int i = 0; i <size; i++)
            for(int j = 0; j <size; j++)
                assertEquals('.', g.GetCell(i,j));
    }

    @Test
    public void canDeleteCell(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(1,1);

        g.DeleteCell(1,1);
        assertEquals('.', g.GetCell(1,1));
    }
}