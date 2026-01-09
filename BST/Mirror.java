package BST;

import java.util.ArrayList;

public class Mirror {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node createMirror(Node root){
         if (root == null) {
            return null;
         }

         Node leftMirror = createMirror(root.left);
         Node rightMirror = createMirror(root.right);

         root.left = rightMirror;
         root.right = leftMirror;

         return root; 
    }

    //print krne ke liye preorder 
    public static void preorder(Node root){
     if (root == null) {
        return;
     }
     System.out.print(root.data+" ");
     preorder(root.left);
     preorder(root.right);
    }

    //craete BST FOR SORTED FROM
    public static Node createBST(int arr[],int st,int end){
       if (st> end) {
        return null;
       }
       int mid = (st+end)/2;
       Node root = new Node(arr[mid]);
       root.left = createBST(arr, st, mid-1);
       root.right = createBST(arr,mid+1, end);
       return root;
    }

    //Inorder
    public static void getInorder(Node root,ArrayList<Integer> inorder){
       if (root == null) {
        return;
       }
       getInorder(root.left, inorder);
       inorder.add(root.data);
       getInorder(root.right, inorder);
     }
     //create BST 
     public static Node createBST(ArrayList<Integer> inorder,int st,int end){
        if (st > end) {
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
     }
        
      
    // BST TO BALANCE BST CONVERT
      public static Node balanceBST(Node root){
              ArrayList<Integer> inorder = new ArrayList<>();
              getInorder(root, inorder);
              //sorted inorder -> balanced BST
              root = createBST(inorder, 0, inorder.size()-1);
              return root;
      }


    public static void main(String[] args) {
    //     8 
    //    / \
    //   5   10
    //  / \    \
    // 3   6    11
        // Node root = new Node(8);
        // root.left= new Node(5);
        // root.right = new Node(10);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right.right = new Node(11);

        // root = createMirror(root);
        // preorder(root);

        // int arr[] = {3,5,6,8,10,11,12}; 
        // Node root = createBST(arr, 0, arr.length-1);
        // preorder(root);


        //BST TO BALANCE BST 
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left= new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right= new Node(12);
        root = balanceBST(root);
        preorder(root);
    }
}
