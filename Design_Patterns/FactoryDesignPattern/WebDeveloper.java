public class WebDeveloper implements Developer{

    @Override
    public int getSalary() {
        System.out.println("getting webdeveloper salary");
        return 40000;
    }

}