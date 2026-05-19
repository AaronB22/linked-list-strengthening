public class Exercises {
    /**
     * Returns a count of how many nodes are in the linked list.
     * 
     * Returns 0 if head is null.
     * 
     * Example: 
     * Input: 9 -> 2 -> 10 -> 1
     * Output: 4
     * 
     * @param head the head of the linked list
     * @return the length of the list
     */
    public static int length(ListNode head) {
        int count=0;
        ListNode current=head;
        while(current!=null){
            current=current.next;
            count++;
        }
        return count;
    }

    /**
     * Adds a new value to the front of the list and returns the new head.
     * 
     * Example:
     * head: 7 -> 6 -> 0
     * toAdd: 4
     * 
     * Output: 4 -> 7 -> 6 -> 0
     * 
     * @param head the head of the linked list
     * @param toAdd the value to add to the front
     * @return the new head of the linked list
     */
    public static ListNode prepend(ListNode head, int toAdd) {
        ListNode newNode= new ListNode(toAdd);
        if(head==null){
            return newNode;
        }
        newNode.next=head;
       return newNode;
    }

    /**
     * Removes the last element in the linked list and returns the head.
     * 
     * If head is null or the only element in the list, returns null.
     * 
     * Example:
     * Input: 6 -> 4 -> 9 -> 2
     * Output: 6 -> 4 -> 9
     *  
     * @param head the head of the linked list
     * @return the head of the list with the last element removed
     */
    public static ListNode removeLast(ListNode head) {
        ListNode current=head;

        while(current!=null){
            if (current.next==null){
                return null;
            }
            if(current.next.next==null){
                current.next=null;
                return head;
            }
            current=current.next;
        }
        return head;
    }

    /**
     * Returns the minimum value in the linked list, or Integer.MAX_VALUE if
     * head is null.
     * 
     * Example:
     * Input: 3 -> -4 -> 9 -> 2
     * Output: -4
     * 
     * @param head the head of the linked list
     * @return the minimum value in the list 
     */
    public static int min(ListNode head) {
        if(head==null){
            return Integer.MAX_VALUE;
        }
        int lowest=head.data;
        while(head!=null){
            if(head.data<lowest){
                lowest=head.data;
            }
            head=head.next;
        }
        return lowest;
    }

    /**
     * Removes the first instance of the node with the minimum value from the
     * list and returns the head. If head is null or the only element in the list,
     * returns null.
     * 
     * Examples:
     * Input: 3 -> 9 -> 0 -> -1 -> 5
     * Output: 3 -> 9 -> 0 -> 5
     * 
     * Input: 2 -> 4 -> 2 -> 9
     * Output: 4 -> 2 -> 9
     * 
     * HINT: use min as a helper method
     * 
     * @param head the head of the linked list
     * @return the head of the list with the first instance of the minimum value removed
     */
    public static ListNode removeMin(ListNode head) {

        if(head==null){
            return null;
        }
        int lowest= min(head);

        ListNode current= head;
        while(current!=null){
            if(current.next==null){
                return null;
            }
            if(current.next.data==lowest){
                current.next=current.next.next;
                return head;
            }
            if(current.data==lowest){
                head=head.next;
            }
            current=current.next;
        }
        return head;
    }

    /**
     * Returns whether two lists are of equal length AND each value in bigList is double
     * that of the corresponding value in smallList. Returns false otherwise.
     * 
     * If BOTH lists are null, returns true.
     * 
     * Example:
     * smallHead: 4 -> 3 -> 9
     * bigHead:   8 -> 6 -> 18
     * Output: true
     * 
     * smallHead: 4 -> 3 -> 9
     * bigHead:   8 -> 6 -> 7
     * Output: false
     * 
     * 
     * @param smallHead the head of the list with the half values
     * @param bigHead the head of the list with the doubled values
     * @return whether the values in bigList are twice the values in smallList
     */
    public static boolean isDoubled(ListNode smallList, ListNode bigList) {
        if(smallList==null && bigList==null){
            return true;
        }
        if(smallList==null||bigList==null){
            return false;
        }
        while (smallList!=null) {
            if(smallList.data*2!=bigList.data){
                return false;
            }
            if((smallList.next==null&&bigList.next!=null)||(smallList.next!=null&&bigList.next==null)){
                return false;
            }
            smallList=smallList.next;
            bigList=bigList.next;
        }
        return true;
    }

    /**
     * Rotates a list by k elements to the left and returns the new head.
     * 
     * If head is null, return null.
     * 
     * Example:
     * head: 1 -> 2 -> 3 -> 4 -> 5
     * k: 2
     * Output: 3 -> 4 -> 5 -> 1 -> 2
     * 
     * @param head the head of the linked list
     * @param k the number of positions to rotate
     * @return the head of the new list after k rotations to the left
     */
    public static ListNode rotateLeft(ListNode head, int k) {
        ListNode current=head;
        ListNode newHead= head;
        int count=0;
        while(current!=null){
            if(count==k){
                newHead=current.next;
            }
            current=current.next;
            if(current==null||current!=newHead){
                current=head;
                head=head.next;
            }
        }
        return newHead;
    }
}
