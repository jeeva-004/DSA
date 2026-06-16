
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

        if(head!=null&&head.next!=null&&head.val==head.next.val){
            while(head!=null&&head.next!=null&&head.val==head.next.val){
                head = head.next;
            }
            head = head.next;
        }

        Node s = head, f = head;

        while (f != null) {
            if (f!=null&&f.next!=null&&f.val!=f.next.val) {
                f = f.next;
                if(f!=null&&f.next!=null&&f.val!=f.next.val){
                    s = s.next;
                }
                else{
                    
                }

            } else {
                while (f != null && s.val == f.val)
                    f = f.next;
                if (f == null)
                    s.next = null;
                else
                    s.next = f;
                if (f != null)
                    f = f.next;
                s = s.next;
            }
        }
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
        list.insert(3);
        list.insert(3);
        list.removeDuplicatedElements();
        list.display();
    }
}