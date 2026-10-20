import java.util.*;

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
        
        if (r.val < val)
            r.right = insert(r.right, val);
        else if (r.val > val)
            r.left = insert(r.left, val);
        else
            return r;

        return r;
    }

    public List<Integer> leftSideView(Node root){
        List<Integer> result = new ArrayList<>();

        if(root==null)
            return result;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){    
            int levelSize = queue.size();

            for(int i = 0; i<levelSize; i++){
                Node node = queue.poll();
                
                if(i==levelSize-1)
                    result.add(node.val);

                if(node.left!=null)
                    queue.offer(node.left);

                if(node.right!=null)
                    queue.offer(node.right);
            }
        }

        return result;       
    }

}

public class Main{
    public static void main(String[] args){
        Tree tree = new Tree();

        tree.insert(5);
        tree.insert(6);
        tree.insert(3);
        tree.insert(4);
        
        System.out.print(tree.leftSideView(tree.root));

    }
}