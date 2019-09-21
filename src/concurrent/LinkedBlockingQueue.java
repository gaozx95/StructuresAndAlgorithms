package concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueue {
    static BlockingQueue<String> strs = new LinkedBlockingDeque<>();        //无界队列
//    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);//如果满了，add加会报错。offer不会报错但是不会加进去
    static Random r =new Random();                                      //put方法满了会阻塞

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0;i<100;i++){
                try {
                    strs.put("a"+i);    //如果满了，就会等待
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"p1").start();
        for (int i =0;i<5;i++){
            new Thread(()->{
                for (;;){
                    try {
                        System.out.println(Thread.currentThread().getName()+"take - "+strs.take());//如果空了就会等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"c"+i).start();
        }
    }
}
