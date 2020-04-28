package com.xf.test;

public class test03 {

    public static void main(String[] args) {

        Ticket tick = new Ticket();

        tick.setTicketNum(100);
        tick.setCount(0);

        NetWindow nw = new NetWindow(tick);
        PhysicalStore ps = new PhysicalStore(tick);

        Thread t1 = new Thread(nw,"线下窗口");
        Thread t2 = new Thread(ps,"线上窗口");

        while (tick.getTicketNum()>0){
            t1.start();
            t2.start();
        }
    }
}
