package cn.study.concurrent.t1;

/**
 * synchronized关键字
 *
 * 同步 static
 *
 * 静态同步方法，锁的是当前类型的类对象，在本类中，就是Test_02.class对象
 */
public class Test_02 {

    private static int staticCount = 0;

    public static synchronized void testSync04(){
        System.out.println(Thread.currentThread().getName() + " staticCount = " + staticCount++);
    }

    private static void testSync05(){
        synchronized (Test_02.class){
            System.out.println(Thread.currentThread().getName() + " staticCount = " + staticCount++);
        }
    }
}
