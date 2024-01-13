package preparation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Design
{

    public static void main(String[] args) throws InterruptedException
    {
        SimpleThrottling t1 = new SimpleThrottling(2);
        /*for(int i=0;i<1000000;i++) {
            t1.throttle();
        }*/

        /*ThrottlewithWait t2 = new ThrottlewithWait();
        for(int i=0;i<10000;i++)
        {
            t2.throttle();
        }*/

        ThrottlewithSemaphore t2 = new ThrottlewithSemaphore(5);
        for(int i=0;i<1000000;i++)
        {
            t2.throttle();
        }
    }
}

class SimpleThrottling
{

    private long intervalInMillis;
    private long lastExecutionTime;

    public SimpleThrottling(int maxRequests) {
        this.intervalInMillis = 2000;
        this.lastExecutionTime = 0l;
    }

    public void throttle() throws InterruptedException
    {
        List<String> list = new ArrayList<>();
        list.stream().filter(x->x.equals("abc")).toArray();
        long currentTime = System.currentTimeMillis();
        System.out.print(currentTime + " " + lastExecutionTime + " ");
        long elaspedTime = currentTime - lastExecutionTime;
        System.out.print(elaspedTime + " ");
        if(elaspedTime < intervalInMillis) {
            long remainingTimeToWait = intervalInMillis - elaspedTime;
            System.out.print(new Date().getTime() + " Throttled and sleeping for " + remainingTimeToWait + "...try again!");
        } else {
            System.out.print(new Date().getTime() + " Executed!");
            Thread.sleep(800);
            lastExecutionTime = System.currentTimeMillis();
            Thread.sleep(800);
        }

        System.out.println();
    }
}

class ThrottlewithWait {

    private int coolOffMilliSeconds = 1000;
    private long lastExecutionTime = 0;
    Object lock = new Object();

    public void throttle() throws InterruptedException
    {
        synchronized (lock) {
            long currentTime = System.currentTimeMillis();
            long elasped = currentTime - lastExecutionTime;

            if(elasped < coolOffMilliSeconds) {
                System.out.println(new Date().getTime() + " Locking for " + (coolOffMilliSeconds-elasped));
                lock.wait(coolOffMilliSeconds-elasped);
            }
            System.out.println(new Date().getTime() + " Executed");
            Thread.sleep(100);
            lastExecutionTime = System.currentTimeMillis();
            Thread.sleep(100);
        }

    }
}

class ThrottlewithSemaphore {

    private Semaphore semaphore;

    public ThrottlewithSemaphore(int maxAttempts) {
        semaphore = new Semaphore(maxAttempts);
    }

    public void throttle() throws InterruptedException
    {
        if(semaphore.tryAcquire())
        {
            System.out.println(new Date().getTime() + " Executed");
        } else {

                System.out.println(new Date().getTime() + " Locked");
        }

    }
}
