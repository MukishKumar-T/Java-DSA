class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BST {
    public static void main(String[] args) {
        Node node = new Node(10);
        Node left = new Node(6);
        Node right = new Node(14);

        node.left = left;
        node.right = right;

        left.left = new Node(3);
        left.right = new Node(8);

        right.left = new Node(12);
        right.right = new Node(16);

        if(searchBST(node, 12)) System.out.println("Found");
        else System.out.println("Not Found");
    }

    private static boolean searchBST(Node node, int target){
        if(node == null) return false;
        if(target < node.data) searchBST(node.left, target);
        if(target > node.data) searchBST(node.left, target);

        return true;
    }

    private static Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
        }
        if(data < root.data) root.left = insert(root.left, data);
        else if(data > root.data) root.right = insert(root.right, data);
        return root;
    }

}

