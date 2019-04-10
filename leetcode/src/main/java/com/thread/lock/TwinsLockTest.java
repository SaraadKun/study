package com.thread.lock;

import com.thread.SleepUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TwinsLockTest
 * @Package:com.thread.lock
 * @Description:
 * @author: bin.peng
 * @date: 2019/4/10 15:45
 * @Copyright: 2019 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TwinsLockTest {

    @Test
    public void testTwinsLock(){
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run(){
                for (;;){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i = 0; i < 10; i++) {
            SleepUtils.second(2);
            System.out.println();
        }
    }

}
