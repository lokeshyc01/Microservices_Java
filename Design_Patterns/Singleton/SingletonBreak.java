import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonBreak {

    public static void main(String[] args) throws Exception,CloneNotSupportedException{
        // Break Singleton using Reflection API
        // Solution -> 1) add check in constructor 2) make Person class as enum
        // Person newPerson = Person.getPerson();
        // Constructor<Person> constructor = Person.class.getDeclaredConstructor();
        // constructor.setAccessible(true);
        // Person person = constructor.newInstance();

        // System.out.println(person.hashCode()+"       "+newPerson.hashCode());



        // ================Break Pattern using serialization================================
        // =============Solution Implement the readResolve Method===========================
        // Person person = Person.getPerson();

        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.ob"));
        // oos.writeObject(person);

        // ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.ob"));
        // Person newPerson = (Person)ois.readObject();

        // System.out.println(person.hashCode()+" "+newPerson.hashCode());


// =====================Break pattern using clone method===============================
// ===============Solution return person from clone() method==========================

        Person person = Person.getPerson();
        Person newPerson = (Person)person.clone();

        System.out.println(person.hashCode()+"      "+newPerson.hashCode());
    }
    
}
