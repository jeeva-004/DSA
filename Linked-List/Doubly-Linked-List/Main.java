import java.util.Iterator;

class DoublyLinkedList<T> implements Iterable<T> {
    Node head, tail;
    int size;

    DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    class Node {
        T data;
        Node previous, next;

        Node(T data) {
            this.data = data;
            previous = next = null;
        }
    }

    // Insert at begining

    public void insertAtBegining(T val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        size++;
    }

    public void displayForward() {
        if (size == 0) {
            System.out.println("list is empty...");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void displayBackward() {
        if (size == 0) {
            System.out.println("list is empty...");
            return;
        }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
    }

    public void insertAtEnd(T val) {
        if (size == 0) {
            insertAtBegining(val);
            return;
        }
        Node newNode = new Node(val), temp = head;
        for (int i = 1; i < size; i++) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.previous = temp;
        tail = newNode;
        size++;
    }

    public void insertAtPosition(int pos, T val) {
        if (pos == 0) {
            insertAtBegining(val);
            size++;
            return;
        }

        Node newNode = new Node(val), temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
            if (temp == null)
                throw new IndexOutOfBoundsException("Index not found " + pos);
        }
        newNode.next = temp.next;
        newNode.previous = temp;
        if (temp.next == null)
            tail = newNode;
        else
            temp.next.previous = newNode;
        temp.next = newNode;
        size++;
    }

    public void deleteFirst() {
        head = head.next;
        head.previous = null;
        size--;
    }

    public void deleteLast() {
        if (size == 0) {
            System.out.println("list is empty");
            return;
        }
        if (tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
            size--;
            return;
        } else
            tail = null;
        size--;
    }

    public void deleteAtPosition(int pos) {
        if (size == 0)
            throw new IndexOutOfBoundsException("deletion attempted on empty list..");
        else {
            if (pos == 0) {
                deleteFirst();
                return;
            }

            if (pos == size - 1) {
                deleteLast();
                return;
            }

            Node temp = head, prev = null;

            for (int i = 1; i <= pos; i++) {
                prev = temp;
                temp = temp.next;
                if (temp == null)
                    throw new IndexOutOfBoundsException("index not found " + pos);
            }

            prev.next = temp.next;
            if (temp.next == null)
                tail = prev;
            else
                temp.next.previous = prev;
            size--;
        }
    }

    public void contains(T val) {
        Node temp = head;
        while (temp != null) {
            if (val == temp.data) {
                System.out.println(true);
                return;
            }
            temp = temp.next;
        }

        System.out.println(false);
    }

    public void search(T val) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == val) {
                System.out.println(i);
                return;
            }
            temp = temp.next;
            if (temp.next == null) {
                System.out.println(-1);
                return;
            }
        }
    }

    public void length() {
        System.out.println(size);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = head;

            public boolean hasNext() {
                return temp != null;
            }

            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;
            }

            // reverse methods

            Node temp2 = tail;

            public boolean hasPrevious() {
                return temp2 != null;
            }

            public T previous() {
                T val = temp2.data;
                temp2 = temp2.previous;
                return val;
            }
        };
    }

    public Iterator<T> iteratorReverse() {
        return new Iterator<T>() {
            Node temp = tail;

            public boolean hasNext() {
                return temp != null;
            }

            public T next() {
                T val = temp.data;
                temp = temp.previous;
                return val;
            }
        };
    }

}

class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        Iterator i = list.iteratorReverse();
        Iterator j = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        while (j.hasNext()) {
            System.out.println(j.next());
        }
    }
}