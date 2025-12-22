package CreationalDesign;


class SingletonExample{
    private static SingletonExample instance;

    private SingletonExample(){
        //private constructor to prevent instantiation
        System.out.println("Singleton Instance Created");
    }

    public static synchronized SingletonExample getInstance(){
        if(instance==null){
            instance=new SingletonExample();
        }
        return instance;
    }
}
public class Singleton {
    public static void main(String[] args) {
        System.out.println("Singleton Design Pattern");

        SingletonExample s1=SingletonExample.getInstance();
        SingletonExample s2=SingletonExample.getInstance();
        System.out.println("s1 hashcode: "+s1.hashCode());
        System.out.println("s2 hashcode: "+s2.hashCode());
        if(s1==s2){ 
            System.out.println("Both instances are same. Singleton works!");
        }
    }
}
