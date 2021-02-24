package DataStructureAndAlgorithm;
import DataStructureAndAlgorithm.Node;
public class Jianzhi35 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        copyList(head);
        copyRandom(head);
        Node res = divideList(head);
        return res;
    }
    public void copyList(Node head){
        while(head!=null){
            Node nodeClone = new Node(head.val);
            nodeClone.next = head.next;
            head.next = nodeClone;
            nodeClone.random = head.random;
            head = nodeClone.next;
        }
    }

    public void copyRandom(Node head){
        Node nodeClone = head.next;
        while(true){
            if(nodeClone.random == null){
                nodeClone.random = null;
                if(nodeClone.next == null){
                    break;
                }
                nodeClone = nodeClone.next.next;
                continue;
            }
            nodeClone.random = nodeClone.random.next;
            if(nodeClone.next == null){
                break;
            }
            nodeClone = nodeClone.next.next;
        }
    }

    public Node divideList(Node head){
        Node nodeClone = head.next;
        Node nodeHead = nodeClone;
        while(nodeClone!=null){
            if(nodeClone.next == null){
                head.next = head.next.next; //head最后的一个结点一定要指向NULL
                break;
            }
            head.next = head.next.next;
            nodeClone.next = nodeClone.next.next;
            head = head.next;
            nodeClone = nodeClone.next;
        }

        return nodeHead;



        
    }

}
