package javaiopt;

public class Demointerop {
    public static int TOTAL = 100 ;

    public int itotal = -100 ;

    public static void main(String[] args) {
        System.out.println("hello interopt");
        System.out.println(System.currentTimeMillis());
    }

    public void callDemo(){
        System.out.println("Calling demo");
    }
}
