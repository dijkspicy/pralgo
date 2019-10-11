package test;

public class TryFinallyTest {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static String test() {
        try {
            "".matches("");
            System.out.println("try");
            return "try";
        } catch (Exception e) {
            System.out.println("catch");
            return "catch";
        } finally {
            System.out.println("finally");
            return "finally";
        }
    }
}
