package javaEightExamples;

import java.util.*;

public class SortingExample {
    public static void main(String[] args) {
        List<Integer> age= Arrays.asList(2,3,7,1,34,12,1);
        List<Integer> copyOfAge = new ArrayList<>();
        System.out.println("Before sorting: "+age);
        Collections.sort(age);
        System.out.println("after sorting"+age);
        Collections.reverse(age);
        System.out.println("Reverse List"+age);

        System.out.println("Max Age: "+Collections.max(age));
        System.out.println("Min age : "+Collections.min(age));


        for (int i = 0; i < age.size(); i++) {
            copyOfAge.add(null);
        }
        Collections.copy(copyOfAge,age);
        System.out.println("copied list: "+copyOfAge);

//iterator
        Iterator iterator= age.iterator();
        while(iterator.hasNext()){
            System.out.print(" "+ iterator.next());
        }
        //listIterator
        ListIterator listIterator= copyOfAge.listIterator(copyOfAge.size());
        System.out.println("\n In reverse order : ");
        while (listIterator.hasPrevious()){

            System.out.print(" "+ listIterator.previous());
                   }

    }
}
