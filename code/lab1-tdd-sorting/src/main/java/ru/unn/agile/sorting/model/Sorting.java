package ru.unn.agile.sorting.model;

public final class Sorting {

    private final Direction direction;

    public Sorting() {
        direction = Direction.ASC;
    }

    public Sorting(Direction direction) {
        this.direction = direction;
    }

    public int[] sort(int[] numbers) {
        if (direction.equals(Direction.ASC)) {
            return ascSort(numbers);
        } else {
            return descSort(numbers);
        }
    }

    public static int[] ascSort(int[] numbers) {
        if (numbers[1] > numbers[0]) {
            return new int[]{numbers[0], numbers[1]};
        }
        return new int[]{numbers[1], numbers[0]};
    }

    public static int[] descSort(int[] numbers) {
        if (numbers[0] > numbers[1]) {
            return new int[]{numbers[0], numbers[1]};
        }
        return new int[]{numbers[1], numbers[0]};
    }

}
