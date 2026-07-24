import javax.management.openmbean.InvalidKeyException;

@SuppressWarnings("unchecked")
class HashMap<K, V> {
    private Node<K, V>[] buckets;
    private int size;
    static int capacity = 16;

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    HashMap() {
        size = 0;
        buckets = new Node[capacity];
    }

    // allocate index position

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // insert or update

    public void put(K key, V value) {

        int index = getHash(key);

        Node<K, V> node = new Node(key, value);

        //check if map is empty add the node directly without check anything
        if (size == 0) {
            buckets[index] = node;
            size++;
            return;
        }

        Node<K, V> head = buckets[index];
        //check if the key already exist or not if exist update the value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        //if the key is unique add to the map

        node.next = head;
        buckets[index] = node;
        size++;
    }

    public void remove(K key){
        if(size==0)
            throw new InvalidKeyException("Method attempted on empty map");

        int index = getHash(key);

        Node<K, V> pre = null;
        Node<K, V> current = buckets[index];

        if(size==1 && current.key==key){
            current = null;
            size--;
            return;
        }

        while(current!=null){

            if(current.key.equals(key)){
                if(pre==null)
                    buckets[index] = current.next;
                else
                    pre.next =current.next;

                size--;
                return;
            }

            pre = current;
            current = current.next;
        }   

    }

    public int size(){
        return size;
    }

    public V get(K key){

        int index  = getHash(key);

        Node<K, V> head = buckets[index];

        while(head!=null){
            if(head.key.equals(key))
                return head.value;
            head = head.next;
        }

        return null;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean containsKey(K key){
        return get(key)!=null;
    }

    public void print(){
        if(size==0)
            throw new InvalidKeyException("Method attempted on empty map");

        Node<K, V> head = buckets[0];

        for(int i = 0; i<capacity; i++){
            System.out.print(i+": ");

            Node<K, V> current = buckets[i];

            while(current!=null){

                System.out.print("(" + current.key + " " + current.value + ")" + "->");
                current = current.next;
            }
            System.out.println("NULL");
        }

    }

}

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("jeeva", 1);
        map.put("siva", 2);
        map.put("arun", 3);
        System.out.println(map.size());
    }
}
