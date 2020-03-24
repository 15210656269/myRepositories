package cn.study.concurrent.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 自定义容器，提供新增元素（add）和获取元素数量（size）方法。
 */
public class Test_01 {
    public static void main(String[] args) {
        final Test_Collection t = new Test_Collection();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    t.add(new Object());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (t.size() == 5){
                        System.out.println("size == 5");
                        break;
                    }
                }
            }
        }).start();
    }
}

class Test_Collection {
    volatile List<Object> list = new ArrayList<>();

    public boolean add(Object o) {
        return list.add(o);
    }

    public int size() {
        return this.list.size();
    }
}
