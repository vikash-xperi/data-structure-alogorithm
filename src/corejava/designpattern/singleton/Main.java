package corejava.designpattern.singleton;

class Singleton {
    public static Singleton single_instance = null;
    public String s;
    private Singleton() {
        s = "Hello World";
    }
    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
}
public class Main {
    public static void main(String[] args) {
        Singleton s1= Singleton.getInstance();
        Singleton s2= Singleton.getInstance();
        System.out.println(s1.s);
        System.out.println(s2.s);

    }
}
