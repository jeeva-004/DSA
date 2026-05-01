class Queue<T> {
    final int Maxsize = 30;
    T arr[];
    int foq, index;

    Queue() {
        arr = (T[]) new Object[Maxsize];
        foq = 0; 
        index = -1;
    }

    public void enQueue(T val) {
        if (foq > Maxsize - 1)
            throw new IndexOutOfBoundsException("Queue is overflow");
        arr[++index] = val;
    }

    public T peek() {
        if (foq == -1)
            throw new IndexOutOfBoundsException("Queue is underflow");
        return arr[foq];
    }
    
    public T deQueue(){
        if(index<0)
            throw new IndexOutOfBoundsException("Queue is underflow");
        return arr[foq++];
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Integer> data = new Queue<>();
        data.enQueue(1);
        data.enQueue(2);
        data.enQueue(3);
        System.out.println(data.peek());
        data.deQueue();
        System.out.println(data.peek());
        System.out.println(data.peek());

    }
}
