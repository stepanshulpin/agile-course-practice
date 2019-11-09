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
    public void canCreateFromString() {
        int height = 3;
        int width = 3;
        GridString grid = new GridString(
                "..."
              + ".*."
              + "...", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        assertTrue(g.isCellLive(1, 1));
    }

    @Test
    public void isCellWithTwoNeighboursLive() {
        int height = 3;
        int width = 3;
        GridString grid = new GridString(
                ".*."
              + "**."
              + "...", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        g.makeTurn();

        assertTrue(g.isCellLive(1, 1));
    }

    @Test
    public void isCellWithThreeNeighboursLive() {
        int height = 3;
        int width = 3;
        GridString grid = new GridString(
                "**."
              + "**."
              + "...", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        g.makeTurn();

        assertTrue(g.isCellLive(0, 0));
    }

    @Test
    public void isCellWithThreeNeighboursRevive() {
        int height = 3;
        int width = 3;
        GridString grid = new GridString(
                "**."
              + "*.."
              + "...", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        g.makeTurn();

        assertTrue(g.isCellLive(0, 0));
    }

    @Test
    public void isCellWithFourNeighborsDies() {
        int height = 3;
        int width = 3;
        GridString grid = new GridString(
                "**."
              + "***"
              + "...", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        g.makeTurn();

        assertFalse(g.isCellLive(1, 1));
    }

    @Test
    public void canCopyGameState() {
        GameOfLife g1 = new GameOfLife(3, 3);
        g1.setCell(1, 1);

        GameOfLife g2 = new GameOfLife(g1);

        assertTrue(g2.isCellLive(1, 1));
    }

    @Test
    public void isCellsCalculatesWithoutOrder() {
        int height = 4;
        int width = 3;
        GridString grid = new GridString(
                "***"
              + ".*."
              + "*.*"
              + ".*.", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        g.makeTurn();

        assertTrue(g.isCellLive(2, 0));
    }

    @Test
    public void canCreateFromUncorrectString() {
        int height = 2;
        int width = 2;
        GridString grid = new GridString("1234", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        assertNotNull(g);
    }

    @Test
    public void canCreateFromShortString() {
        int height = 3;
        int width = 3;
        GridString grid = new GridString("..", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        assertNotNull(g);
    }

    @Test
    public void isGliderMove() {
        int height = 4;
        int width = 4;
        GridString grid = new GridString(
                "..*."
              + "*.*."
              + ".**."
              + "....", height, width);
        GameOfLife g = new GameOfLife(grid, height, width);


        g.makeTurn();
        g.makeTurn();
        g.makeTurn();
        g.makeTurn();

        assertTrue((g.isCellLive(3, 3)));

    }

    @Test
    public void canCreateFromArray() {
        int height = 3;
        int width = 3;
        char[][] arr = {
                {'.', '.', '.'},
                {'.', '*', '.'},
                {'.', '.', '.'},
        };
        GridArray grid = new GridArray(arr, height, width);

        GameOfLife g = new GameOfLife(grid, height, width);

        assertTrue((g.isCellLive(1, 1)));
    }

    @Test
    public void canCreateFromSmallerArray() {
        int height = 3;
        int width = 3;
        char[][] arr = {
                {'.', '.', '.'},
                {'.', '*', '.'},
        };
        GridArray grid = new GridArray(arr, height, width);

        GameOfLife g = new GameOfLife(grid, height, width);

        assertNotNull(g);
    }

    @Test
    public void isMakeTurnOutputCorrect() {
        int height = 3;
        int width = 3;
        char[][] stableGrid = {
                {'.', '*', '*'},
                {'.', '*', '*'},
                {'.', '.', '.'},
        };
        GridArray grid = new GridArray(stableGrid, height, width);
        GameOfLife g = new GameOfLife(grid, height, width);

        char[][] res = g.makeTurn();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                assertTrue(res[i][j] == stableGrid[i][j]);
            }
        }
    }

    @Test
    public void isGridChangesByChangingArray() {
        int height = 3;
        int width = 4;
        GridString grid = new GridString(
                "..*."
              + "*.*."
              + ".**.", height, width);

        GameOfLife g = new GameOfLife(grid, height, width);

        char[][] res = g.makeTurn();
        res[1][1] = '*';

        assertFalse(g.isCellLive(1, 1));
    }

}
