package ru.unn.agile.sorting.model;

public final class Sorting {

    private final Direction direction;

    public Sorting() {
        direction = Direction.ASC;
    }

    public Sorting(final Direction direction) {
        this.direction = direction;
    }

    public int[] sort(final int[] numbers) {
        if (numbers.length == 2) {
            sortTwoNumbers(numbers);
        }
        if (direction.equals(Direction.ASC)) {
            return ascSort(numbers);
        } else {
            return descSort(numbers);
        }
    }

    private int[] ascSort(final int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;
            while (j >= 0 && current < numbers[j]) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
        return numbers;
    }

    private int[] descSort(final int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;
            while (j >= 0 && current > numbers[j]) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
        return numbers;
    }

    public int[] sortTwoNumbers(final int[] numbers) {
        if (direction.equals(Direction.ASC)) {
            return ascSortTwoNumbers(numbers);
        } else {
            return descSortTwoNumbers(numbers);
        }
    }

    public static int[] ascSortTwoNumbers(final int[] numbers) {
        if (numbers[1] > numbers[0]) {
            return numbers;
        }
        return new int[]{numbers[1], numbers[0]};
    }

    public static int[] descSortTwoNumbers(final int[] numbers) {
        if (numbers[0] > numbers[1]) {
            return numbers;
        }
        return new int[]{numbers[1], numbers[0]};
    }
}
