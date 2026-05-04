class Queue<T> {
    final int Maxsize = 30;
    T arr[];
    int index;

    Queue() {
        arr = (T[]) new Object[Maxsize];
        index = -1;
    }

    public void enQueue(T val) {
        if (index > Maxsize - 1)
            throw new IndexOutOfBoundsException("Queue is overflow");
        arr[++index] = val;
    }

    public T peek() {
        if (index <0)
            throw new IndexOutOfBoundsException("Queue is underflow");
        return arr[0];
    }
    
    public T deQueue(){
        if(index<0)
            throw new IndexOutOfBoundsException("Queue is underflow");
        T val = arr[0];
        for(int i = 0; i<index; i++){
            arr[i] = arr[i+1];
        }
        index--;
        return val;
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
        data.deQueue();
        
        System.out.println(data.peek());
        data.deQueue();
        data.enQueue(5);   
        System.out.println(data.peek());

    }
}
