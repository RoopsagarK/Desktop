public class LinkedList{
    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
//initialize head and tail
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int indx, int data){
        if(indx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        int i=0;
        Node temp = head;
        while(i != indx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = tail.data;
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next=null;
        tail = temp;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            i++;
            temp = temp.next;
        }

        return -1;
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeFromEnd(int n){
        int i = 1;
        if(n == 1 ){
            removeLast();
            return;
        }else if(n == size){
            removeFirst();
            return;
        }
        Node temp = head;
        while(i < size-n){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public Node findMid(){
        //Slow-Fast or Turtle-Hare approach
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node mid = findMid();
        //reversing only second half of the LL
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; //head of right half of the LL
        Node left = head;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(2, 3);
        ll.printList();
        System.out.println("Removed element from last : " + ll.removeLast());    
        ll.printList();
        System.out.println("Removed element from first  : " + ll.removeFirst());  
        ll.printList();
        System.out.println("Size of the LinkedList : " + size);
        System.out.println("Found at position : " + ll.itrSearch(2));
        System.out.println("Found at position : " + ll.itrSearch(10)); 
        ll.reverse();
        System.out.println("Reverse List : " );
        ll.printList();
        ll.removeFromEnd(2);
        ll.printList();
        ll.addLast(4);
        ll.printList();
        System.out.println(ll.checkPalindrome());  
        ll.addFirst(7);
        ll.printList();
        System.out.println(ll.checkPalindrome()); 

    }
}
/*OUTPUT:
 * 1->2->3->4->5->null
Removed element : 5
1->2->3->4->null
Removed element  : 1
2->3->4->null
Size of the LinkedList : 3
Found at position : 0
Found at position : -1
Reverse List :
4->3->2->null
4->2->null
4->2->4->null
true
7->4->2->null
false
 */