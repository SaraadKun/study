package com.thread.lock;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TwinsLock
 * @Package:com.thread.lock
 * @Description:
 * @author: bin.peng
 * @date: 2019/4/10 15:05
 * @Copyright: 2019 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer {

        Sync(int count) {
            if (count < 0)
                throw new IllegalArgumentException("count must largerthan 0");
            setState(count);//设置共享变量state
        }

        //获取同步状态
        public int tryAcquireShared(int reduceCount){
            for(;;){
                int current = getState();
                int newCount = current - reduceCount;
                //count < 0 代表非法状态,返回负值(count),获取同步状态失败
                //count >= 0 状态合法,CAS设置state值获取同步状态成功,则返回
                if(newCount < 0 || compareAndSetState(current ,newCount)){
                    return newCount;
                }
            }
        }

        //释放同步状态
        public boolean tryReleaseShared(int returnCount){
            for(;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current ,newCount)){
                    return true;
                }
            }
        }

    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
