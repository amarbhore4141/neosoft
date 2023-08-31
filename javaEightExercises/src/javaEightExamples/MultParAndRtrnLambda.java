package javaEightExamples;

interface Mint {
    int math(int a, int b);
}

public class MultParAndRtrnLambda {
    public static void main(String[] args) {

        Mint m = (localA, LocalB) -> {
            int c = localA + LocalB;
            return c;
        };

        System.out.println(m.math(3,7));

    }
}
