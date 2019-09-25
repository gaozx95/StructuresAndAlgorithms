package concurrent.container;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class MyContainer<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t){
        while (lists.size() == MAX){        //为什么是while而不是if：因为wait大多数是和while一起用
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();
    }
    public synchronized T get(){
        T t =null;
        while (lists.size() == 0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer<String> c = new MyContainer<>();
        for(int i=0;i<10;i++){
            new Thread(()->{
                for (int j =0;j<5;j++)
                    System.out.println(Thread.currentThread().getName()+"消费"+c.get());
            },"c"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i =0;i<2;i++){
            new Thread(()->{
                for (int j = 0;j<25;j++) {
                    c.put(Thread.currentThread().getName() + "生产的内容 " + j);
                    System.out.println(Thread.currentThread().getName()+"生产"+j);
                }
            },"p"+i).start();
        }
    }
}
