package CreationalDesign;


//Factory Method Design Pattern defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.

//In this example, we have an interface INotificationService that defines a method sendNotification for sending notifications.

//We have two concrete implementations of this interface: EmailNotificationService and SMSNotificationService.

//We have two factory interfaces: IEmailNotificationFactory and ISMSNotificationFactory, each with a method createNotificationService that returns the corresponding notification service object.

//The NotificationService class takes an INotificationFactory as a parameter in its constructor and uses it to get the desired notification service object.

//This way, we can easily add new notification types by creating new factory classes without modifying the existing code, adhering to the Open/Closed Principle.And also each factory is responsible for creating a single type of object, adhering to the Single Responsibility Principle.

interface INotificationService{
    void sendNotification(String message);
}

interface INotificationFactory{
    INotificationService createNotificationService();
}

interface IEmailNotificationFactory extends INotificationFactory{
    @Override
    INotificationService createNotificationService();
}

interface ISMSNotificationFactory extends INotificationFactory{
    @Override
    INotificationService createNotificationService();
}

class EmailNotificationService implements INotificationService{
    @Override
    public void sendNotification(String message){
        System.out.println("Email Notification sent with message: "+message);
    }
}
class SMSNotificationService implements INotificationService{
    @Override
    public void sendNotification(String message){
        System.out.println("SMS Notification sent with message: "+message);
    }
}

class EmailNotificationFactory implements IEmailNotificationFactory{
    @Override
    public INotificationService createNotificationService(){
        return new EmailNotificationService();
    }
}
class SMSNotificationFactory implements ISMSNotificationFactory{
    @Override
    public INotificationService createNotificationService(){
        return new SMSNotificationService();
    }
}

class NotificationService{
    private INotificationService notificationService;

    public NotificationService(INotificationFactory factory){
        notificationService=factory.createNotificationService();
    }

    public void sendNotification(String message){
        notificationService.sendNotification(message);
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        INotificationFactory emailFactory=new EmailNotificationFactory();
        NotificationService emailService=new NotificationService(emailFactory);
        emailService.sendNotification("Hello via Email!");

        INotificationFactory smsFactory=new SMSNotificationFactory();
        NotificationService smsService=new NotificationService(smsFactory);
        smsService.sendNotification("Hello via SMS!");
    }
}
