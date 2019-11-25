package all.线程;

import   java.util.concurrent.locks.ReentrantLock;
public class ReentrantLock1 {

    static  ReentrantLock  reentrantLock =new ReentrantLock();

    public static void main(String[] args){  
        Thread t1 =new Thread(){
            @Override
            public void  run(){
           testsync();
            }
        };
         t1.setName("t1");

        Thread t2 =new Thread(){
            @Override
            public void  run(){
                testsync();
            }
        };
        t2.setName("t2");

        t1.start();
        t2.start();
/*        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();*/

    }
    public static void  testsync(){
        String name=Thread.currentThread().getName();
       // reentrantLock.lock();
        try {
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            reentrantLock.unlock();
        }
        System.out.println(name);
    }




}
