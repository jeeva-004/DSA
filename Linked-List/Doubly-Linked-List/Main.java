class DoublyLinkedList{
    Node head, tail;
    int size;
    DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    class Node{
        int data;
        Node previous, next;
        Node(int data){
            this.data = data;
            previous = null;
            next = null;
        }
    }

    public void add(int val){
        Node newNode = new Node(val);
        if(size==0){
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        Node temp = head;
        while(temp!=null){
            if(temp.next==null)
                break;
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.previous = temp;
        tail = newNode;
        size++;
    }

    public void displayForward(){
        if(size==0){
            System.out.println("list is empty");
            return;
        }

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public void displayBackward(){
        if(size==0){
            System.out.println("list is empty");
            return;
        }

        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.previous;

        }
    }
}


class Main{
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.displayForward();
        System.out.println();
        list.displayBackward();
    }
}