package threads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest1 {
    // TODO: list是ArrayList对象时，程序会出错。
    //private static List<String> list = new ArrayList<String>();
    private static List<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {
        // 同时启动两个线程对list进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value = null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            value = (String) iterator.next();
            System.out.print(value + ", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName() + "-" + i;
                list.add(val);
                // 通过“Iterator”遍历List
                printAll();
            }
        }
    }
}
/*
结果说明：如果将源码中的list改成ArrayList对象时，
程序会产生ConcurrentModificationException异常
 */