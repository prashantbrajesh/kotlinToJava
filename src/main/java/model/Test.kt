package model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.future.await
import java.util.concurrent.CompletableFuture

suspend fun main(){
    val combineImagesAsync = combineImagesAsync(1, 2)
    print(combineImagesAsync)
}

suspend fun combineImagesAsync(name1: Int, name2: Int): Int = coroutineScope{
    val future1 = BookingTest.loadImageAsync(name1) // start loading first image
    val future2 = BookingTest.loadImageAsync(name2) // start loading second image
    future1.await()+future2.await() // wait for both, combine, and return result
}