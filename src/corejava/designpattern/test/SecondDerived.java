package corejava.designpattern.test;

import java.util.function.Consumer;

public class SecondDerived extends FirstDerived {
    Consumer<Integer> abc;
    public SecondDerived() {
        super("vikash");
        abc = this::returnInteger;
    }

    @Override
    public void testString() {
        super.testString();
        System.out.println("SecondDerived::testString()");
    }

    public static void main(String[] args) {
        SecondDerived sd = new SecondDerived();
        sd.testString();
        sd.abc.accept(20);
    }
}
