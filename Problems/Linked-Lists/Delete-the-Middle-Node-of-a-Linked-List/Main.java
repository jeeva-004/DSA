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

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            head = null;
            return head;
        }

        // find length of the list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int n = size / 2;
        for (int i = 1; i < n; i++) {
            temp = temp.next;
        }

        if (temp.next == null)
            temp.next = null;
        else
            temp.next = temp.next.next;

        return head;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}