package cn.freemud.demo.zookeeper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenwenshun on 2017/7/9.
 */
public class Runner2 implements Runnable {

    private CountDownLatch began;
    private Q q;

    public Runner2(CountDownLatch began, Q q) {
        this.began = began;
        this.q = q;
    }

    public void run() {
        try {
            began.await();

            TimeUnit.SECONDS.sleep(3);
            q.setN(q.getN()+1);
            System.out.println("Thread :"+Thread.currentThread()+" running.... >>>"+q.getN());

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
