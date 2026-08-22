package StructuralDesign.BridgePattern;

//Bridge Pattern is a structural design pattern that decouples an abstraction from its implementation so that the two can vary independently. It is used to separate the abstraction (interface) from its implementation, allowing them to evolve independently without affecting each other.

//Implementor Device defines the interface for implementation classes. ConcreteImplementor classes implement the Device interface and provide specific implementations for the methods defined in the interface. The Abstraction RemoteControl defines the interface for the abstraction and maintains a reference to an object of type Device. RefinedAbstraction AdvancedRemoteControl extends the functionality of the RemoteControl class and provides additional features.
interface Device{
    void setPower(boolean on);
    void setVolume(int volume);
    int volume();
    boolean isOn();
    String name();
}

class Television implements Device{
    private boolean on=false;
    private int volume=0;

    public void setPower(boolean on){
        this.on = on;
        System.out.println("Television Power is set: " + this.on);
    }
    public void setVolume(int volume){
        this.volume = volume;
        System.out.println("Television Volume is set: " + this.volume);
    }
    public int volume(){
        return this.volume;
    }
    public boolean isOn(){
        return this.on;
    }
    public String name(){
        return "Television";
    }
}

class Radio implements Device{
    private boolean on=false;
    private int volume=0;

    public void setPower(boolean on){
        this.on = on;
        System.out.println("Radio Power is set: " + this.on);
    }
    public void setVolume(int volume){
        this.volume = volume;
        System.out.println("Radio Volume is set: " + this.volume);
    }
    public int volume(){
        return this.volume;
    }
    public boolean isOn(){
        return this.on;
    }
    public String name(){
        return "Radio";
    }
}

class RemoteControl{
    //The RemoteControl class acts as an abstraction that maintains a reference to a Device object. It provides methods to control the device, such as toggling power and adjusting volume. The AdvancedRemoteControl class extends the functionality of the RemoteControl class by adding a mute feature.
    protected Device device;
    public RemoteControl(Device device){
        this.device=device;
    }
    public void togglePower(){
        device.setPower(!device.isOn());
    }
    public void volumeUp(){
        device.setVolume(device.volume()+1);
    }
    public void volumeDown(){
        device.setVolume(device.volume()-1);
    }
}


//The AdvancedRemoteControl class extends the RemoteControl class and adds a mute feature. It inherits the methods from the RemoteControl class and provides an additional method to mute the device.
class AdvancedRemoteControl extends RemoteControl{
    public AdvancedRemoteControl(Device device){
        super(device);
    }
    public void mute(){
        System.out.println("Mute the device");
    }
}

public class Main {
    public static void main(String[] args) {
        Device tv= new Television();
        RemoteControl remoteControl=new RemoteControl(tv);
        remoteControl.togglePower();
        remoteControl.volumeUp();

        Device radio= new Radio();
        AdvancedRemoteControl advancedRemoteControl=new AdvancedRemoteControl(radio);
        advancedRemoteControl.togglePower();
        advancedRemoteControl.volumeUp();
        advancedRemoteControl.mute();
    }
}
