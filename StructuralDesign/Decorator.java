package StructuralDesign;

interface BasePizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 50.0;
    }
}

class FarmhousePizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

    @Override
    public double getCost() {
        return 150.0;
    }
}

abstract class ToppingDecorator implements BasePizza {
    BasePizza basePizza;

    public ToppingDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
}

class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", Cheese Topping";
    }

    @Override
    public double getCost() {
        return basePizza.getCost() + 20.0;
    }
}
class mushroomTopping extends ToppingDecorator {
    public mushroomTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription() + ", Mushroom Topping";
    }

    @Override
    public double getCost() {
        return basePizza.getCost() + 30.0;
    }
}



public class Decorator {
    public static void main(String[] args) {
        BasePizza pizza = new FarmhousePizza();
        System.out.println("Description: " + pizza.getDescription());

        pizza = new CheeseTopping(pizza);
        System.out.println("Description: " + pizza.getDescription());

        pizza = new mushroomTopping(pizza);
        System.out.println("Description: " + pizza.getDescription());
    }
}
