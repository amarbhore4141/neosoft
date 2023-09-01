package javaEightExamples;

import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {
        List<Integer> age = Arrays.asList(2, 3, 7, 1, 34, 12, 1);
        List<Integer> copyOfAge = new ArrayList<>();


//iterator
        Iterator iterator = age.iterator();
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }

        //ListIterator
        ListIterator listIterator= age.listIterator(age.size());
        System.out.println("\n In reverse order : ");
        while (listIterator.hasPrevious()){

            System.out.print(" "+ listIterator.previous());
        }
    }
}