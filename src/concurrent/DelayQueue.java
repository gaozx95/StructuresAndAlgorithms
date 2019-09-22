package concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueue<M> {
    static BlockingQueue<Mytask> tasks = (BlockingQueue<Mytask>) new DelayQueue<Mytask>();

    static Random r = new Random();

    static class Mytask implements Delayed {
        long runningTime;

        Mytask(long rt){
            this.runningTime = rt;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime -System.currentTimeMillis(),TimeUnit.MILLISECONDS );
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS)<o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            if(this.getDelay(TimeUnit.MILLISECONDS)>o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return " runningTime="+runningTime;
        }
    }

    public static void main(String[] args)throws InterruptedException{
        long now = System.currentTimeMillis();
        Mytask t1 = new Mytask(now+1000);
        Mytask t2 = new Mytask(now+2000);
        Mytask t3 = new Mytask(now+1500);
        Mytask t4 = new Mytask(now+2500);
        Mytask t5 = new Mytask(now+500);

        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);

        System.out.println(tasks);

        for (int i =0;i<5;i++){
            System.out.println(tasks.take());
        }
    }
}