package StructuralDesign.AdapterPattern;

//Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces, enabling them to communicate and collaborate effectively.

//Here the target interface is PaymentProcessor, which defines the methods for processing payments. The RazorpaySDK class represents a third-party payment gateway with its own interface. The RazorpayAdapter class adapts the RazorpaySDK interface to the PaymentProcessor interface, allowing it to be used seamlessly in the Checkout class, which implements the PaymentProcessor interface.
interface PaymentProcessor {
    void pay(double amount);
    boolean isPaymentSuccessful();
    String getTransactionId();
}

// The RazorpaySDK class represents a third-party payment gateway with its own interface.
class RazorpaySDK {
    public void makePayment(double amount) {
        // Simulate payment processing logic
        System.out.println("RazorpaySDK: Processing payment of $" + amount);
    }

    public boolean checkStatus() {
        // Simulate checking payment status
        return true; // Assume payment is successful for demonstration
    }

    public String getReferenceNumber() {
        // Simulate generating a transaction ID
        return "RAZORPAY_TXN123456"; // Simulated transaction ID
    }
}

// The RazorpayAdapter class adapts the RazorpaySDK interface to the PaymentProcessor interface.
class RazorpayAdapter implements PaymentProcessor {
    private RazorpaySDK razorpaySDK;
    private boolean paymentSuccessful;
    private String transactionId;

    public RazorpayAdapter(RazorpaySDK razorpaySDK) {
        this.razorpaySDK = razorpaySDK;
    }

    @Override
    public void pay(double amount) {
        razorpaySDK.makePayment(amount);
        this.paymentSuccessful = razorpaySDK.checkStatus();
        this.transactionId = razorpaySDK.getReferenceNumber();
    }

    @Override
    public boolean isPaymentSuccessful() {
        return this.paymentSuccessful;
    }

    @Override
    public String getTransactionId() {
        return this.transactionId;
    }
}

// The InHousePaymentProcessor class implements the PaymentProcessor interface and represents a payment processing system.
class InHousePaymentProcessor implements PaymentProcessor {
    private boolean paymentSuccessful;
    private String transactionId;

    @Override
    public void pay(double amount) {
        // Simulate payment processing logic
        System.out.println("Processing payment of $" + amount);
        this.paymentSuccessful = true; // Assume payment is successful for demonstration
        this.transactionId = "TXN123456"; // Simulated transaction ID
    }

    @Override
    public boolean isPaymentSuccessful() {
        return this.paymentSuccessful;
    }

    @Override
    public String getTransactionId() {
        return this.transactionId;
    }
}

class CheckoutService {
    private PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        paymentProcessor.pay(amount);
        if (paymentProcessor.isPaymentSuccessful()) {
            System.out.println("Payment Successful. Transaction ID: " + paymentProcessor.getTransactionId());
        } else {
            System.out.println("Payment Failed.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new InHousePaymentProcessor();
        CheckoutService checkoutService = new CheckoutService(paymentProcessor);
        checkoutService.checkout(100.0);

        RazorpaySDK razorpaySDK = new RazorpaySDK();
        PaymentProcessor razorpayAdapter = new RazorpayAdapter(razorpaySDK);

        CheckoutService checkoutServiceWithAdapter = new CheckoutService(razorpayAdapter);
        checkoutServiceWithAdapter.checkout(200.0);
    }
}
