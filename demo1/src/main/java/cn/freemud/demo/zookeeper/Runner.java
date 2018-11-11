package cn.freemud.demo.zookeeper;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenwenshun on 2017/7/9.
 */
public class Runner implements Runnable {

    private InterProcessMutex lock;
    private CountDownLatch began;
    private Q q;

    public Runner(InterProcessMutex lock, CountDownLatch began, Q q) {
        this.lock = lock;
        this.began = began;
        this.q = q;
    }

    public void run() {
        try {
            began.await();
            boolean getLock = false;
                try
                {
                    getLock = lock.acquire(11, TimeUnit.SECONDS);
                    if (getLock){

                        // do some work inside of the critical section here
                        TimeUnit.SECONDS.sleep(1);
                        q.setN(q.getN()+1);
                        System.out.println("Thread :"+Thread.currentThread()+" running.... >>>"+q.getN());
                    }else{
                        System.out.println("Thread :"+Thread.currentThread()+" You do not own the lock.... >>>");
                    }

                }
                finally
                {
//                    if (getLock)
                       lock.release();
                }

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
