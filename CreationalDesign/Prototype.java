package CreationalDesign;

//A prototype design pattern is a creational design pattern that allows cloning objects, even complex ones, without coupling to their specific classes.
//In this example, we have a class Person that implements the Cloneable interface and overrides the clone() method.

//The clone() method creates and returns a copy of the current object.

//In the main method, we create an original Person object and then clone it using the clone() method.

//It helps to create a new object by copying an existing object, which can be more efficient than creating a new object from scratch, especially when the object is complex or resource-intensive to create.

class Person implements Cloneable{
    private String name;
    public int age;

    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class Prototype {
    public static void main(String[] args) {
        Person originalPerson=new Person("John",30);
        try{
            Person clonedPerson=(Person)originalPerson.clone();
            originalPerson.age=25; //modifying age of cloned person
            System.out.println("Original Person: "+originalPerson.getName()+", Age: "+originalPerson.age);
            System.out.println("Cloned Person: "+clonedPerson.getName()+", Age: "+clonedPerson.age);   
            if(originalPerson != clonedPerson){
                System.out.println("Objects are different instances.");
            }
        }catch(CloneNotSupportedException e){
            e.printStackTrace();    
        }
    }
}
