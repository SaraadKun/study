package com.thread.practice;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * All rights Reserved, Designed By SARAAD
 *
 * @version V1.0
 * @Title: Piped
 * @Package:com.thread.practice
 * @Description: pipe inputStream & outputStream
 * @author: saraad
 * @date: 2019/3/28 22:10
 * @Copyright: 2019  Inc. All rights reserved.
 * PROJECT FOR PRACTICE
 */
public class Piped {

    public static void main(String[] args) throws Exception{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输出流和输入流进行链接  or not throw IOException: Pipe not connected
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
        new ConcurrentHashMap<>();
    }

    static class Print implements Runnable{
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while (((receive = in.read()) != -1)){
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
