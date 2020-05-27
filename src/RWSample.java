import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/05.
 */

public class RWSample {
    private final Map<String, String> m = new HashMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public String get (String key) {
        System.out.println("读锁锁定！");
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    public String put(String key, String entry) {
        System.out.println("写锁锁定！");
        w.lock();
        try {
            return m.put(key, entry);
        } finally {
            w.unlock();
        }
    }
}

