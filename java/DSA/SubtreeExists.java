public class SubtreeExists{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    } 
    public static Node findSubroot(Node root,Node subRoot){
        if(root == null){
            return null;
        }
        if(root.data == subRoot.data){
            return root;
        }
        if(subRoot.data < root.data){
            root.left = findSubroot(root.left,subRoot);
        }
        else{
            root.right = findSubroot(root.right,subRoot);
        }

        return root;
    }

    public static boolean checkIdentical(Node root,Node subRoot){
       if(root == null && subRoot == null){
        return true;
       }
       if(root == null || subRoot == null || root.data != subRoot.data){
        return false;
       }
       if(!checkIdentical(root.left, subRoot.left)){
        return false;
       }
       if(!checkIdentical(root.right, subRoot.right)){
        return false;
       }
        
       return true;
    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(checkIdentical(root, subRoot)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public static void main(String args[]){
        /* 
                 1
                / \
               2   3
              / \ / \
             4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*      2
               / \
              4   5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
            if(isSubtree(root,subRoot)){
                System.out.println("SUBTREE EXISTS..!");
            }else{
                System.out.println("SUBTREE DOESNOT EXISTS");
            }

    }
    
}
