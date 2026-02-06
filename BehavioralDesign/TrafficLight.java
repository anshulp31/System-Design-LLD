package BehavioralDesign;

//In this example, we implement the State Design Pattern, which allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

//We have a TrafficLightState interface that defines the methods for displaying the current state, transitioning to the next state, and getting the duration of the current state.

//We then create concrete state classes for each traffic light state: RedState, GreenState, and YellowState. Each state class implements the TrafficLightState interface and defines its own behavior for displaying the light, transitioning to the next state, and returning the duration of that state.

interface TrafficLightState{
    public void display();
    public TrafficLightState nextState();
    public int getDuration();
} 

class RedState implements TrafficLightState{
    @Override
    public void display(){
        System.out.println("Red light ON");
    }

    @Override
    public TrafficLightState nextState(){
        return new GreenState();
    }

    @Override

    public int getDuration(){
        return 60;
    }
}

class GreenState implements TrafficLightState{
    @Override
    public void display(){
        System.out.println("Green light ON");
    }

    @Override
    public TrafficLightState nextState(){
        return new YellowState();
    }

    @Override

    public int getDuration(){
        return 45;
    }
}


class YellowState implements TrafficLightState{
    @Override
    public void display(){
        System.out.println("Yellow light ON");
    }

    @Override
    public TrafficLightState nextState(){
        return new RedState();
    }

    @Override

    public int getDuration(){
        return 5;
    }
}

class TrafficLightController{
     private TrafficLightState currentState;

     public TrafficLightController(){
        currentState=new RedState();
     }

     public void start() throws InterruptedException{
        while (true) {
            currentState.display();

            Thread.sleep(currentState.getDuration()*1000);

            currentState=currentState.nextState();
        }
     }
}

public class TrafficLight {
    public static void main(String[] args) {
        TrafficLightController trafficLight= new TrafficLightController();

        try {
             trafficLight.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
