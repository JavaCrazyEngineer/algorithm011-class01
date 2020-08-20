import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node pre;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    private Map<Integer, Node>
            cache = new HashMap<Integer, Node>();

    private Node head, tail;

    private int count;

    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    /**
     * A B C
     * <p>
     * head
     * 头插法
     *
     * @param node
     */
    private void addNode(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * A B C
     * 删除 node B
     * A->prev=node.prv;
     * C->next=node.next;
     * prev.next=next;
     * next.prev=prev
     * 删除节点
     *
     * @param node
     */
    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    /**
     * 节点移动到头节点
     *
     * @param node
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 删除尾节点（删除最最近未使用到的数据）
     *
     * @return
     */
    private Node popTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }


    /**
     * 存储
     * @param key
     * @param val
     */
    public void put(int key, int val) {
        Node node = cache.get(key);
        if (node != null) {
            node.val=val;
            moveToHead(node);
        } else {
            node = new Node();
            node.key = key;
            node.val = val;
            cache.put(key, node);
            addNode(node);
            count++;

            if (capacity <count) {
                popTail();
                cache.remove(key, node);
                count--;
            }
        }
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public Node get(int key){
        Node node=cache.get(key);
        if(null!=node){
            moveToHead(node);
        }
        return node;
    }


    public static void main(String[] args) {
        LRUCacheI cache=new LRUCacheI(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);

        System.out.println(cache.get(2));
    }
}
