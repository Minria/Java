package practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
public class TestCallable {
    public static void main(String[] args) {
        Callable<Integer> callable=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum=0;
                for(int i=0;i<=1000;i++){
                    sum+=i;
                }
                return sum;
            }
        };
        FutureTask<Integer> task = new FutureTask<>(callable);
        Thread t=new Thread(task);
        t.start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
