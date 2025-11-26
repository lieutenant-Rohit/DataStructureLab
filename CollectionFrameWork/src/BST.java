import java.util.Scanner;

public class BST {
    static Scanner s = null;
    public static void main(String[] args) {
        s = new Scanner(System.in);
        System.out.println("Enter values > 0 if you want to quit press -1");
        Node root = null;
        while(true)
        {
            int data = s.nextInt();
            if(data == -1)
                break;
            root = create(root,data);
        }
        inorder(root);


    }

    static  Node create(Node root , int val)
    {
        if(root == null)
            return  new Node(val);
        if(root.val>val)
            return root.left = create(root.left,val);
        else
            return root.right = create(root.right,val);
    }

    static void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.println(root.val+"->");
        inorder(root.right);
    }
}

class Node
{
    int val;
    Node left;
    Node right;

    Node(int val)
    {
        this.val = val;
    }
}
