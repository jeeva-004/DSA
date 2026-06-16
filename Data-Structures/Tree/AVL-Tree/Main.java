class AVLTree{
    Node root;
    public AVLTree(){
        root = null;
    }
    public AVLTree(int val){
        root =  new Node(val);
    }
    class Node{
        Node right, left;
        int height, val;
        Node(int val){
            right = left = null;
            this.val = val;
            this.height = -1;
        }
    }

    public void insert(int val){
        root = insert(root, val);
    }

    public Node insert(Node root, int val){
        if(root==null)
            return new Node(val);
        if(root.val>val){
            root.left = insert(root.left, val);
        }
        else if(root.val<val){
            root.right = insert(root.right, val);
        }
        else
            return root;

        // set hight for every root
        root.height = 1 + (Math.max(getHeight(root.left), getHeight(root.right)));

        //check balance factor
        int balanceFactor = getBalanceFactor(root);

        //LL Case
        if(balanceFactor>1&&val<root.left.val){
            return rightRotate(root);
        }
    
        //LR Case
        if(balanceFactor>1&&val>root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RR Case
        if(balanceFactor<-1&&root.right.val<val){
            return leftRotate(root);
        }

        //RL Case
        if(balanceFactor<-1&&root.right.val>val){
            root.right = rightRotate(root.right);
            return rightRotate(root);
        }

        return root;
    }

    public int getBalanceFactor(Node n){
        if(n==null)
            return 0;
        return getHeight(n.left)- getHeight(n.right);
    }

    public Node rightRotate(Node x){
        Node z = x.left;
        Node t4 = z.right;

        z.right = x;
        x.left = t4;

        x.height = 1 + (Math.max(getHeight(x.left),getHeight(x.right)));
        z.height = 1 + (Math.max(getHeight(z.left), getHeight(z.right)));

        return z;
    }

    public Node leftRotate(Node x){
        Node z = x.right;
        Node t3 = z.left;

        z.left = x;
        x.right = t3;

        x.height = 1 + (Math.max(getHeight(x.left), getHeight(x.right)));
        z.height = 1 + (Math.max(getHeight(z.left), getHeight(z.right)));

        return z;
    }


    public int getHeight(Node root){
        if(root==null)
            return -1;
        return root.height;
    }

    public void display(){
        display(root);
    }

    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(root.val+" ");
            display(root.right);
        }
    }

}


public class Main{
    public static void main(String[] args){
        AVLTree avltree = new AVLTree(48);
        avltree.insert(4);
        avltree.insert(5);
        avltree.insert(20);
        avltree.insert(90);
        avltree.insert(87);
        avltree.insert(99);
        avltree.display();
    }
}