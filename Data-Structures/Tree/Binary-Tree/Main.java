class Binarytree<T> {
    Node root;

    class Node {
        T data;
        Node r, l;

        Node(T data) {
            this.data = data;
            r = l = null;
        }
    }

    Binarytree(T val) {
        Node newNode = new Node(val);
        this.root = newNode;
    }

    Binarytree() {
        this.root = null;
    }

    public void insertRight(Node root, T val) {
        Node newNode = new Node(val);
        root.r = newNode;
    }
    public void insertLeft(Node root, T val) {
        Node newNode = new Node(val);
        root.l = newNode;
    }

    // pre order traversal

    public void preOrder(Node root){
        if(root!=null){
        System.out.print(root.data+" ");
        preOrder(root.l);
        preOrder(root.r);
        }
    }

    //In order traversal
    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.l);
            System.out.print(root.data+" ");
            inOrder(root.r);
        }
    }

    // Post order traversal

    public void postOrder(Node root){
        if(root!=null){
            postOrder(root.l);
            postOrder(root.r);
            System.out.print(root.data+" ");
        }
    }


}

class Main {
    public static void main(String[] args) {
        Binarytree<Integer> b = new Binarytree<>(3);

        b.insertRight(b.root, 4);
        b.insertLeft(b.root, 2);
        b.insertRight(b.root.l, 1);
        b.insertLeft(b.root.r, 5);

        b.preOrder(b.root);
        System.out.println();
        b.inOrder(b.root);
        System.out.println();
        b.postOrder(b.root);
    }
}