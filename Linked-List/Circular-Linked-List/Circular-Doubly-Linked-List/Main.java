class CircularDoublyLinkedList<T> {
    Node last;
    int size;

    CircularDoublyLinkedList() {
        last = null;
        size = 0;
    }

    class Node {
        T data;
        Node next, previous;

        Node(T data) {
            this.data = data;
            next = previous = null;
        }
    }

    public void addAtEnd(T val) {
        Node newNode = new Node(val);
        if (size == 0) {
            newNode.next = newNode;
            newNode.previous = newNode;
            last = newNode;
            size++;
            return;
        }
        else{
            newNode.next = last.next;
            last.next = newNode;
            newNode.previous = last.previous;
            last.previous = newNode;
            last = newNode;
            size++;
        }
    }

    public void displayElementsForward(){
        Node temp = last.next;
        do{
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while(temp!=last.next);
        System.out.println();
    }

    public void displayElementsBackward(){
        Node temp = last;
        do{
            System.out.print(temp.data+" ");
            temp = temp.previous;
        }while(temp!=last);
    }
}

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();
        list.addAtEnd(1);
        list.addAtEnd(2);
        list.addAtEnd(3);
        // list.addAtEnd(4);
        // list.addAtEnd(5); 
        list.displayElementsForward();
        list.displayElementsBackward();
    }
}
