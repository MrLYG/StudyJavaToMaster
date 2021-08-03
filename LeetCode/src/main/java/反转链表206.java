/**
 * @Author: Ken
 * @Date: 2021/7/20 18:13
 */
class Q06 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) next = next.next;
        }
        return cur;
    }



}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
