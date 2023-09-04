package javaEightExamples;

import java.util.Optional;

public class OptionalExample {

    //in entity class dont make variables optional , because it wont get serialised
    //if we dont want to serialise any field then make it optional,json exclude, jsonIgnore,@transitional
    public static String str = "rSFDSDFdsfsfa";
    public static String fname = null;
    public static String msg = "null";

    public static Optional<String> getFirstName() {
        msg = "Hello how are you?";
        return Optional.of(msg);
    }

    public static void main(String[] args) {


        //throws nullPointer Exception
        //System.out.println(str.toLowerCase());
        if (str != null) {
            System.out.println(str.toLowerCase());
        } else {
            System.out.println("String is Null!");
        }
//isPresent Method return boolean value
        Optional<String> str1 = Optional.ofNullable(str);
        System.out.println("Is the String Present : " + str1.isPresent());
        System.out.println(str1.orElse("String is null"));

        //method reference
        str1.ifPresent(System.out::println);
        //lambda Expression
        str1.ifPresent(s -> {
            System.out.println(s.toLowerCase());
            System.out.println(s.toUpperCase());
        });

        //method calling with optional return Type
        System.out.println(getFirstName().orElse("Not present!"));

        Optional<String> fname1 =Optional.ofNullable(fname);
        fname1.ifPresent(n->System.out.println("Name is :"+n));


    }
}
