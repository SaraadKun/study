package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: SleepUtils
 * @Package:com.thread
 * @Description:
 * @author: saraad
 * @date: 2019/3/26 0:26
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class SleepUtils {

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
