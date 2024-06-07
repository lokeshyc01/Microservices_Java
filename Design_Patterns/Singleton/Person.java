public class Person{
    
    private Person(){};
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
}