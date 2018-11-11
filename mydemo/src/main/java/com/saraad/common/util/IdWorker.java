package com.saraad.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @version V1.0
 * @Title: SnowFlake生成算法
 * @Package PACKAGE_NAME
 * @Description: ${使用SnowFlake算法生成ID}
 * @author:
 * @date:
 * @Copyright:
 */

public class IdWorker {

    private static long starttimestamp;//开始时间戳

    private static int timestampshift;//时间戳二进制偏移量

    private static long machineno; //49-56位，记录机器的编号
    private static int machinenoshift;//机器编号二进制偏移量

    private static int maxsequence;//最大序号
    private static AtomicInteger sequence; //序号计数器

    /**
     *  初始化ID生成算法
     *  @param machineid 机器的编号，最大值允许为255
     *  @author Administrator
     *  @Time2017-6-8 15:02:29
     */
    public static synchronized void init(int machineid) {
        //初始化起始时间戳
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 1, 1);  //年月日  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52);
        starttimestamp = calendar.getTimeInMillis();//time就是你需要的时间

        //设置时间戳二进制左偏移量,5-44位
        timestampshift = 64-44;

        //设置机器编号二进制左偏移量，49-56位
        machinenoshift = 64-56;
        machineno = machineid << machinenoshift;

        //设置顺序号为6位，59-64位
        maxsequence = 64;

        //初始化计数器
        sequence = new AtomicInteger(0);
    }

    /**
     *  获取指定时间的ID边界
     *  @return 指定时间的ID边界
     *  @author Administrator
     *  @Time2017-6-8 15:02:29
     */
    public static long getDatetimeId(Date time){
        //转换指定时间戳
        long timestamp = time.getTime() - starttimestamp;

        //移位时间戳偏移量
        timestamp = timestamp << timestampshift;

        //拼接ID
        long result = timestamp + machineno;

        return result;
    }

    /**
     *  获取指定时间的ID边界
     *  @return 指定时间的ID边界
     *  @author Administrator
     *  @Time2017-6-8 15:02:29
     */
    public static Date getDatetime(Long id){
        //移位时间戳偏移量
        id = id >> timestampshift;

        //转换指定时间戳
        id = id + starttimestamp;

        return new Date(id);
    }

    /**
     *  生成ID
     *  @return 生成的ID
     *  @author Administrator
     *  @Time2017-6-8 15:02:29
     */
    public static long generateId() {
        //未初始化swquence时生成Id会报空指针,若未初始化,默认机器码为100初始化
        if(null == sequence)
            init(100);
        try {
            while (true) {
                //序号+1
                int sec = sequence.incrementAndGet();

                //判断是否达到最大序号，
                if (sec == maxsequence) {
                    //等待下一毫秒，重新计数序号
                    Thread.sleep(1);
                    sequence.set(0);
                    continue;
                }
                else if(sec >maxsequence)
                {
                    //所有没拿到有效序号的线程，等待下一轮发号
                    Thread.sleep(1);
                    continue;
                }
                else {
                    //拿到有效序号的线程，生成ID
                    //获取当前时间戳
                    long timestamp = System.currentTimeMillis() - starttimestamp;

                    //移位时间戳偏移量
                    timestamp = timestamp << timestampshift;

                    //拼接ID
                    long result = timestamp + machineno + sec;

                    return result;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
