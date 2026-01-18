package BehavioralDesign;

//In this example, we implement the Observer Design Pattern, which defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

//We have a Subject interface that declares methods for attaching, detaching, and notifying observers.

//The Observer1 interface declares the update method that observers must implement to receive updates from the subject.

//This is the example of push model, where the subject pushes updates to the observers whenever there is a change in its state.

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void attach(Observer1 observer);
    void detach(Observer1 observer);
    void notifyObservers();
}

interface Observer1 {
    void update(String message);
}

class NotificationServiceSubject implements Subject {
    private List<Observer1> observers;
    private String message;

    public NotificationServiceSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer1 observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer1 observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer1 observer : observers) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

class EmailObserver implements Observer1 {
    @Override
    public void update(String message) {
        System.out.println("Email Observer received message: " + message);
    }
}

class SMSObserver implements Observer1 {
    @Override
    public void update(String message) {
        System.out.println("SMS Observer received message: " + message);
    }
}

public class Observer {
    public static void main(String[] args) {
        NotificationServiceSubject subject = new NotificationServiceSubject();

        Observer1 emailObserver = new EmailObserver();
        Observer1 smsObserver = new SMSObserver();

        subject.attach(emailObserver);
        subject.attach(smsObserver);

        subject.setMessage("Order placed successfully!");
    }
}
