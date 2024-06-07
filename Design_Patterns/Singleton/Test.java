public class Test {
    public static void main(String[] args) {
        Person person = Person.getPerson();
        Person newPerson = Person.getPerson();

        System.out.println(person.hashCode()+"  "+newPerson.hashCode());
    }
}
