package Trie;

public class Uniquesub {
      static class Node{
        Node[] children = new Node[26];
        boolean eow;
        public Node(){
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
     }
     public static Node root = new Node();

      //insert--------------------------------
     public static void inset(String word){ 
        int level = 0;
        int len = word.length();
        int idx = 0;
        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
     }

     //search -------------
     public static boolean search(String key){
       int level= 0;
       int len = key.length();
        int idx = 0;
        Node curr = root;
        for (; level < len; level++) {
            idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow = true;

    }

    //final code
    public static int countNodes(Node root){
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {  //BST KI TRH SBPE SIDE BY SIDE JAYEGA ! 
             if (root.children[i] != null) {
                count += countNodes(root.children[i]);  //esse sare ke sare substrin nikl ke aa jayege! 
             }
        }
        return count+1;
    }

    public static void main(String[] args) {
        String str = "apple";

        //suffix -> insert in Trie 
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);   //eska mtlb i se cut kr dega ! 
            inset(suffix); //add kr diya Trie me 

        }
        System.out.println(countNodes(root));
    }
}