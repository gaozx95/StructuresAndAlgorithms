package concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args)throws InterruptedException {
        ExecutorService serv = Executors.newFixedThreadPool(5); //执行任务有excutor  submit两种方法
        for (int i = 0;i<6;i++){
            serv.execute(()->{
                try{
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(serv);
        serv.shutdown();
        System.out.println(serv.isTerminated());
        System.out.println(serv.isShutdown());
        System.out.println(serv);

        TimeUnit.SECONDS.sleep(5);
        System.out.println(serv.isTerminated());
        System.out.println(serv.isShutdown());
        System.out.println(serv);

    }
}
