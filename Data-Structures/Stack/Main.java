class Stack<T> {
    final int MaxSize = 30;
    T arr[];
    int tos;

    Stack() {
        arr = (T[]) new Object[MaxSize];
        tos = -1;
    }

    public void push(T val) {
        if (tos == MaxSize - 1)
            throw new IndexOutOfBoundsException("Stack is full");
        arr[++tos] = val;
    }

    public T pop() {
        if (tos == -1)
            throw new IndexOutOfBoundsException("Method attemted on empty list");
        return arr[tos--];
    }

    public T peek() {
        if (tos == -1)
            throw new IndexOutOfBoundsException("Method attempted on empty list");
        return arr[tos];
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.peek());
    }
}