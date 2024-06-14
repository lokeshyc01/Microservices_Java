// COMBINE

import java.util.concurrent.CompletableFuture;


public class Sample4{
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
        var cf1 = create(2);
        var cf2 = create(4);

        cf1.thenCombine(cf2, (data1,data2)-> data1+data2)
        .thenAccept(System.out::println);
    }
} 
    
// OK go to the next then
// exception go the next exceptionally
