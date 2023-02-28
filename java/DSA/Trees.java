import java.util.Queue;
import java.util.LinkedList;
public class Trees {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public class BinaryTree{
        static int idx = -1;
        public  static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void Levelorder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();

                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
            
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            int height = Math.max(lh,rh) + 1;
            return height;
        }

        public static int count(Node root){
            // int count = 0;
            // if(root == null){
            //     return 0;
            // }
            // Queue<Node> q = new LinkedList<>();
            // q.add(root);
            
            // while(!q.isEmpty()){
            //     Node currNode = q.remove();
            //         count++;
            //         if(currNode.left != null){
            //             q.add(currNode.left);
            //         }
            //         if(currNode.right != null){
            //             q.add(currNode.right);
            //         } 
            // }
            // return count;
            if(root == null){
                return 0;
            }
            int lc = count(root.left);
            int rc = count(root.right);

            int TreeCount = (lc + rc)+1;

            return TreeCount;
        }

        public static int sumOfNodes(Node root){
            //RECURSIVE APPROACH

            // if(root == null){
            //     return 0;
            // }
            // int ls = sumOfNodes(root.left);
            // int rs = sumOfNodes(root.right);

            // int sum = ls + rs + root.data;

            // return sum;

            //ITERATIVE APPROACH USING LEVELORDER
            if(root == null){
                return 0;
            }
            int sum = 0;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                sum += currNode.data;
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                        q.add(currNode.right);
                    } 
            }
            return sum;
        }
        public static int maxDia = 0;
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int lf = diameter(root.left);
            int rf = diameter(root.right);

            int dia = lf + rf + 1;
            maxDia = Math.max(maxDia, dia);
            
            return maxDia;
        }
    }
    public static void main(String[] args){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTree.buildTree(nodes);
        BinaryTree.Levelorder(root);     
        System.out.println("Height = " + BinaryTree.height(root));   
        System.out.println("Tree Count = " + BinaryTree.count(root));   
        System.out.println("Sum Of Nodes = " + BinaryTree.sumOfNodes(root)); 
        System.out.println("Daimeter = " + BinaryTree.diameter(root)); 
               
    }
}

