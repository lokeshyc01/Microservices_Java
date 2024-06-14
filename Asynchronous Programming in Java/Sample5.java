// COMBINE

import java.util.concurrent.CompletableFuture;


public class Sample5{
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
         create(4)
         .thenCompose(data -> create(data))
         .thenAccept(System.out::println);

        //  if chained function return data , use theApply
        // if chained function return CompletableFuture, use thenCompose
    }
} 
    
// OK go to the next then
// exception go the next exceptionally
