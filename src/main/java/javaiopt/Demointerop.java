package javaiopt;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class Demointerop {
    public static int TOTAL = 100;

    public int itotal = -100;

    public static void main(String[] args) {
        IFn require = Clojure.var("clojure.core", "require");
        // Load the clojure name space
        require.invoke(Clojure.read("day1.utilities"));
        // Invoke the method
        IFn factorial = Clojure.var("day1.utilities", "factorial");
        System.out.println("Factorial of 7 : " + factorial.invoke(7));
    }

    public void callDemo() {
        System.out.println("Calling demo");
    }
}
