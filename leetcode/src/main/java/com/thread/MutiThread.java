package com.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: MutiThread
 * @Package:com.thread
 * @Description:
 * @author: saraad
 * @date: 2019/3/21 22:54
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class MutiThread {

    public static void main(String[] args){
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId()+"] " + threadInfo.getThreadName() + " : "
                    + threadInfo.getThreadState() + " | " + threadInfo.getStackTrace());
        }

    }


}
