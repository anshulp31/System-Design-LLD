package CreationalDesign;

interface INotificationService{
    void notifyUser(String message);
}

class EmailNotification implements INotificationService{
    @Override
    public void notifyUser(String message){
        System.out.println("Email Notification sent with message: "+message);
    }
}

class SMSNotification implements INotificationService{
    @Override
    public void notifyUser(String message){
        System.out.println("SMS Notification sent with message: "+message);
    }
}

class PushNotification implements INotificationService{
    @Override
    public void notifyUser(String message){
        System.out.println("Push Notification sent with message: "+message);
    }
}

class NotificationFactory{
    public static INotificationService getNotificationService(String type){
        if(type.equalsIgnoreCase("EMAIL")){
            return new EmailNotification();
        }else if(type.equalsIgnoreCase("SMS")){
            return new SMSNotification();
        }else if(type.equalsIgnoreCase("PUSH")){
            return new PushNotification();
        }
        return null;
    }
}

class NotificationService{
    private INotificationService notificationService;

    public NotificationService(String type){
        notificationService=NotificationFactory.getNotificationService(type);
    }

    public void sendNotification(String message){
        notificationService.notifyUser(message);
    }
}
public class Factory {
    public static void main(String[] args) {
        NotificationService emailService=new NotificationService("EMAIL");
        emailService.sendNotification("Hello via Email!");
        NotificationService smsService=new NotificationService("SMS");
        smsService.sendNotification("Hello via SMS!");
    }
}
