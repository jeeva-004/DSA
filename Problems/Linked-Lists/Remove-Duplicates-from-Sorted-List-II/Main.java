import java.util.HashMap;
import java.util.Map;

class ListNode {
    Node head;
    int size;

    ListNode() {
        head = null;
        size = 0;
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public void insert(int v) {
        Node n = new Node(v);
        if (head == null) {
            head = n;
            size++;
            return;
        }
        Node temp = head;

        while (temp != null && temp.next != null)
            temp = temp.next;

        temp.next = n;
        size++;
    }

    public void display() {
        Node temp = head;

        for (int i = 1; i <= size; i++) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public void removeDuplicatedElements() {
       
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(3);
        list.insert(4);
        list.insert(4);
        list.insert(5);
        list.display();
        list.removeDuplicatedElements();
        list.display();
    }
}