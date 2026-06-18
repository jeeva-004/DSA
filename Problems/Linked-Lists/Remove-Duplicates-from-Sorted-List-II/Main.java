import java.util.*;

class ListNode {
    Node head;

    ListNode() {
        head = null;
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
            return;
        }
        Node temp = head;

        while (temp != null && temp.next != null)
            temp = temp.next;

        temp.next = n;
    }

    public void display() {
        if (head == null)
            return;
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public void removeDuplicatedElements() {
        if (head == null || head.next == null)
            return;

        Node s = head, f = head.next;
        
   

    }

    public void removeAllDuplicates(Node sNode, Node dNode) {
        while (dNode != null && dNode.val != dNode.next.val) {
            dNode = dNode.next;
        }
        if (dNode == null) {
            sNode.next = null;
            return;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(4);
        list.insert(5);
        list.removeDuplicatedElements();
        list.display();
    }
}