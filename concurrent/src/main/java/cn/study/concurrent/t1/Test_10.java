package cn.study.concurrent.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile关键字
 * volatile非原子性问题
 * volatile，只能保证可见性，不能保证原子性
 *
 * 不是加锁问题，只是内存数据可见
 */
public class Test_10 {

    volatile int count = 0;
    /*synchronized*/ void m(){
        for (int i = 0; i < 10000; i++){
            count++;
        }
    }

    public static void main(String[] args) {
        final Test_10 t = new Test_10();
        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            list.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    t.m();
                }
            }));
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(t.count);
    }
}
