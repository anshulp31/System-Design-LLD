package BehavioralDesign;

//Strategy Design Pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime by changing the context.

//Bad design example without Strategy Pattern

//below example is not following the Open/Closed Principle because if we need to add a new payment method, we have to modify the PaymentContext class.and also single responsibility principle because PaymentContext class is responsible for handling multiple payment methods.



// class PaymentContext{
//     void executePaymentStrategy(String PaymentType, double amount){
//         if(PaymentType.equalsIgnoreCase("CREDITCARD")){
//         }
//         else if(PaymentType.equalsIgnoreCase("PAYPAL")){   }
//         else if(PaymentType.equalsIgnoreCase("UPI")){}
//     }
// }

//Better design using Strategy Pattern
//In this example, we define a PaymentStrategy interface with a pay method. We then create concrete strategy classes for different payment methods, such as CreditCardPayment and UPIPayment, in future if need to add more payment methods, we can simply create new classes that implement the PaymentStrategy interface without modifying existing code.

interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Paid "+amount+" using Credit Card.");
    }
}

class UPIPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Paid"+amount+" using UPI.");
    }
}

class PaymentContext{
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount){
        paymentStrategy.pay(amount);
    }
}

public class StrategyDesign {
    public static void main(String[] args) {
        PaymentContext paymentContext=new PaymentContext();

        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.executePayment(1000.0);

        paymentContext.setPaymentStrategy(new UPIPayment());
        paymentContext.executePayment(500.0);
    }    

}
