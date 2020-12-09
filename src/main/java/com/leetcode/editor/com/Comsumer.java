package com.leetcode.editor.com;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-12-09 12:23
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.leetcode.editor.com
 * @ProjectName : LeetCodeProjects
 * @Version : 1.0.0
 */
public class Comsumer {

    // 最大30
    private volatile int size = 0;

    private volatile LinkedList<Integer> list = new LinkedList<>();

    // 创建一个锁对象
    private Lock lock = new ReentrantLock();
    // 创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void product() {

    }

    public void comsumer() {
        while (true) {
            try {
                lock.lock();
                list.addLast(1);
                if (size < 30) {
                    notFull.signalAll();
                } else {
                    notEmpty.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Comsumer comsumer = new Comsumer();
        for (int i = 0; i < 10; i++) {
            // 启动十个生产者
            new Thread(comsumer::product).start();
            // 启动十个消费者
            new Thread(comsumer::comsumer).start();
        }
    }

}
