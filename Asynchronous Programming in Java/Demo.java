import java.util.concurrent.CompletableFuture;

public class Demo {
    public static CompletableFuture<Integer> compute(int n){
        return new CompletableFuture<Integer>().supplyAsync(() -> n * 2);
    }
    public static void main(String[] args) {
        compute(2)
        .thenAccept(System.out::println);
    }
}
