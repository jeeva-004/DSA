class Binarytree {
    Node root;

    class Node {
        int key;
        Node r, l;

        Node(int data) {
            this.key = data;
            r = l = null;
        }
    }

    Binarytree(int val) {
        Node newNode = new Node(val);
        this.root = newNode;
    }

    Binarytree() {
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
        insert(root, val);
    }

    public Node insert(Node r, int val) {
        if (r == null)
            return new Node(val);
        if (r.key > val)
            r.l = insert(r.l, val);
        else
            r.r = insert(r.r, val);
        return r;
    }

    public void search(int val){
        search(root, val);
    }

    public Node search(Node r, int val){
        
        if(r==null || r.key==val)
            return r;

        if(val<r.key)
           return search(r.l,val);
        return search(r.r, val);
        
    }


    public void remove(int val) {
        remove(root, val);
    }

    public Node remove(Node r, int val) {
        
        if(search(r, val)==null)
            throw new IndexOutOfBoundsException("value is not found");
        else{
            //find the correct element
            if(val<r.key)
                r.l = remove(r.l, val);
            else if(val>r.key)
                r.r = remove(r.r,val);
            else{
                // if node with any one child 
                if(r.r==null)
                    return r.l;
                else if(r.l==null)
                    return r.r;
                r.key = min(r.r);
                r.r = remove(r.r, r.key);
            }
        } 
 
        return r;
    }

    public int min(Node r){
        int minValue = r.key;
        while (r!=null) {
            minValue = r.key;
            r = r.l;
        }    
    return minValue;
    }

}

class Main {
    public static void main(String[] args) {
        Binarytree b = new Binarytree(50);
        b.insert(30);
        b.insert(40);
        b.insert(70);
        b.insert(60);
        b.insert(20);
        b.insert(75);
        b.insert(80);

        b.inOrder(b.root);
        b.remove(20);
        System.out.println();
        b.inOrder(b.root);

}

}