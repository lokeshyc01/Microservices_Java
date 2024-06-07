import java.io.Serializable;

public class Person implements Serializable,Cloneable {
    // solution for reflection api
    // private Person(){
    //  if(person != null){
    //     throw new RuntimeException("trying to break singlton patttern using reflection api");
    //  }   
    // }

    private Person(){
      
    }
    private static Person person;
    public static Person getPerson(){

        if(person == null){
            person = new Person();
        }
        return person;
    }

    // multithreaded environment
    public static Person generatePerson(){

        if(person == null)
        {
            synchronized(Person.class){
                person = new Person();
            }
        }
        return person;
    }

    public Object clone() throws CloneNotSupportedException{
        return person;
    }

    public Object readResolve(){
        return person;
    } 
}