package ru.unn.agile.datastructure.set.model;

public class MySet {
    private final double re;
    private final double im;

    public MySet() {
        re = 0;
        im = 0;
    }

    public MySet(final double re, final double im) {
        this.re = re;
        this.im = im;
    }

    public MySet(final String re, final String im) {
        this.re = Double.parseDouble(re);
        this.im = Double.parseDouble(im);
    }

    @Override
    public int hashCode() {
        final int shift = 32;

        long temp = Double.doubleToLongBits(re);
        int result = (int) (temp ^ (temp >>> shift));
        temp = Double.doubleToLongBits(im);
        result = (shift - 1) * result + (int) (temp ^ (temp >>> shift));
        return result;
    }

    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MySet)) {
            return false;
        }
        return hashCode() == object.hashCode();
    }

    public MySet add(final MySet other) {
        return new MySet(other.getReal() + getReal(),
                other.getImaginary() + getImaginary());
    }

    public MySet multiply(final MySet other) {
        return new MySet(
                other.getReal() * getReal() - other.getImaginary() * getImaginary(),
                other.getReal() * getImaginary() + other.getImaginary() * getReal());
    }

    public double getReal() {
        return re;
    }

    public double getImaginary() {
        return im;
    }

    public enum Operation {
        ADD("Add") {
            public MySet apply(final MySet l, final MySet r) {
                return l.add(r);
            }
        },
        MULTIPLY("Mul") {
            public MySet apply(final MySet l, final MySet r) {
                return l.multiply(r);
            }
        };

        private final String name;

        Operation(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        public abstract MySet apply(MySet l, MySet r);
    }
}
