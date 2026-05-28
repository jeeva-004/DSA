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

    static ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> s = new HashSet<>();
        for (int n : nums)
            s.add(n);

        while (s.contains(head.val))
            head = head.next;
        ListNode temp = head, pre = null;
        while (temp != null && temp.next != null) {
            pre = temp;
            temp = temp.next;
            if (s.contains(temp.val)) {
                if (temp.next == null) {
                    pre.next = null;
                    return head;
                }
            } else {
                while (temp != null && s.contains(temp.val))
                    if (temp != null)
                        temp = temp.next;
                pre.next = temp;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}