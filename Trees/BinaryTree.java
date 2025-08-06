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

public class BinaryTree {
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
    }
}