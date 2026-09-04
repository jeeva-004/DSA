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


    static boolean isSameTree(Node p, Node q){
        if(p==null && q==null)
            return true;

        if((p==null && q!=null) || (p!=null && q==null) )
            return false;
        
        return isSame(p, q);
    }

    static boolean isSame(Node p, Node q){
        
        if(p!=null && q!=null){
            if(p.val!=q.val)
                return false;
            boolean left = isSame(p.left, q.left);
            boolean right = isSame(p.right, q.right);

            if(!left || !right)
                return false;
        }

        if((p==null && q!=null) || (p!=null && q==null) )
            return false;
        
        return true;
    }

}

public class Main{
    
    public static void main(String[] args){
        Tree p = new Tree();
        Tree q = new Tree();

        p.insert(2);
        p.insert(3);
        p.insert(6);
        p.insert(5);
        p.insert(4);
        p.insert(3);

        q.insert(2);
        q.insert(3);
        q.insert(6);
        q.insert(5);
        q.insert(4);
        // q.insert(3);


        System.out.print(Tree.isSameTree(p.root, q.root));

    }
}