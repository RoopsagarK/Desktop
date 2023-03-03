import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class FrontNBttmView {
    public static class Node{
        int data;
        Node left;
        Node right;
        int hd;
        public Node(int data){
            this.data = data;
        }
    }
    public static class Info{
        Node node;
        int hd;
        public Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void bttmView(Node root){
        Queue<Info> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Info info = new Info(root, 0);
        q.add(info);
        HashMap<Integer, Node> map = new HashMap<>();
        while(!q.isEmpty()){
            Info currInfo = q.remove();
                // if(!map.containsKey(currInfo.hd)){
                    map.put(currInfo.hd, currInfo.node);
                    min = Math.min(min, currInfo.hd);
                    max = Math.max(max, currInfo.hd);
                //}   
            if(currInfo.node.left != null){
                q.add(new Info(currInfo.node.left,currInfo.hd-1));
            }
            if(currInfo.node.right != null){
                q.add(new Info(currInfo.node.right, currInfo.hd+1));
            }
        }
        System.out.print("Bottom view : ");
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Info info = new Info(root, 0);
        q.add(info);
        HashMap<Integer, Node> map = new HashMap<>();
        while(!q.isEmpty()){
            Info currInfo = q.remove();
                if(!map.containsKey(currInfo.hd)){
                    map.put(currInfo.hd, currInfo.node);
                    min = Math.min(min, currInfo.hd);
                    max = Math.max(max, currInfo.hd);
                }   
            if(currInfo.node.left != null){
                q.add(new Info(currInfo.node.left,currInfo.hd-1));
            }
            if(currInfo.node.right != null){
                q.add(new Info(currInfo.node.right, currInfo.hd+1));
            }
        }
        System.out.print("Top view : ");
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        topView(root);
        System.out.println();
        bttmView(root);
        
    }
}
/*
 * OUTPUT : 
 * Top view : 2 1 3 6    
 * Bottom view : 2 4 5 6 
 */
