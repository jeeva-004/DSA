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

    public boolean hasPathSum(int targetSum){
        if(root==null)
            return false;
        return hasSum(root, targetSum);        
    }

    public boolean hasSum(Node root, int targetSum){
        boolean left = false, right = false;

        if(root==null)
            return false;
        
        int sum = targetSum-root.val;

        if(sum==0 && root.left==null && root.right==null)
            return true;

        if(root!=null)
            left = hasSum(root.left, sum);
        if(root!=null)
            right = hasSum(root.right, sum);

        if(left || right)
            return true;

        return false;    
    }


}

public class Main{
    public static void main(String[] args){
        Tree t = new Tree();

        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);

        System.out.print(t.hasPathSum(15));
    }
}