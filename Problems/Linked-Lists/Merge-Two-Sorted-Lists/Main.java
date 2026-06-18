class LinkedList{
    Node head;

    class Node{
        Node next;
        int val;
        Node(int val){
            this.val = val;
            next = null;
        }
    }

    LinkedList(){
        head = null;
    }

    public LinkedList mergeList(Node h1, Node h2){
        LinkedList mergedList = new LinkedList();
        
        Node t1 = h1, t2 = h2, tail = null;

        while(t1!=null&&t2!=null){

            Node choosen = null;

            if(t1.val<=t2.val){
                choosen = t1;
                t1 = t1.next;
            }
            else if(t1.val>=t2.val){
                choosen = t2;
                t2 = t2.next;
            }

            if(mergedList==null){
                tail = choosen;
                // mergedList = ;
            }
            else{
                tail.next = choosen;
                tail = tail.next;
            }
        }

        if(t1!=null)
            tail.next = t1;
        if(t2!=null)
            tail.next = t2;
        
        return mergedList;
    }
}

public class Main{

    public static void main(String[] args) {
        
    }
}