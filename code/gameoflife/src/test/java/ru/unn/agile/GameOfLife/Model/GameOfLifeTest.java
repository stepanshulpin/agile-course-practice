package ru.unn.agile.GameOfLife.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {
    @Test
    public void canCreateGrid() {
        GameOfLife g = new GameOfLife(3,3);

        assertNotNull(g.IsCellLive(1,1));
    }

    @Test
    public void canSetCell(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(1,1);

        assertTrue(g.IsCellLive(1,1));
    }

    @Test
    public void areAllStartCellsDead(){
        int size = 4;
        GameOfLife g = new GameOfLife(size,size);

        for(int i = 0; i <size; i++)
            for(int j = 0; j <size; j++)
                assertFalse(g.IsCellLive(1,1));
    }

    @Test
    public void canDeleteCell(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(1,1);

        g.DeleteCell(1,1);
        assertFalse(g.IsCellLive(1,1));
    }

    @Test
    public void canMakeTurn(){
        GameOfLife g = new GameOfLife(3,3);

        g.MakeTurn();

        assertFalse(g.IsCellLive(1,1));
    }

    @Test
    public void isOneLivingCellDies(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(1,1);

        g.MakeTurn();

        assertFalse(g.IsCellLive(1,1));
    }

    @Test
    public void isNeighborsNumCorrect(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(0,1);
        g.SetCell(1,0);

        assertEquals(2, g.CheckNeighborsNum(1,1));
    }

    @Test
    public void isNeighborsNumCorrectOnLeftBorder(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(0,1);
        g.SetCell(1,0);

        assertEquals(2, g.CheckNeighborsNum(0,0));
    }

    @Test
    public void isNeighborsNumCorrectOnRightBorder(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(1,1);
        g.SetCell(1,2);

        assertEquals(2, g.CheckNeighborsNum(2,2));
    }

    @Test
    public void canGetCellBeyondBorder(){
        GameOfLife g = new GameOfLife(3,3);

        assertFalse(g.IsCellLive(4,4));
    }

    @Test
    public void canSetCellBeyondBorder(){
        GameOfLife g = new GameOfLife(3,3);
        g.SetCell(4,4);

        assertFalse(g.IsCellLive(4,4));
    }

}