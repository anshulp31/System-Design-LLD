package SOLID;

//Now our high-level module (NotificationService) depends on an abstraction (IMessageService) rather than a low-level module (EmailService).

// in the below exaple we're foolwing DIP principle by introducing an interface IMessageService that both high-level and low-level modules depend on.


interface IMessageService {
    void sendMessage(String message);
}

class EmailService implements IMessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

class NotificationService {
    private final IMessageService messageService;

    public NotificationService(IMessageService messageService) {
        this.messageService = messageService;
    }

    void notifyUser(String message){
        messageService.sendMessage(message);
    }
}

public class FollowDIP {
    public static void main(String[] args) {
        System.out.println("Follow DIP Principle");
        EmailService emailService = new EmailService();
        NotificationService notificationService=new NotificationService(emailService);
        notificationService.notifyUser("Hello User!");
    }
}
