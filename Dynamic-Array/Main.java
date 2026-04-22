import java.util.*;

class DynamicArray<T> implements Iterable<T> {
    private final static int initialCapacity = 8;
    private int size, capacity;
    private T[] arr;

    @SuppressWarnings("Unchecked")

    DynamicArray() {
        size = 0;
        capacity = initialCapacity;
        arr = (T[]) new Object[initialCapacity];
    }

    public void add(T val) {
        if (size == capacity) {
            expandArray();
        }
        arr[size++] = val;
    }

    private void expandArray() {
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    public void displayList() {
        System.out.println("Elements in the List");
        for (int n = 0; n < size; n++) {
            System.out.print(arr[n] + " ");
        }
        System.out.println();
    }

    public void insert(int pos, T val) {
        if (capacity == size)
            expandArray();
        for (int i = size - 1; pos <= i; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = val;
        size++;
    }

    public void remove(int pos) {
        for (int i = pos + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;

        if (capacity > initialCapacity && capacity > 3 * size)
            shrinkArray();
    }

    private void shrinkArray() {
        capacity /= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    public void deleteAtEnd() {
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i];
        }
        size--;
    }

    public void deleteAtBegining() {
        for (int i = 0; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void insertAtBegining(T val) {
        if (capacity == size)
            expandArray();
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = val;
        size++;
    }

    public void updateValue(int pos, T val) {
        arr[pos] = val;
    }

    public boolean search(T val) {
        for (int i = 0; i < size; i++) {
            if (val == arr[i])
                return true;
        }
        return false;
    }

    public void getValue(int index) {
        System.out.println(arr[index]);
    }

    public void clear() {
        size = 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DynamicArray<Integer> arr = new DynamicArray<>();
        int choise = 0;
        while (true) {
            System.out.println("-----------------List Menu-----------------");

            System.out.println("1. Insert at End");
            System.out.println("2. Display the List");
            System.out.println("3. Insert at the specified position");
            System.out.println("4. Delete at the specified position");
            System.out.println("5. Insert at beginning ");
            System.out.println("6. Delete at the begining");
            System.out.println("7. Delete at the end");
            System.out.println("8. Update value by specified position ");
            System.out.println("9. Search value using specified position");
            System.out.println("10. Get value using specified position");
            System.out.println("11. To clear all data ");
            System.out.println("12. Exit");

            System.out.println("--------------------------------------------");
            System.out.print("Enter you Choise: ");
            choise = s.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Enter a value: ");
                    int val = s.nextInt();
                    arr.add(val);
                    break;
                case 2:
                    arr.displayList();
                    for (int i : arr) {
                        System.out.println(i);
                    }
                    break;
                case 3:
                    System.out.println("Enter a position : (position start form 0): ");
                    int pos = s.nextInt();
                    System.out.println("Enter a Element :");
                    val = s.nextInt();
                    if (pos < 0) {
                        System.out.println("Enter a positive position. Position start from 0");
                        pos = s.nextInt();
                    }
                    arr.insert(pos, val);
                    break;
                case 4:
                    System.out.println("Enter a position : (postion start from 0)");
                    pos = s.nextInt();
                    if (pos < 0) {
                        System.out.println("Enter a positive position. Position start from 0");
                        pos = s.nextInt();
                    }
                    arr.remove(pos);
                    break;
                case 5:
                    System.out.println("Enter a Number: ");
                    val = s.nextInt();
                    arr.insertAtBegining(val);
                    break;
                case 6:
                    arr.deleteAtBegining();
                    break;

                case 7:
                    arr.deleteAtEnd();
                    break;

                case 8:
                    System.out.println("Enter a position (position start from 0): ");
                    pos = s.nextInt();
                    if (pos < 0) {
                        System.out.println("Enter a positive position: ");
                        pos = s.nextInt();
                    }
                    System.out.println("Enter a Value: ");
                    val = s.nextInt();
                    arr.updateValue(pos, val);
                    break;
                case 9:
                    System.out.println("Enter a Number: ");
                    val = s.nextInt();
                    arr.search(val);
                    break;
                case 10:
                    System.out.println("Enter a index (start from 0): ");
                    val = s.nextInt();
                    arr.getValue(val);
                    break;
                case 11:
                    arr.clear();
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid option in the menu (1-5)!");
                    break;
            }
        }
    }
}