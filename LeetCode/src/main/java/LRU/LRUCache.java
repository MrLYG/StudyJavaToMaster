package LRU;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Author: Ken
 * @Date: 2021/8/3 12:02
 */
public class LRUCache {

    private HashMap<Object, Node> map;
    private CacheLinkedList cache;
    private int capacity;


    public LRUCache(int cap) {
        this.capacity = cap;
        map = new HashMap();
        cache = new CacheLinkedList();
    }

    public Object get(Object key) {
        //如果map中不包含该key证明在缓存中不包含该数据，
        // 类似~ 数据存储结构 cache 地址未命中缓存，自然缓存中没有该数据
        if (!map.containsKey(key)) return -1;

        //根据hashMap的特性通过key直接获取数据（此处为value）
        Object v = map.get(key).getValue();
        //将获取到的节点再次放入，put中有机制，保证再次放入缓存（链表）中存在的数据，将该节点放到头部
        this.put(key, v);
        return v;
    }

    public void put(Object key, Object value) {
        //根据key和value生成节点
        Node n = new Node(key, value);

        //判断插入的数据是否包含在map中，保证证明在链表中存在该数据（缓存命中）
        if (map.containsKey(key)) {
            //缓存命中后删除该节点
            cache.removeNode(map.get(key));
            //将该节点加在头部，等同于计数器记为0，表明近期在使用-保留
            cache.addFirstNode(n);
            //同步修改map中的k,v
            map.put(key, n);
        } else {
            //如果缓存满了（链表满了）
            if (cache.getSize() == capacity) {
                //删除链表最后一个元素，因为根据我们的插入和访问特性，
                //（缓存命中）访问的节点被提到第一个-->命中时，所命中的行的计数器清零，比其低的计数器加1，其余不变；
                //（缓存未命中）插入的数据被放到第一个，这样链表从首到尾依次的顺序代表节点没有被访问的次数的排序
                //根据LRU 近期最少使用算法，删除最后一个
                Node lastNode = cache.removeLastNode();
                //同时在map中删除-->这就是为什么在节点中保存key的原因
                map.remove(lastNode.getKey());
            }
            cache.addFirstNode(n);
            map.put(key, n);
        }
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                ", cache=" + cache +
                ", capacity=" + capacity +
                '}';
    }
}
class M{

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));

        System.out.println(lruCache);
    }
}
