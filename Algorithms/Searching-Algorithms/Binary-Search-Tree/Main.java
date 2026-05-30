class BinarySearchTree {
    Node root;

    BinarySearchTree(int key) {
        root = new Node(key);
    }

    BinarySearchTree() {
        root = null;
    }

    class Node {
        int key;
        Node right, left;

        Node(int key) {
            this.key = key;
            right = left = null;
        }
    }

    public Node insert(Node r, int val) {
        if (r == null)
            return new Node(val);

        if (val < r.key)
            r.left = insert(r.left, val);
        else
            r.right = insert(r.right, val);
        return r;
    }

    public void inOrder(Node r) {
        if (r != null) {
            inOrder(r.left);
            System.out.print(r.key + " ");
            inOrder(r.right);
        }
    }

    public Node search(Node r, int v) {
        if (r == null || r.key == v)
            return r;
        if (v < r.key)
            return search(r.left, v);
        return search(r.right, v);
    }
}

class Main {
    public static void main(String[] args) {
        BinarySearchTree bTree = new BinarySearchTree(50);

        bTree.insert(bTree.root, 20);
        bTree.insert(bTree.root, 60);
        bTree.insert(bTree.root, 10);
        bTree.insert(bTree.root, 70);

        if (bTree.search(bTree.root, 11) == null)
            System.out.println("value not found");
        else
            System.out.println("value is exist");
    }
}                                                           