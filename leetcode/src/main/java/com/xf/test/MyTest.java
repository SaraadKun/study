package com.xf.test;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: MyTest
 * @Package:com.xf.test
 * @Description:
 * @author: saraad
 * @date: 2019/2/21 22:02
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class MyTest {

    public static void main(String [] args){
        final Ticket ticket = new Ticket();
        ticket.setCount(0);
        ticket.setTicketNum(100);
        Thread t1 = new Thread(() -> {
            while (ticket.getTicketNum()>0) {
                synchronized (ticket) {
                    int num = ticket.getTicketNum();
                    int count = ticket.getCount();
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread() + "正在卖出第" + ++count + "张票，还剩余" + --num + "张");
                        ticket.setCount(count);
                        ticket.setTicketNum(num);
                        ticket.notify();
                    }else {
                        try {
                            ticket.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"线下窗口");
        Thread t2 = new Thread(() -> {
            while (ticket.getTicketNum()>0) {
                synchronized (ticket) {
                    int num = ticket.getTicketNum();
                    int count = ticket.getCount();
                    if (num % 2 == 1) {
                        System.out.println(Thread.currentThread() + "正在卖出第" + ++count + "张票，还剩余" + --num + "张");
                        ticket.setCount(count);
                        ticket.setTicketNum(num);
                        ticket.notify();
                    }else {
                        try {
                            ticket.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        },"线上窗口");
        t1.start();
        t2.start();

    }

}
