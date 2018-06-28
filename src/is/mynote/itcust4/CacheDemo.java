package is.mynote.itcust4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存系统设计
 * （读写锁的应用）
 *
 * @author Neal
 */
public class CacheDemo {
    private Map<String, Object> cache = new HashMap<>(16);

    public static void main(String[] args) {

    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    /**
     * 在缓存中取值
     *
     * @param key key
     * @return Object
     */
    public Object getValue(String key) {
        Object value;
        rwl.readLock().lock();
        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    // 防止其他线程再拿到写锁，进行多次写入
                    if (value == null) {
                        value = "from db";
                    }
                } finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }
}
