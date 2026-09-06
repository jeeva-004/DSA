import java.util.*;

class LinkedList{
    Node head;
    Node tail;


    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            next = null;
        }
    }

    LinkedList(){
        head = null;
        tail = null;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head==null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        tail = tail.next;
    }

    public int[] nextGreaterElements(){
        
        if(head==null || head.next==null)
            return new int[] {0};
        int i = 0;
        Node temp = head;

        while(temp!=null){
            i++;
            temp = temp.next;
        }

        int[] originalValues = new int[i];
        temp = head;
        i = 0;
        while(temp!=null){
            originalValues[i++] = temp.val;
            temp = temp.next;
        }

        int[] nextGreatElements = new int[i];

        Deque<Integer> dStack = new ArrayDeque<>();
        temp = head;
        for(i = 0; i<originalValues.length; i++){
            while(!dStack.isEmpty() && originalValues[dStack.peek()]<temp.val){
                nextGreatElements[dStack.pop()] = temp.val;
            }

            dStack.push(i);
            temp = temp.next;
        }

        return nextGreatElements;        
    }
}

public class Main{
    public static void main(String[] args){
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);

        System.out.print(Arrays.toString(ll.nextGreaterElements()));

    }
}