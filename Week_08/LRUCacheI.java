import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存
 */
public class LRUCacheI extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCacheI(int capacity) {
        super(capacity,0.75f,true);
    }


    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
       super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}
