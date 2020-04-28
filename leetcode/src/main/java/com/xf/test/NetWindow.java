package com.xf.test;

public class NetWindow implements Runnable {

    private Ticket ticket;


    @Override
    public void run() {
        while (true) {
            synchronized (ticket) {
                int num = ticket.getTicketNum();
                int count = ticket.getCount();
                if (num % 2 == 0) {
                    System.out.println(Thread.currentThread() + "正在卖出第" + count + "张票，还剩余" + num + "张");
                    ticket.setCount(++count);
                    ticket.setTicketNum(--num);
                    ticket.notify();
                    try {
                        ticket.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public NetWindow() {
    }

    public NetWindow(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
