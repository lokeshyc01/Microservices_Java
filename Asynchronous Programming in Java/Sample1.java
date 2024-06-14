import java.util.concurrent.CompletableFuture;

public class Sample1{
    public static int compute(int n)
    {
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n){
        return CompletableFuture.supplyAsync(()->compute(n));
    }
    public static void main(String[] args) {
        create(4)
        .thenApply(data -> data + 1)
        .thenAccept(System.out::println);
    }
}