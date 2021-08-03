import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: Ken
 * @Date: 2021/8/2 20:54
 * 146.
 */
public class LRUCache {
    class Node {
        public Integer key, value;
        public Node prev;
        public Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRULinkedList {
        private Node head, tail;
        private Integer size = 0;

        public void removeNode(Node node) {
            if (head == node && tail == node) {
                head = tail = null;
            } else if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node removeLastNode() {
            Node node = tail;
            removeNode(tail);
            return node;
        }

        public Integer getSize() {
            return size.intValue();
        }

        public void addFirst(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        @Override
        public String toString() {
            return "LRULinkedList{" +
                    "head=" + head +
                    ", tail=" + tail +
                    ", size=" + size +
                    '}';
        }
    }


    private HashMap<Integer, Node> hashMap = null;
    private LRULinkedList cache;
    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap();
        cache = new LRULinkedList();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        } else {
            Node node = hashMap.get(key);
            Integer val = node.value;
            put(key, val);
            return val;
        }
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);
        if (hashMap.containsKey(key)) {
            cache.removeNode(hashMap.get(key));
            cache.addFirst(n);
            hashMap.put(key, n);
        } else {
            //判断cache是否满
            if (cache.getSize() >= capacity) {
                //删去最后一个
                Node last = cache.removeLastNode();
                //在hashMap中删除key
                hashMap.remove(last.key);
            }
            cache.addFirst(n);
            hashMap.put(key, n);
        }

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "hashMap=" + hashMap +
                ", \n cache=" + cache +
                ", \n capacity=" + capacity +
                '}';
    }
}

class M {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(1, 2);
        System.out.println(lruCache);
        System.out.println(lruCache.get(1));
    }
}
