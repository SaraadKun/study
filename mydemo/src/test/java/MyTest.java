import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
    public void testThread(){

        try {
            newCachedThreadPool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


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
