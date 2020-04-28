import com.alibaba.fastjson.JSON;
import com.google.common.primitives.Ints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: MyTest
 * @Package:PACKAGE_NAME
 * @Description:
 * @author: bin.peng
 * @date: 2018/11/715:46
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RunWith(JUnit4.class)
public class MyTest {

    @Test
    public void testnull(){
        ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("");
        list.add(null);
        String s = JSON.toJSONString(list);
        System.out.println(s);
    }


    @Test
    public void testbuilder(){
        StringBuilder builder = new StringBuilder("");
        builder.append("1234567");
        String s = builder.deleteCharAt(builder.length()-1).toString();
        System.out.println(s);

    }
    @Test
    public void testThread(){

        try {
            newCachedThreadPool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testStrLength() throws Exception{
        String init = "abcabcdabcd";
        int[] ints = kmpnext(init);
        List<Integer> list = Ints.asList(ints);
        System.out.println(list);
    }

    //求字符串重复
    public static int[] kmpnext(String dest) {
        int[] next = new int[dest.length()];
        //最终输出结果 每个索引处的值代表字符串中当前位置的字符的重复长度
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //若发现*j 与 *i两指针对应位置的值不相等,则将*j往前移一位比较(这里我觉得写得有问题,应该直接给j归零,依次递减没必要)
            //比如 输入 "abcabb" 输出为[000120] 而这里我觉得应该输出[000121]才对
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            //与初始的最大不重复的字符串进行对比
            // 例如 输入 "abcabc"时 假设有两个指针,*i指向i处,*j指向j处
            //当i=3,此时j=0,dest.charAt(3) == dest.charAt(0),两个指针处的值开始相等
            // 代表索引i=3时有字符开始跟初始最大不重复字符串产生重复,将指针*j向后移动一位,指针*i移动一位,继续对比
            //若两指针处的值仍然相等,代表重复的字符串长度+1 依次类推,j的值就代表当然位置的重复长度
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void newCachedThreadPool() throws InterruptedException {
        ExecutorService m = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int count = i;
            m.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程"+Thread.currentThread()+"负责了"+count+"次任务");
                }
            });
//                    Thread.sleep(10l);


        }
    }


}
