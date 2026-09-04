class Tree{
    Node root;

    Tree(){
        root = null;
    }

    class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public void insert(int val){
        root = insert(root, val);
    }

    public Node insert(Node r, int val){
        if(r==null)
            return new Node(val);
        
        if(r.val<val)
            r.left = insert(r.left, val);
        else
            r.right = insert(r.right, val);

        return r;
    }


    public void inOrder(Node r){
        if(r!=null){
            inOrder(r.left);
            System.out.print(r.val+" ");
            inOrder(r.right);
        }
    }

    public int maxDepth(Node r){
        if(r==null)
            return 0;
        int left  = maxDepthHelper(r.left);
        int right  = maxDepthHelper(r.right);
        
        return 1+Math.max(left, right);
    }

    public int maxDepthHelper(Node r){
        if(r==null)
            return 0;
        
        int left = maxDepthHelper(r.left);
        int right = maxDepthHelper(r.right);

        return 1 + Math.max(left, right);
    }
}

public class Main{
    public static void main(String[] args){
        Tree root = new Tree();
        root.insert(3);
        root.insert(2);
        root.insert(20);
        root.insert(15);
        // root.insert(15);

        // root.inOrder(root.root);
        System.out.print(root.maxDepth(root.root));
    }
}
