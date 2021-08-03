package LRU;

/**
 * @Author: Ken
 * @Date: 2021/8/3 11:57
 */
public class CacheLinkedList implements ICacheLinkedList{
    private Node head, tail;
    private int size;

    @Override
    public void removeNode(Node node) {
        if (head == node && tail == node) {
            head = tail = null;
        } else if (tail == node) {
            node.getPre().setNext(null);
            tail = node.getPre();
        } else if (head == node) {
            node.getNext().setPre(null);
            head = node.getNext();
        } else {
            node.getPre().setNext(node.getNext());
            node.getNext().setPre(node.getPre());
        }
        size--;
    }

    @Override
    public Node removeLastNode() {
        Node node = tail;
        removeNode(tail);
        return node;
    }

    @Override
    public void addFirstNode(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            Node n = head;
            n.setPre(node);
            node.setNext(n);
            head = node;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "CacheLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
