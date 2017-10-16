package HackerRank.dataStructures.trees;

/**
 * Created by PDeb on 10/16/2017.
 */
public class SelfBalancingTree {

    static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    static Node insert(Node root,int val)
    {
        if(root==null){
            Node node = new Node();
            node.val = val;
            node.left = null;
            node.right = null;
            node.ht = 0;
            return node;
        }

        if(val < root.val)
            root.left = insert(root.left, val);
        else if(val > root.val)
            root.right = insert(root.right, val);
        else
            return root;

        root.ht = 1 + Math.max(height(root.left), height(root.right));

        int balanceFactor = getBalanceFactor(root);
        if(balanceFactor > 1 && val < root.left.val)
            return rightRotate(root);
        if(balanceFactor < -1 && val > root.right.val)
            return leftRotate(root);
        if(balanceFactor > 1 && val > root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balanceFactor < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = Math.max(height(x.left), height(x.right))+1;
        y.ht = Math.max(height(y.left), height(y.right))+1;
        return y;
    }


    private static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.ht = Math.max(height(y.left), height(y.right))+1;
        x.ht = Math.max(height(x.left), height(x.right))+1;
        return x;
    }

    private static int getBalanceFactor(Node root) {
        return height(root.left)-height(root.right);
    }

    private static int height(Node node) {
        if(node == null)
            return -1;
        return node.ht;
    }
}

/*Class node is defined as :*/
class Node {
    int val;   //Value
    int ht;      //Height
    Node left;   //Left child
    Node right;   //Right child
}

