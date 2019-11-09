package ru.unn.agile.GameOfLife.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {
    @Test
    public void canCreateGrid() {
        GameOfLife g = new GameOfLife(3, 3);

        assertNotNull(g.isCellLive(1, 1));
    }

    @Test
    public void canSetCell() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(1, 1);

        assertTrue(g.isCellLive(1, 1));
    }

    @Test
    public void areAllStartCellsDead() {
        int size = 4;
        GameOfLife g = new GameOfLife(size, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertFalse(g.isCellLive(1, 1));
            }
        }
    }

    @Test
    public void canDeleteCell() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(1, 1);

        g.deleteCell(1, 1);
        assertFalse(g.isCellLive(1, 1));
    }

    @Test
    public void canMakeTurn() {
        GameOfLife g = new GameOfLife(3, 3);

        g.makeTurn();

        assertFalse(g.isCellLive(1, 1));
    }

    @Test
    public void isOneLivingCellDies() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(1, 1);

        g.makeTurn();

        assertFalse(g.isCellLive(1, 1));
    }

    @Test
    public void isNeighborsNumCorrect() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(0, 1);
        g.setCell(1, 0);

        assertEquals(2, g.getNeighborsNum(1, 1));
    }

    @Test
    public void isNeighborsNumCorrectOnLeftBorder() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(0, 1);
        g.setCell(1, 0);

        assertEquals(2, g.getNeighborsNum(0, 0));
    }

    @Test
    public void isNeighborsNumCorrectOnRightBorder() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(1, 1);
        g.setCell(1, 2);

        assertEquals(2, g.getNeighborsNum(2, 2));
    }

    @Test
    public void canGetCellBeyondBorder() {
        GameOfLife g = new GameOfLife(3, 3);

        assertFalse(g.isCellLive(4, 4));
    }

    @Test
    public void canSetCellBeyondBorder() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(4, 4);

        assertFalse(g.isCellLive(4, 4));
    }

    @Test
    public void canCreateNegativeGrid() {
        GameOfLife g = new GameOfLife(-3, -3);

        assertNotNull(g);
    }

    @Test
    public void isCellWithTwoNeighboursLive() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(1, 1); // .*.
        g.setCell(1, 0); // **.
        g.setCell(0, 1); // ...

        g.makeTurn();

        assertTrue(g.isCellLive(1, 1));
    }

    @Test
    public void isCellWithThreeNeighboursLive() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(0, 0); // **.
        g.setCell(0, 1); // **.
        g.setCell(1, 0); // ...
        g.setCell(1, 1);


        g.makeTurn();

        assertTrue(g.isCellLive(0, 0));
    }

    @Test
    public void isCellWithThreeNeighboursRevive() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(0, 0); // **.
        g.setCell(0, 1); // *..
        g.setCell(1, 0); // ...

        g.makeTurn();

        assertTrue(g.isCellLive(0, 0));
    }

    @Test
    public void isCellWithFourNeighborsDies() {
        GameOfLife g = new GameOfLife(3, 3);
        g.setCell(0, 0); // **.
        g.setCell(0, 1); // ***
        g.setCell(1, 0); // ...
        g.setCell(1, 1);
        g.setCell(1, 2);

        g.makeTurn();

        assertFalse(g.isCellLive(1, 1));
    }

    @Test
    public void canCreateFromString() {
        GameOfLife g = new GameOfLife("..."
                                    + ".*."
                                    + "...", 3, 3);

        assertTrue(g.isCellLive(1, 1));
    }

}
