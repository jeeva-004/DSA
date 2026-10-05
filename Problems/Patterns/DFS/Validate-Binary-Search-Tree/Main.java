class Tree {
    Node root;
    Tree(){
        root = null;
    }

    class Node{
        int val;
        Node right;
        Node left;

        Node(int val){
            this.val = val;
            right = left = null;
        }
    }

    public void insert(int val){
        root = insert(root, val);
    }

    public Node insert(Node root, int val){
        if(root==null)
            return new Node(val);
        
        if(val<root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        
        return root;
    }

    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }

    public boolean isValidBST(Node root){
        long min = Long.MIN_VALUE, max = Long.MAX_VALUE;

        return isValid(root, min, max);
    }

    public boolean isValid(Node node, long min, long max){
        boolean left = true, right = true;

        if(node!=null){
            if(node.val<=min || node.val>=max)
                return false;
            
            left = isValid(node.left, min, node.val);
            left = isValid(node.right, node.val, max);
        }

        return left && right;
    }
}

public class Main{
    public static void main(String[] args){
        Tree tree = new Tree();

        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        // tree.inOrder(tree.root);
        System.out.print(tree.isValidBST(tree.root));
    }
}