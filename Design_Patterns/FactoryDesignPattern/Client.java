import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Developer dev1 = FactoryClass.getDeveloper("web");
        System.out.println(dev1.getSalary());

        Developer dev2 = FactoryClass.getDeveloper("android");
        System.out.println(dev2.getSalary());

        sc.close();
    }
}
