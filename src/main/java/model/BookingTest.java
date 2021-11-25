package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BookingTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Future<String> completableFuture =
                calculateAsync();

        String s = completableFuture.get();

        Future<String> completableFuture1 =
                CompletableFuture.completedFuture("Hello");



        String test = completableFuture1.get();

        System.out.println(s);
        System.out.println(test);


        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> "Hello");



        CompletableFuture<String> completableFuture3
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future4 = completableFuture3
                .thenApply(k -> k + " World");



        CompletableFuture<String> completableFuture5
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> futur6 = completableFuture5
                .thenAccept(t -> System.out.println("Computation returned: " + t));

        Void unused = futur6.get();
        System.out.println(unused);

        System.out.println(Thread.currentThread().getName());
        CompletableFuture<String> completableFuture6
                = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return "baba";});

        completableFuture6.thenAccept(k-> System.out.printf(k));

        CompletableFuture<Void> future7 = completableFuture6
                .thenRun(() -> System.out.println("Computation finished."));

//        future7.get();
//        return result;
    }

    public static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

//    public static   CompletableFuture<Integer>  combineImagesAsync(Integer name1,Integer name2) {
//        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()->name1); // start loading first image
//        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()->name2); // start loading first image
//        return future1.await()+ future2.await(); // wait for both, combine, and return result
//    }
//
    public static CompletableFuture<Integer>  loadImageAsync(Integer name2){
        return CompletableFuture.supplyAsync(()->name2);
    }
}


