package javaEightExamples;

@FunctionalInterface
interface MyInterface {
    public void show();
}

//class B implements MyInterface{
//    @Override
//    public void show() {
//        System.out.println("This is implemented method");
//    }
//}

public class LambdaExprsn {
    public static void main(String[] args) {

        MyInterface myInterface = () -> {
                System.out.println("This is lambda expression");
            };

        myInterface.show();
    }

}
