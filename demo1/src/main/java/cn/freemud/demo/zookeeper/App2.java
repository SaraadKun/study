package cn.freemud.demo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chenwenshun on 2017/7/9.
 */
public class App2 {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        CuratorFramework client = (CuratorFramework)applicationContext.getBean("curatorFramework");
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
//        client.start();

//        client.create().forPath("/ashun");
        try {
            client.getChildren().usingWatcher(new Watcher() {
                public void process(WatchedEvent event) {
                    System.out.println("已经触发了" + event.getType() + "事件！");

                }
            }).forPath("/ashun/LOCK");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        InterProcessMutex lock = new InterProcessMutex(client, "/ashun/LOCK");


        CountDownLatch began = new CountDownLatch(1);
        Q q = new Q(0);
        for (int i = 0; i < 10; i++) {
            InterProcessMutex lock = new InterProcessMutex(client, "/ashun/LOCK");
//            new Thread(new Runner(lock, began, q), "thread_"+i).start();
            new Thread(new Runner2(began, q), "thread_"+i).start();
        }


//        client.setData().forPath("/ashun/LOCK","haha".getBytes());

        began.countDown();

        System.out.println( "Hello World!" );



    }
}
