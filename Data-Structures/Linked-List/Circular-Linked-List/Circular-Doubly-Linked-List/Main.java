import java.lang.reflect.InaccessibleObjectException;

class CircularDoublyLinkedList<T> {
    Node last;
    int size;

    CircularDoublyLinkedList() {
        last = null;
        size = 0;
    }

    class Node {
        Node next, previous;
        T data;

        Node(T data) {
            this.data = data;
            next = previous = null;
        }
    }

    public void addAtEnd(T val) {
        Node newNode = new Node(val);
        if (size == 0) {
            newNode.next = newNode;
            last = newNode;
            size++;
            return;
        }

        newNode.next = last.next;
        last.next.previous = newNode;
        newNode.previous = last;
        last.next = newNode;
        last = newNode;

        size++;

    }

    public void insertAtBegining(T val) {
        Node newNode = new Node(val);
        if (size == 0) {
            newNode.next = newNode.previous = newNode;
            last = newNode;
            size++;
            return;
        }
        newNode.previous = last;
        newNode.next = last.next;
        last.next.previous = newNode;
        last.next = newNode;
        size++;
    }

    public void deleteAtBegining() {
        if (size == 0)
            throw new IndexOutOfBoundsException("deleteAtBegining method attempted on empty list");
        if (size == 1) {
            last = null;
            size--;
            return;
        }

        last.next.next.previous = last;
        last.next = last.next.next;
        size--;
    }

    public void deleteAtEnd() {
        if (size == 0)
            throw new IndexOutOfBoundsException("method attempted on empty list");
        if (size == 1) {
            last = null;
            size--;
            return;
        }

        last.next.previous = last.previous;
        last.previous.next = last.next;
        last = last.previous;
        size--;
    }

    public void deleteAfterElement(T val) {
        if (size == 0)
            throw new IndexOutOfBoundsException("Method attempted on empty list");

        if (size == 1 && last.data == val) {
            last = null;
            size--;
            return;
        }
        boolean isHere = false;
        Node temp = last.next;

        do {
            if (temp.data == val) {
                isHere = true;
                break;
            }
            temp = temp.next;
        } while (temp != last.next);
        if (isHere) {
            if (temp.next == last) {
                deleteAtEnd();
                return;
            }
            temp.next.next.previous = temp;
            temp.next = temp.next.next;
            size--;
        } else
            throw new IndexOutOfBoundsException("Element does't exist " + val);

    }

    public void insertAfterElement(T val, T addAbleElement) {
        if (size == 0)
            throw new IndexOutOfBoundsException("list is already empty");
        if (val == last.data) {
            insertAtBegining(addAbleElement);
            return;
        }
        Node temp = last.next;
        boolean isHere = false;
        do {
            if (temp.data == val) {
                isHere = true;
                break;
            }
            temp = temp.next;

        } while (temp != last.next);
        if (isHere) {
            Node newNode = new Node(addAbleElement);

            newNode.next = temp.next;
            newNode.previous = temp;
            temp.next.previous = newNode;
            temp.next = newNode;
            size++;

        } else
            throw new IndexOutOfBoundsException("Element does't exist " + val);
    }

    public void deleteByValue(T val) {
        if (size == 0)
            throw new IndexOutOfBoundsException("Method attempted on empty list");
        if (last.data == val) {
            deleteAtEnd();
            return;
        }
        if (last.next.data == val) {
            deleteAtBegining();
            return;
        }
        Node temp = last.next;
        boolean isHere = false;
        do {
            if (temp.data == val) {
                isHere = true;
                break;
            }
            temp = temp.next;
        } while (temp != last.next);

        if (isHere) {
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            size--;
        } else
            throw new IndexOutOfBoundsException("Elment does't exist " + val);
    }

    public void length() {
        System.out.println(size);
    }

    public void contains(T val) {
        if (size == 0)
            throw new IndexOutOfBoundsException("method attempted on empty list");
        if (size == 1) {
            System.out.println(last.data == val ? true : false);
            return;
        }
        boolean isHere = false;
        Node temp = last.next;
        do {
            if (temp.data == val) {
                isHere = true;
                break;
            }
            temp = temp.next;
        } while (temp != last.next);

        System.out.println(isHere);
    }

    public void displayForward() {
        if (size == 0)
            throw new IndexOutOfBoundsException("method attempted on empty list");
        Node temp = last.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
    }

    public void displayBackward() {
        if (size == 0)
            throw new IndexOutOfBoundsException("method attempted on empty list");
        Node temp = last;
        do {
            System.out.print(temp.data + " ");
            temp = temp.previous;
        } while (temp != last);
    }
}

class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();

        list.addAtEnd(1);
        list.addAtEnd(2);
        list.addAtEnd(3);
        list.addAtEnd(4);
        list.contains(5);
        list.displayForward();
        System.out.println();
        list.displayBackward();
    }
}