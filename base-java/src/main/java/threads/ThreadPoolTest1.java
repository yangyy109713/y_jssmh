package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest1 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建一个可重用固定线程数的线程池
        MyThread ta = new MyThread("ta");
        MyThread tb = new MyThread("tb");
        MyThread tc = new MyThread("tc");
        MyThread td = new MyThread("td");
        MyThread te = new MyThread("te");

        // 将线程放入池中进行执行
        pool.execute(ta);
        pool.execute(tb);
        pool.execute(tc);
        pool.execute(td);
        pool.execute(te);

        // 关闭线程池
        pool.shutdown();
    }
}

class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
    }
}
/*
结果说明：
主线程中创建了线程池pool，线程池的容量是2。即线程池中最多能同时运行2个线程。
然后，将ta,tb,tc,td,te这3个线程添加到线程池中运行。
最后，通过shutdown()关闭线程池
 */