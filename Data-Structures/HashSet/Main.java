class HashSet<K> {
    static private int capacity = 16;
    Node<K>[] buckets;
    int size;

    class Node<K> {
        K key;
        Node next;

        Node(K k) {
            key = k;
            next = null;
        }
    }

    HashSet() {
        buckets = new Node[capacity];
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void add(K key) {
        int index = getHash(key);
        Node head = buckets[index];

        while (head != null) {
            if (head.key == key)
                return;
            head = head.next;
        }

        Node<K> n = new Node(key);
        n.next = buckets[index];
        buckets[index] = n;
        size++;
    }

    public void remove(K key) {
        int index = getHash(key);

        Node head = buckets[index];
        if (head != null && head.key == key) {
            buckets[index] = head.next;
            size--;
            return;
        }

        Node pre = null;
        while (head != null) {
            if (head.key == key) {
                if (pre == null)
                    buckets[index] = head.next;
                else
                    pre.next = head.next;

                size--;
                return;
            }

            head = head.next;
        }

    }

    public boolean contains(K key) {
        int index = getHash(key);
        Node head = buckets[index];

        if (head != null && head.key == key)
            return true;

        while (head != null) {

            if (head.key == key)
                return true;

            head = head.next;
        }

        return false;
    }

    public void print() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(i + ": ");
            Node current = buckets[i];

            while (current != null) {
                System.out.print("(" + current.key + ")" + "->");
                current = current.next;
            }

            System.out.println("Null");
        }

    }
}

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        set.print();
    }
}