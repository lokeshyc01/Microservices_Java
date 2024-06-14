import java.util.concurrent.CompletableFuture;


public class Sample3{
    public static int compute(int n)
    {
        if(n <= 0){
            throw new RuntimeException("invalid value");
        }
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n){
        return CompletableFuture.supplyAsync(()->compute(n));
    }
    public static void main(String[] args) {
        create(-4)
        .thenApply(data -> data + 1)
        .exceptionally(err -> {
            System.out.println(err.getMessage());
            // return 100;
            throw new RuntimeException("this is beyond repair");
        })
        .thenAccept(System.out::println)
        .exceptionally(err -> {
            System.out.println(err.getMessage());
            throw new RuntimeException("coudl not handle");
        });
    }
} 
    
// OK go to the next then
// exception go the next exceptionally
