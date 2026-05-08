class QueueLinkedList<T> {
    Node top;
    Node end;

    QueueLinkedList() {
        top = end = null;
    }

    class Node {
        Node next;
        T data;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public void enQueue(T val) {
        Node newNode = new Node(val);
        if (top == null)
            top = newNode;
        else
            end.next = newNode;
        end = newNode;
    }

    public T deQueue() {
        if (top == null)
            throw new IndexOutOfBoundsException("Queue is empty");
        T val = top.data;
        top = top.next;
        if (top == null)
            end = null;
        return val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if (top == null)
            throw new IndexOutOfBoundsException("queue is empty");
        return top.data;
    }
}

public class Main {
    public static void main(String[] args) {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.isEmpty());

    }
}
