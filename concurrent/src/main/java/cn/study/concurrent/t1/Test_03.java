package cn.study.concurrent.t1;

/**
 * synchronized关键字
 *
 * 同步方法，原子性
 *
 * 加锁的目的，就是为了确保操作的原子性
 */
public class Test_03 implements Runnable {

    private int count = 0;

    @Override
    public /*synchronized*/ void run() {
        System.out.println(Thread.currentThread().getName() + " count = " + count++);
    }

    public static void main(String[] args) {
        Test_03 t3 = new Test_03();
        for (int i = 0; i < 5; i++){
            new Thread(t3, "Thread - " + i).start();
        }
    }
}
