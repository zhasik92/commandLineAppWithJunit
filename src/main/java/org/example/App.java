package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread thread = new Thread("start");
        thread.run();
        //executorService.execute();
        System.out.println( "Hello World!" );
        Thread.yield();
    }
}
