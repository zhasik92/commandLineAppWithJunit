package playgroung.tutorial.futures;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(new Random().nextInt(5000));
                return "work is done";
            }
        });
        new Thread(task).start();
        System.out.println("waiting for result");
        String s = task.get();
        System.out.println(s);
    }
}
