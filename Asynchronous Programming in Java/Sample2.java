import java.util.concurrent.CompletableFuture;

public class Sample2{
    public static int compute(int n)
    {
        return n * 2;
    }

    public static CompletableFuture<Integer> create(int n){
        // return CompletableFuture.supplyAsync(()->compute(n));

        var cf = new CompletableFuture<Integer>().thenApply(data -> data * 2);

        cf.thenApply(data -> data + 1);


        return cf;
    }
    public static void main(String[] args) {
        var cf = create(3);

        cf.complete(2);   //passes the data to completablefuture and then it chain of operation are applied on them
    }
}