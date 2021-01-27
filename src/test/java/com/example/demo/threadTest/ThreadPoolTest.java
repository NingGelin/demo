package com.example.demo.threadTest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Executor executor = new ThreadPoolExecutor(5,100,0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024),
                new ThreadFactoryBuilder().setNameFormat("pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                20,
                50,
                10L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("TrainMessageConsumer").build(),
                new ThreadPoolExecutor.AbortPolicy());


        MyThread myThread = new MyThread("线程1");
        executor.execute(new Thread(myThread));


        System.out.println("thread1");
        executor.execute(() -> buildMessage());
        System.out.println("thread3");
    }


    private static void buildMessage()
    {
        try
        {
            TimeUnit.SECONDS.sleep(5L);
            System.out.println("thread2");
        }
        catch (Exception e)
        {
            System.out.println("sleep error: " + e);
        }

    }
}
