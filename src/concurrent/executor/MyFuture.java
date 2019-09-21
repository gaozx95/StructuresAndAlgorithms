package concurrent.executor;

import java.util.concurrent.*;

public class MyFuture {
    public static void main(String[] args)throws InterruptedException, ExecutionException {
        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });
        new Thread(task).start();           //Thread里面不能直接扔callable，必须用task，而且要用FutureTask.get()阻塞等结果

        System.out.println(task.get());     //阻塞

        //************************第二种*****************

        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(()->{            //submit里面可以直接扔callable，有返回值
            TimeUnit.MILLISECONDS.sleep(500);
            return 1 ;
        });

        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());

    }
}
