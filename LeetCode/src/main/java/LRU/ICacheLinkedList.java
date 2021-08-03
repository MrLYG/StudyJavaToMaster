package LRU;

/**
 * @Author: Ken
 * @Date: 2021/8/3 11:59
 */
public interface ICacheLinkedList {
    void removeNode(Node node);

    Node removeLastNode();

    void addFirstNode(Node node);
}
