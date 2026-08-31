import java.util.*;

class ListNode {
    Node head, tail;

    class Node {

        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    ListNode(int val) {
        Node node = new Node(val);
        node.val = val;
        head = node;
    }

    public void insert ( int val){
        if(head==null || tail==null){
            Node n = new Node(val);
            head = n;
            tail = n;
            return;
        }

        Node n = new Node(val);
        
        tail.next = n;
        tail = n;
    }

    public int[] nodeBetweenCriticalPoints(){
        if(head==null || head.next==null)
            return new int[] {-1, -1};
        Node pre = head, curr = head.next;
        
        if(curr.next==null)
            return new int[] {-1, -1};

        Node next = curr.next;

        int[] nodes = new int[2];
        nodes[0] = Integer.MAX_VALUE;
        nodes[1] = Integer.MIN_VALUE;
        int firstCritical = 0, lastCritical = 0, currentIndex = 1, preIndex = -1;

        while(next!=null){
            if(curr.val>pre.val && curr.val>next.val || curr.val<pre.val && curr.val<next.val){
                firstCritical = firstCritical==0?currentIndex:firstCritical;
                lastCritical = currentIndex;

                if(preIndex!= -1) 
                    nodes[0] = nodes[0]>(currentIndex - preIndex)?currentIndex - preIndex:nodes[0];
                
                preIndex = currentIndex;
            }

            pre = curr;
            curr = next;
            if(next!=null)
                next = next.next;
            
            currentIndex++;
        }

        if(currentIndex==preIndex)
            return new int[] {-1, -1};
        
        nodes[1] = lastCritical - firstCritical;
        
        nodes[0] = nodes[0]==Integer.MAX_VALUE?nodes[1]:nodes[0];

        return nodes;
    }   
}

public class Main{
    public static void main(String[] args){
        ListNode list = new ListNode(5);
        list.insert(3);
        list.insert(1);
        list.insert(2);
        list.insert(5);
        list.insert(1);
        list.insert(2);

        System.out.print(Arrays.toString(list.nodeBetweenCriticalPoints()));

    }
}