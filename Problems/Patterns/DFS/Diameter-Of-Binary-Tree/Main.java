class Tree{
    Node root;
    int diameter = 0;
    Tree(){
        root = null;
    }

    Tree(int val){
        Node node = new Node(val);
        root = node;
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
    //diameter = longest path between any two nodes
    public int diameterOfBinaryTree(Node r){
        findDiameter(r);
        return diameter;
    }

    public int findDiameter(Node r){
        int height = 0;

        if(r==null)
            return 0;

        int left = findDiameter(r.left);
        int right = findDiameter(r.right);

        diameter = Math.max(diameter, left+right);

        return 1 + Math.max(right, left);
    }
}


public class Main{
    public static void main(String[] args){
        Tree tree = new Tree(1);

        tree.insert(2);   
        tree.insert(3);   
        tree.insert(4);   
        tree.insert(5);

        System.out.print(tree.diameterOfBinaryTree(tree.root));   
    }
}