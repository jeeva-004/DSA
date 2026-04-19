package Queue;
class Queue {
    int[] queue = new int[5];
    int foq, index;

    Queue() {
        foq = -1;
        index = -1;
    }

    void enQueue(int value) {
        if (index >= 4)
            System.out.println("Queue is overflow");
        else
            queue[++index] = value;
    }

    int deQueue() {
        if (index < 0)
            System.out.println("queue is underflow");
        else {
            index -= 1;
            return queue[++foq];
        }
        return 0;
    }
}

public class Queuedata {
    public static void main(String[] args) {
        Queue data = new Queue();
        data.enQueue(4);
        data.enQueue(2);
        data.enQueue(3);
        data.enQueue(1);
        data.enQueue(8);
        data.enQueue(3);
        System.out.println(data.deQueue());
        System.out.println(data.deQueue());
        System.out.println(data.deQueue());
        System.out.println(data.deQueue());
        System.out.println(data.deQueue());
        System.out.println(data.deQueue());
    }
}
