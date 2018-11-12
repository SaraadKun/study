package cn.freemud.demo.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
        client.start();

//        client.create().forPath("/ashun");
        final int count = 0;

        final InterProcessMutex lock = new InterProcessMutex(client, "/ashun/LOCK");



        final CountDownLatch began = new CountDownLatch(1);
        //region 启动线程
        new Thread(new Runnable() {
            private int flag = 1;
            public void run() {
                try {
                    began.await();
                    if ( lock.acquire(3, TimeUnit.SECONDS) )
                    {
                        try
                        {
                            // do some work inside of the critical section here
                            System.out.println("Thread :"+Thread.currentThread()+" running...."+flag);

                        }
                        finally
                        {
                            lock.release();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //endregion

        //region 启动线程
        new Thread(new Runnable() {
            public void run() {
                try {
                    began.await();
                    if ( lock.acquire(3, TimeUnit.SECONDS) )
                    {
                        try
                        {
                            // do some work inside of the critical section here
                            System.out.println("Thread :"+Thread.currentThread()+" running....");
                        }
                        finally
                        {
                            lock.release();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //endregion

        //region 启动线程
        new Thread(new Runnable() {
            public void run() {
                try {
                    began.await();
                    if ( lock.acquire(3, TimeUnit.SECONDS) )
                    {
                        try
                        {
                            // do some work inside of the critical section here
                            System.out.println("Thread :"+Thread.currentThread()+" running....");
                        }
                        finally
                        {
                            lock.release();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //endregion

        //region 启动线程
        new Thread(new Runnable() {
            public void run() {
                try {
                    began.await();
                    if ( lock.acquire(3, TimeUnit.SECONDS) )
                    {
                        try
                        {
                            // do some work inside of the critical section here
                            System.out.println("Thread :"+Thread.currentThread()+" running....");
                        }
                        finally
                        {
                            lock.release();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //endregion

        //region 启动线程
        new Thread(new Runnable() {
            public void run() {
                try {
                    began.await();
                    if ( lock.acquire(3, TimeUnit.SECONDS) )
                    {
                        try
                        {
                            // do some work inside of the critical section here
                            System.out.println("Thread :"+Thread.currentThread()+" running....");
                        }
                        finally
                        {
                            lock.release();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //endregion

        //region 启动线程
        new Thread(new Runnable() {
            public void run() {
                try {
                    began.await();
                    if ( lock.acquire(3, TimeUnit.SECONDS) )
                    {
                        try
                        {
                            // do some work inside of the critical section here
                            System.out.println("Thread :"+Thread.currentThread()+" running....");
                        }
                        finally
                        {
                            lock.release();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //endregion

        began.countDown();

//        client.close();



    }

    public class Runner implements Runnable{
        public void run() {

        }
    }
}
