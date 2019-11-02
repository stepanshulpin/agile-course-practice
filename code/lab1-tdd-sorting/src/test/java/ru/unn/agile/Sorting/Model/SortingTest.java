package ru.unn.agile.sorting.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortingTest {

    @Test
    public void canCreateSorting() {
        assertNotNull(new Sorting());
    }

    @Test
    public void canCreateSortingWithDirection() {
        assertNotNull(new Sorting(Direction.ASC));
    }

    @Test
    public void canSortZeroNumber() {
        int[] numbers = {};
        Sorting sorting = new Sorting();
        assertArrayEquals(new int[]{}, sorting.sort(numbers));
    }

    @Test
    public void canSortZeroNumberDesc() {
        int[] numbers = {};
        Sorting sorting = new Sorting(Direction.DESC);
        assertArrayEquals(new int[]{}, sorting.sort(numbers));
    }

    @Test
    public void canSortOneNumberAsc() {
        int[] numbers = {2};
        Sorting sorting = new Sorting(Direction.ASC);
        assertArrayEquals(new int[]{2}, sorting.sort(numbers));
    }

    @Test
    public void canSortOneNumberDesc() {
        int[] numbers = {2};
        Sorting sorting = new Sorting(Direction.DESC);
        assertArrayEquals(new int[]{2}, sorting.sort(numbers));
    }

    @Test
    public void canSortTwoNumbers() {
        int[] numbers = {2, 1};
        Sorting sorting = new Sorting();
        assertArrayEquals(new int[]{1, 2}, sorting.sort(numbers));
    }

    @Test
    public void canSortTwoNumbersDesc() {
        int[] numbers = {1, 2};
        Sorting sorting = new Sorting(Direction.DESC);
        assertArrayEquals(new int[]{2, 1}, sorting.sort(numbers));
    }

    @Test
    public void canSortTwoNumbersAsc() {
        int[] numbers = {2, 1};
        Sorting sorting = new Sorting(Direction.ASC);
        assertArrayEquals(new int[]{1, 2}, sorting.sort(numbers));
    }

    @Test
    public void canSortThreeNumbers() {
        int[] numbers = {2, 1, 3};
        Sorting sorting = new Sorting();
        assertArrayEquals(new int[]{1, 2, 3}, sorting.sort(numbers));
    }

    @Test
    public void canSortThreeNumbersDesc() {
        int[] numbers = {2, 1, 3};
        Sorting sorting = new Sorting(Direction.DESC);
        assertArrayEquals(new int[]{3, 2, 1}, sorting.sort(numbers));
    }

    @Test
    public void canSortThreeNumbersAsc() {
        int[] numbers = {2, 1, 3};
        Sorting sorting = new Sorting(Direction.ASC);
        assertArrayEquals(new int[]{1, 2, 3}, sorting.sort(numbers));
    }

    @Test
    public void canSortTenNumbersDesc() {
        int[] numbers = {2, 1, 3, 6, 9, 7, 4, 8, 5};
        Sorting sorting = new Sorting(Direction.DESC);
        assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, sorting.sort(numbers));
    }

    @Test
    public void canSortTenNumbersAsc() {
        int[] numbers = {2, 1, 3, 6, 9, 7, 4, 8, 5};
        Sorting sorting = new Sorting(Direction.ASC);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, sorting.sort(numbers));
    }

    @Test
    public void canSortNegativeNumbersAsc() {
        int[] numbers = {-2, -1, -3, -6, -9, -7, -4, -8, -5};
        Sorting sorting = new Sorting(Direction.ASC);
        assertArrayEquals(new int[]{-9, -8, -7, -6, -5, -4, -3, -2, -1}, sorting.sort(numbers));
    }

    @Test
    public void canSortNegativeNumbersDesc() {
        int[] numbers = {-2, -1, -3, -6, -9, -7, -4, -8, -5};
        Sorting sorting = new Sorting(Direction.DESC);
        assertArrayEquals(new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9}, sorting.sort(numbers));
    }

    @Test
    public void canSortPositiveWithNegativeNumbersAsc() {
        int[] numbers = {-2, -1, 3, -6, 9, -7, 4, -8, -5};
        Sorting sorting = new Sorting(Direction.ASC);
        assertArrayEquals(new int[]{-8, -7, -6, -5, -2, -1, 3, 4, 9}, sorting.sort(numbers));
    }

    @Test
    public void canSortPositiveWithNegativeNumbersDesc() {
        int[] numbers = {-2, -1, 3, -6, 9, -7, 4, -8, -5};
        Sorting sorting = new Sorting(Direction.DESC);
        assertArrayEquals(new int[]{9, 4, 3, -1, -2, -5, -6, -7, -8}, sorting.sort(numbers));
    }

}
