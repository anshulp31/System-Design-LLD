package CreationalDesign;
//Builder Design Pattern is a creational design pattern that allows constructing complex objects step by step.

//In this example, we have a BurgerMeal class that represents a burger meal with required parameters (bunType and pattyType) and an optional parameter (hasCheese).

//The BurgerBuilder static nested class is used to build the BurgerMeal object. It provides methods to set the required and optional parameters and a build() method to create the BurgerMeal object.

//This pattern is useful when an object has many parameters, especially optional ones, as it helps to avoid constructor overloading and makes the code more readable.

class BurgerMeal{
    //Required parameters
    private final String bunType;
    private final String pattyType;

    //Optional parameters
    private boolean hasCheese;

    public BurgerMeal(BurgerBuilder builder){
        this.bunType=builder.bunType;
        this.pattyType=builder.pattyType;
        this.hasCheese=builder.hasCheese;
    }

    public static class BurgerBuilder {
    
        //Required parameters
        private String bunType;
        private String pattyType;

        //Optional parameters
        private boolean hasCheese;

        public BurgerBuilder setBuntype(String type){
            this.bunType=type;
            return this;
        }

        public BurgerBuilder setPattyType(String type){
            this.pattyType=type;
            return this;
        }
        public BurgerBuilder setCheese(boolean hasCheese){
            this.hasCheese=hasCheese;
            return this;
        }

        public BurgerMeal build(){
            return new BurgerMeal(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        BurgerMeal burgerMeal=new BurgerMeal.BurgerBuilder().setBuntype("Wheat").
        setPattyType("Veggie")
        .setCheese(true).build();
    }
}
