import java.util.*;
class Main {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = Create();
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);

    }
    static int height(Node root) {
        if (root == null)
            return 0;  // height of empty tree is 0

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static Node Create() {
        Node root = null;
        System.out.println("Enter Value");
        int data = sc.nextInt();
        if (data == -1)
            return null;
        root = new Node(data);
        System.out.println("Enter Left tree Data");
        root.left = Create();
        System.out.println("Enter Right Tree Data");
        root.right = Create();
        return root;

    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {

        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}