class BinarySearchTree {
    Node root;

    class Node {
        int key, height;
        Node r, l;

        Node(int data) {
            this.key = data;
            r = l = null;
            height = -1;
        }
    }

    BinarySearchTree(int val) {
        Node newNode = new Node(val);
        this.root = newNode;
    }

    BinarySearchTree() {
        this.root = null;
    }

    // In order traversal
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.l);
            System.out.print(root.key + " ");
            inOrder(root.r);
        }
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    public Node insert(Node r, int val) {
        if (r == null)
            return new Node(val);
        if (r.key > val)
            r.l = insert(r.l, val);
        else if (r.key < val)
            r.r = insert(r.r, val);
        else
            return r;
        // set height for all nodes
        r.height = 1 + Math.max(getHeight(r.l), getHeight(r.r));

        int balanceFactor = getBalanceFactor(r);

        // LL Case
        if (balanceFactor > 1 && val < r.l.key) {
            return rightRotate(r);
        }

        // LR Case
        if (balanceFactor > 1 && val > r.l.key) {
            r.l = leftRotate(r.l);
            return rightRotate(r);
        }

        // RR Case
        if (balanceFactor < -1 && val > r.r.key) {
            return leftRotate(r);
        }

        // RL Case
        if (balanceFactor < -1 && val < r.r.key) {
            r.r = rightRotate(r.r);
            return leftRotate(r);
        }

        return r;
    }

    public Node rightRotate(Node y) {
        Node x = y.l;
        Node t2 = x.r;

        x.r = y;
        y.l = t2;

        y.height = 1 + Math.max(getHeight(y.l), getHeight(y.r));
        x.height = 1 + Math.max(getHeight(x.l), getHeight(x.r));

        return x;
    }

    public Node leftRotate(Node y) {
        Node x = y.r;
        Node t2 = x.l;

        x.l = y;
        y.r = t2;

        y.height = 1 + Math.max(getHeight(y.l), getHeight(y.r));
        x.height = 1 + Math.max(getHeight(x.l), getHeight(x.r));

        return x;
    }

    public int getBalanceFactor(Node n) {
        if (n == null)
            return 0;
        return getHeight(n.l) - getHeight(n.r);
    }

    public int getHeight(Node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    public Node delete(Node root, int val) {
        if (search(val) != null) {
            if (root == null)
                return root;

            if (root.key > val)
                root.l = delete(root.l, val);
            else if (root.key < val)
                root.r = delete(root.r, val);
            else{
                if(root.l==null)
                    return root.r;
                else if(root.r==null)
                    return root.l;
                root.key = min(root.r);
                delete(root.r, root.key);
            }
        } else
            throw new IndexOutOfBoundsException("Value is not exist");

        return root;
    }

    public int min(Node n){
        int minimum = 0;
        while(n!=null){
            minimum = n.key;
            n = n.l;
        }
        return minimum;
    }

    public Node delete(int val) {
        root = delete(root, val);
        return root;
    }

    public Node search(int val) {
        return search(root, val);
    }

    public Node search(Node r, int val) {

        if (r == null || r.key == val)
            return r;

        if (val < r.key)
            return search(r.l, val);
        return search(r.r, val);

    }

}

class Main {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree(50);
        b.insert(30);
        b.insert(40);
        b.insert(70);
        b.insert(60);
        b.insert(20);
        b.insert(75);
        b.insert(80);

        b.inOrder(b.root);
        b.delete(75);
        System.out.println();
        b.inOrder(b.root);

    }

}