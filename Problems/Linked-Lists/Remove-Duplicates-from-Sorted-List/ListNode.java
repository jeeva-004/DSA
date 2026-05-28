import java.util.*;

public class ListNode {
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

class Main {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head, pre = null;

        while (temp != null) {
            pre = temp;
            temp = temp.next;

            if (temp != null && temp.val == pre.val) {
                while (temp != null && temp.val == pre.val) {
                    temp = temp.next;
                }
                pre.next = temp;
            }
        }

        return head;
    }

    public static void main(String[] args) {

    }
}