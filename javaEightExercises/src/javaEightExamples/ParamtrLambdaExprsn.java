package javaEightExamples;

interface MyfunctionalInterface{
    void show(String s);
}
public class ParamtrLambdaExprsn {
    public static void main(String[] args) {
        MyfunctionalInterface myfunctionalInterface=(n)->{ System.out.println(n);};
        MyfunctionalInterface myfunctionalInterface1=n->System.out.println(n);
        MyfunctionalInterface myfunctionalInterface2=n->{System.out.println(n);
                                                            System.out.println(n+" Multiple line impl");
        };
        myfunctionalInterface.show("Success!");
        myfunctionalInterface1.show("Without parenthesis");
        myfunctionalInterface2.show("ok: ");
    }
}
