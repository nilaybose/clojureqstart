package javaiopt;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import java.util.ArrayList;

public class Demointerop {
    public static int TOTAL = 100 ;

    public int itotal = -100 ;

    public static void main(String[] args) {
        // Invoke clojure
        IFn factorial = Clojure.var("clojureqstart.utilities", "factorial");

        System.out.println("Factorial of 7 : " + factorial.invoke(7));
    }

    public void callDemo(){
        System.out.println("Calling demo");
    }

}
