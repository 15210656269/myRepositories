package cn.study.concurrent.t1;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字
 * volatile可见性
 * 通知OS操作系统后，在CPU计算过程中，都要检查内存中数据的有效性。保证最新的内存数据被使用。
 *
 */
public class Test_09 {
    volatile boolean b = true;
    void m(){
        System.out.println("start");
        while (b){}
        System.out.println("end");
    }

    public static void main(String[] args) {
        final Test_09 t = new Test_09();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.b = false;
    }
}
