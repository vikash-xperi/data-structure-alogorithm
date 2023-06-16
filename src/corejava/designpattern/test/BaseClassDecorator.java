package corejava.designpattern.test;

public class BaseClassDecorator {
    private String str1;

    public BaseClassDecorator(String str1) {
        this.str1 = str1;
    }

    public void testString() {
        System.out.println("BaseClassDecorator::testString()");
        if (str1.equals("")) {
            stringIsBlank();
        } else {
            stringIsNotBlank();
        }
    }

    public void stringIsNotBlank() {
        System.out.println("BaseClassDecorator::stringIsNotBlank()");
    }

    public void stringIsBlank() {
        System.out.println("BaseClassDecorator::stringIsBlank()");
    }

    public void returnInteger(Integer integer) {
        System.out.println("BaseClassDecorator::returnInteger(" + integer + ")");
    }
}
