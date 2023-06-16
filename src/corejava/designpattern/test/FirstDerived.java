package corejava.designpattern.test;

public class FirstDerived extends BaseClassDecorator {

    public FirstDerived(String str) {
        super(str);
    }

    @Override
    public void stringIsNotBlank() {
        System.out.println("FirstDerived::stringIsNotBlank()");
    }

    @Override
    public void stringIsBlank() {
        System.out.println("FirstDerived::stringIsBlank()");
    }
}
