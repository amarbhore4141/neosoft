package javaEightExamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Integer> integersList= Arrays.asList(1,3,7,8,3,88,44);
        System.out.println("before sorting :"+integersList);
        Collections.sort(integersList);
        System.out.println("After sorting : "+integersList);

        List<Student> studentList=Arrays.asList(new Student(3,"a"),new Student(2,"b"),new Student(1,"c"));
        System.out.println("before sorting :"+studentList);
        Collections.sort(studentList);
        System.out.println("sorted List: "+studentList);

    }
}
