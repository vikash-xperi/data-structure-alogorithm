package corejava.designpattern.decorator;

abstract class Pizza {
    private String description;
    abstract String getDescription();
    public abstract int getCost();
}
class PeppyPaneer extends Pizza{
    @Override
    public int getCost() {
        return 100;
    }
    @Override
    String getDescription() {
        return "Peppy Paneer";
    }
}
class Farmhouse extends Pizza{
    @Override
    public int getCost() {
        return 200;
    }
    @Override
    String getDescription() {
        return "Farmhouse";
    }
}
abstract class ToppingDecorators extends Pizza{
    public abstract String getDescription();
}
class Jalepeno extends ToppingDecorators{
    Pizza pizza;
    Jalepeno(Pizza pizza) {
        this.pizza = pizza;
    }
    public int getCost() {
        return 30 + pizza.getCost();
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + " Jalepeno";
    }
}
class FreshTomato extends ToppingDecorators {
    Pizza pizza;
    public int getCost() {
        return 20 + pizza.getCost();
    }
    FreshTomato(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + " Fresh Tomato";
    }
}
public class PizzaStore {
    public static void main(String[] args) {
        Pizza peppyPaneer = new PeppyPaneer();
        peppyPaneer = new FreshTomato(peppyPaneer);
        System.out.println(peppyPaneer.getDescription() + " Cost: " + peppyPaneer.getCost());
    }
}
