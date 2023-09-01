package javaEightExamples;

import java.util.Comparator;

public class ComparatorDemo implements Comparator {
    public static void main(String[] args) {

    }

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }
}
