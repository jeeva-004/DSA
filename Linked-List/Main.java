import java.util.Iterator;

class LinkedList<T> implements Iterable<T>{
    Node Head;
    int size;

    LinkedList() {
        Head = null;
        size = 0;
    }

    class Node {
        T data;
        Node next;

        Node(T val) {
            data = val;
            next = null;
        }
    }

    public void addNode(T val) {
        Node temp = Head;
        Node newNode = new Node(val);

        if (Head == null) {
            Head = newNode;
            size++;
            return;
        }

        for (int i = 1; i < size; i++) {
            temp = temp.next;
        }

        newNode.next = null;
        temp.next = newNode;
        size++;
    }

    public void insertAtBegining(T val) {
        Node newNode = new Node(val);
        if (size == 0) {
            Head = newNode;
            size++;
        } else {
            newNode.next = Head;
            Head = newNode;
            size++;
        }
    }

    public void displaylist() {
        Node temp = Head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtPosition(int pos, T val) {
        if (pos == 0) {
            insertAtBegining(val);
            size++;
            return;
        }
        Node newNode = new Node(val);
        Node temp = Head;
        for (int i = 1; i <= pos - 1; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid position " + pos);
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtPosition(int pos) {
        if (Head == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on the empty list");
        }

        if (pos == 0) {
            Head = Head.next;
            size--;
            return;
        }
        Node temp = Head;
        Node previous = null;
        for (int i = 1; i <= pos; i++) {
            previous = temp;
            temp = temp.next;
        }

        previous.next = temp.next;
        size--;
    }

    public void getAtIndex(int pos) {
        Node temp = Head;

        for (int i = 0; i < size; i++) {
            if (i == pos) {
                System.out.println(temp.data);
                return;
            }
            temp = temp.next;
        }
        System.out.println("-1");
    }

    public void updateAtIndex(int pos, T val) {
        Node temp = Head;
        for (int i = 0; i < size; i++) {
            if (i == pos) {
                temp.data = val;
                return;
            }
            temp = temp.next;
        }
        throw new IndexOutOfBoundsException("Index not found");
    }

    public void deleteAtEnd() {
        if (Head == null) {
            throw new IndexOutOfBoundsException("Index not found");
        }
        Node previous;
        Node temp = Head;
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                previous = temp;
                temp = temp.next;
            }
            temp.next = null;
            size--;
        } else {
            throw new IndexOutOfBoundsException("Deletion attempted on empty list");
        }
    }

    public void searchAtValue(T val) {
        Node temp = Head;
        for (int i = 0; i < size; i++) {
            if (temp.data == val) {
                System.out.println(i);
                return;
            }
            temp = temp.next;
        }
        System.out.println(-1);
    }

    public void contains(T val) {
        Node temp = Head;
        for (int i = 0; i < size; i++) {
            if (temp.data == val) {
                System.out.println(true);
                return;
            }
            temp = temp.next;
        }
        System.out.println(false);
    }

    public void length() {
        System.out.println(size);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = Head;

            public boolean hasNext() {
                return temp != null;
            }

            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;
            }
        };
    }

    public void reverse(){
        Node previous = null, current = Head, next = Head.next;

        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        Head = previous;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.displaylist();
        list.reverse();
        list.displaylist();

    }
}