package com.fan.aqs;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/07/12.
 */

public class Mutex {
    class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.tryAcquire(0);
    }

    public void unLock() {
        sync.tryRelease(0);
    }

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap<>();
        Integer put = (Integer) map.put(1, 2);
        Integer put2 = (Integer) map.put(1, 3);
        System.out.println(put);
        System.out.println(put2);
    }
}

