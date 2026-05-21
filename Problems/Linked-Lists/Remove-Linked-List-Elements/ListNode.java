import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Main {

static ListNode<Integer> removeLinkedList(ListNode<Integer> head, int val){
        while(head!=null&&head.val==val)
            head = head.next;
        ListNode temp = head, pre = head;
        while(temp!=null&&temp.next!=null){
            if(temp.val!=val)
                pre = temp;
            temp = temp.next;
            if(temp!=null&&temp.val==val)
                pre.next = temp.next;
        }
    return head;
}

    public static void main(String[] args) {

    }
}