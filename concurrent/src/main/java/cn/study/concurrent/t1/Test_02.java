package cn.study.concurrent.t1;

/**
 * synchronized关键字
 *
 * 同步 static
 */
public class Test_02 {

    private static int staticCount = 0;

    public synchronized static void testSync04(){
        System.out.println(Thread.currentThread().getName() + " staticCount = " + staticCount++);
    }

    private static void testSync05(){
        synchronized (Test_02.class){
            System.out.println(Thread.currentThread().getName() + " staticCount = " + staticCount++);
        }
    }
}
