//Bad Example of Dependency Inversion Principle
// High-level module (NotificationService) depends on low-level module (EmailService)
//Here the problem is that NotificationService is tightly coupled with EmailService. if need to change the way of notification (like SMS), we have to modify NotificationService class.

class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

class NotificationServiice{
    EmailService emailService=new EmailService();

    public void notifyUser(String message){
        emailService.sendEmail(message);
    }
}

public class DependencyInversion {
    public static void main(String[] args) {
        NotificationServiice notificationServiice=new NotificationServiice();
        notificationServiice.notifyUser("Hello User!");
    }
}
