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

    static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            count++;
            temp = temp.next;
        }
        int deletionNode = count - n + 1;
        if (count == 1 && n == 1) {
            head = null;
            return head;
        }
        if (deletionNode == 1) {
            head = head.next;
            return head;
        }

        ListNode pre = null;
        temp = head;
        for (int i = 1; i <= deletionNode; i++) {
            pre = temp;
            temp = temp.next;
        }

        if (temp.next == null)
            pre.next = null;
        else
            pre.next = temp.next;

        return head;
    }

    public static void main(String[] args) {

    }
}