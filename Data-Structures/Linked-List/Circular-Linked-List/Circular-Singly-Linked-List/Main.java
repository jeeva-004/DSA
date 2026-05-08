class CircularSinglyLinkedList<T> {
    int size;
    Node last;

    CircularSinglyLinkedList() {
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
        } else {
            last.next = last.next.next;
            size--;
        }
        return deletedElement;
    }

    public T deleteAtEnd() {
        if (size == 0)
            throw new IndexOutOfBoundsException("delteAtBegining method attempted on empty list");
        T deletedElement = last.data;
        if (size == 1) {
            last = null;
            size--;
        } else {
            Node temp = last;
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp;
            size--;
        }

        return deletedElement;
    }

    public void insertAtAfterElement(T beforeElement, T val) {
        if (size == 0)
            throw new IndexOutOfBoundsException("insertAtAfterElement method attempted on empty list");
        Node newNode = new Node(val), temp = last.next;
        boolean isHere = false;
        do {
            if (beforeElement == temp.data) {
                isHere = true;
                break;
            }
            temp = temp.next;
        } while (temp != last.next);
        if (isHere) {
            if (val == last.data || size == 1) {
                addAtEnd(val);
                size++;
            } else if (val == last.next.data) {
                newNode.next = last.next.next;
                last.next.next = newNode;
                size++;
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
            }
        }

        else
            throw new IndexOutOfBoundsException("there is no any number exist " + beforeElement);
    }

    public T deleteAtAfterElement(T deletableBeforeElement) {
        if (size == 0)
            throw new IndexOutOfBoundsException("deleteAtAfterElement method attempted on empty list");
        if (size == 1) {
            T temp = last.data;
            last = null;
            size--;
            return temp;
        }

        Node temp = last.next;
        boolean isHere = false;

        do {
            temp = temp.next;
            if (temp.data == deletableBeforeElement) {
                isHere = true;
                break;
            }
        } while (temp != last.next);
        if (isHere) {
            T value = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return value;
        } else {
            throw new IndexOutOfBoundsException("Element does't exist " + deletableBeforeElement);
        }
    }

    public T deleteElementByValue(T val) {
        if(size==0){
            throw new IndexOutOfBoundsException("deletion attempted on empty method");
        }
        Node temp = last.next, prev = null;
        boolean isHere = false;
        do {
            prev = temp;
            temp = temp.next;
            if(temp.data==val){
                isHere = true;
                break;
            }
        } while (temp!=last.next);
        if(isHere){
            prev.next = temp.next;
            size--;
        }
        return val;
    }

    public boolean containsValue(T val){
        if(size==0)
            throw new IndexOutOfBoundsException("Method attempted on empty list");
        Node temp = last.next;
        boolean isHere = false;
        do {
            temp = temp.next;
            if(temp.data==val){
                isHere = true;
                break;
            }
        } while (temp!=last.next);
        return isHere;
    }

    public int length(){
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();
        list.addAtEnd(1);
        list.addAtEnd(2);
        list.addAtEnd(3);
        System.out.println(list.length());
        // list.displayElements();
    }
}
