class CircularLinkedList<T> {
    int size;
    Node last;

    CircularLinkedList() {
        size = 0;
        last = null;
    }

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }

    }

    public void insertAtBegining(T val) {
        Node newNode = new Node(val);
        if (last == null) {
            newNode.next = newNode;
            last = newNode;
            size++;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
        size++;
    }

    public void addAtEnd(T val) {
        Node newNode = new Node(val);
        if (last == null) {
            newNode.next = newNode;
            last = newNode;
            size++;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void displayElements() {
        if (size == 0)
            throw new IndexOutOfBoundsException("displayElements method attempted on empty list");
        else {
            Node temp = last.next;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != last.next);
        }
    }

    public T deleteAtBegining() {
        if (size == 0)
            throw new IndexOutOfBoundsException("delteAtBegining method attempted on empty list");
        T deletedElement = last.next.data;
        if (size == 1) {
            last = null;
            size--;
        } 
        else {
            last.next = last.next.next;
            size--;
        }
        return deletedElement;
    }

    public T deleteAtEnd(){
        if (size == 0)
            throw new IndexOutOfBoundsException("delteAtBegining method attempted on empty list");
        T deletedElement = last.data;
        if (size == 1) {
            last = null;
            size--;
        } 
        else{
            Node temp = last;
            while(temp.next!=last){
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp;
            size--;
        }

        return deletedElement;
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.addAtEnd(1);
        list.addAtEnd(2);
        list.addAtEnd(3);
        System.out.println(list.deleteAtEnd());
        System.out.println(list.deleteAtEnd());

        list.displayElements();
    }
}
