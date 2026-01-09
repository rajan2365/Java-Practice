package Binarytree;

// yeh process dfs pe work krti hai!
public class Heigth {
   static class Node {
      int data;
      Node left, right;

      public Node(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
      }

   }
   // node ki height pta krna !

   public static int heigth(Node root) {
      if (root == null) {
         return 0;
      }
      int lh = heigth(root.left);
      int rh = heigth(root.right);
      return Math.max(lh, rh) + 1;
   }

   // count of nodes
   public static int count(Node root) {
      if (root == null) {
         return 0;
      }
      int leftCount = count(root.left);
      int rightCount = count(root.right);
      return leftCount + rightCount + 1;
   }

   // sum of nodes
   public static int sum(Node root) {
      if (root == null) {
         return 0;
      }
      int leftsum = sum(root.left);
      int rightSum = sum(root.right);
      return leftsum + rightSum + root.data;
   }

   // diamater od nodes  O(n2)

   public static int diamater(Node root) {
      if (root == null) {
         return 0;
      }

      int leftDiam = diamater(root.left);
      int leftHt = heigth(root.left);
      int rightDiam = diamater(root.right);
      int rightHt = heigth(root.right);

      int selfDiam = leftHt + rightHt + 1;

      return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
   }

   //second approach diameter  O(n)
      static class info {
      int diam;
      int ht;

      public info(int diam, int ht){
         this.diam = diam;
         this.ht = ht;
      }

   }
      public static info Diameter(Node root){
         if (root == null) {
            return new info(0, 0);
         }
         info leftInfo = Diameter(root.left);
         info rightInfo = Diameter(root.right);

         int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam) ,leftInfo.ht + rightInfo.ht + 1); 
         int ht = Math.max(leftInfo.ht, rightInfo.ht);

         return new info(diam,ht);
      
   }


   public static void main(String[] args) {
      // 1
      // / \
      // 2 3
      // / \ / \
      // 4 5 6 7

      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.right.left = new Node(6);
      root.right.right = new Node(7);
      // System.out.println(heigth(root));
      // System.out.println(count(root));
      // System.out.println(sum(root));
      System.out.println(diamater(root));
   }
}
