package com.thread.practice;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: Priority
 * @Package:com.thread.practice
 * @Description:
 * @author: saraad
 * @date: 2019/3/25 22:24
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class Priority {

    private static volatile boolean notStat = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws Exception{
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread: " + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStat = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;

        for (Job job : jobs) {
            System.out.println("Job Priority : " + job.priority + ",Count : " + job.jobCount);
        }
    }

    static class Job implements Runnable{

        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        public void run(){
            while (notStat){
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }


}
