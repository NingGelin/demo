package com.example.demo.threadTest;

/**
 * 通过实现Runnable接口
 */
class MyThread implements Runnable
{
    private String name;
    public MyThread (String name)
    {
        this.name = name;
    }

    public void run()
    {
        for (int i=0; i<10; i++)
        {
            System.out.println(name + "运行, i = " + i);
        }
    }
}

/**
 * 通过继承Thread类，Thread类也是实现的Runnable接口
 */
class BuildMessage extends Thread
{
    public void run()
    {
        try {
            //TimeUnit.SECONDS.sleep(5L);
            Thread.sleep(5000);
            System.out.println("thread2");
        }
        catch (Exception e)
        {
            System.out.println("sleep error");
        }
    }
}

/**
 * 主类
 */
public class ThreadTest
{
    public static void main(String[] args)
    {
        MyThread mt1 = new MyThread("线程A");
        MyThread mt2 = new MyThread("线程B");

        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt2);

        t1.start();
        t2.start();

        BuildMessage buildMessage = new BuildMessage();
        buildMessage.start();
    }
}
