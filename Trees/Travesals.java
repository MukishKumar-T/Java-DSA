import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node right, left;

    Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    Node(int val){
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class Travesals {
    public static void main(String[] args) {
        Node node = new Node(1, null, null);
        Node left = new Node(2, null, null);
        Node right = new Node(3);

        node.left = left;
        node.right = right;

        left.left = new Node(4);
        left.right = new Node(5);

        right.left = new Node(6);
        right.right = new Node(7);

        // levelOrder(node);
        // System.out.println(maxDepth(right, 0));
        // lastNodeAtEachLevel(node);
        dfsByStack(node);
    }

    public void inorder(Node root){
        if(root == null) return;

        inorder(root.left);             
        System.out.println(root.data);    //Preorder (root, left, right)  
        inorder(root.right);              //Postorder (left, right, root)
    }

    public static void levelOrder(Node root){
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node node = q.peek();
                
                q.remove();

                System.out.print(node.data + " ");

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            System.out.println();
        }
    }

    public static int maxDepthByDFS(Node root){
        if(root == null) return 0;

        if(root.left == null) return 1 + maxDepthByDFS(root.right);
        if(root.right == null) return 1 + maxDepthByDFS(root.left);

        return 1 + Math.max(maxDepthByDFS(root.left), maxDepthByDFS(root.right));
    }

    public static int minDepthByDFS(Node root){
        if(root == null) return 0;

        if(root.left == null) return 1 + minDepthByDFS(root.right);
        if(root.right == null) return 1 + minDepthByDFS(root.left);

        return 1 + Math.min(minDepthByDFS(root.left), minDepthByDFS(root.right));
    }

    public static void lastNodeAtEachLevel(Node root){   //Right View
        if(root == null) return;

        // List<Integer> ans = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        
        q.add(root);

        // int lev = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node node = q.peek();

                if(i == size-1){                            //Left View (i == 0)
                    System.out.println(node.data);
                    // ans.add(node.data);
                }
                q.remove();


                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            // lev++;
        }
    }

    public static void dfsByStack(Node root){
        if(root == null) return;

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();

            System.out.print(node.data);

            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
    }
}
