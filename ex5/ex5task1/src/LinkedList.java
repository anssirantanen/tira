/* Simple linked list that contains ints. The last node has null in the 
   reference to next and head is the reference to the first node in the list
   or null if the list is empty */

class LinkedList
{
    public LinkedList ()
    {
	this.head = null;
    }

    /* returns true, if the list is empty, else false */
    public boolean isEmpty ()
    {
	return head == null;
    }

    /* returns the first element of the list, assuming that the list is not empty */
    public int front ()
    {
	return head.data;
    }

    /* prints the list */
    public void print ()
    {
	System.out.print("(");
	for (ListNode i = head; i != null; i = i.next)
	    System.out.print(i.data + " ");
	System.out.println(")");
    }

    /* inserts x into the beginning of the list */
    public void insertFront (int x) {
        var node = new ListNode();
        node.data = x;
        node.next = head;
        head = node;
    }

    /* returns true, if x is in the list, else false */
    public boolean find (int x){
        var cursor = head;
        while(cursor != null){
            if(cursor.data == x){
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }

    /* removes the first occurrence of x from the list and returns true
       if the removal was successful. In the case of unsuccesful removal
       (i.e. list is empty of x is not in the list) returns false */
    public boolean delete (int x) {
        ListNode prev = null;
        var cursor = head;
        while (cursor != null){
            if(cursor.data == x){
                if(prev==null){
                    head = cursor.next;
                }else {
                    prev.next = cursor.next;
                }
                return true;
            }else{
                prev = cursor;
                cursor = cursor.next;
            }
        }
        return false;
    }

    /* sorts the list in ascending order */
    public void sort () {
        ListNode cursor = null;
        if(head != null){
            cursor = head.next;
            head.next = null;
        }
        while (cursor != null){
          var current = cursor;
          cursor = cursor.next;
          current.next =null;
          insertAsc(current);
        }
    }
    public void insertAsc(ListNode node){
        var cursor = head;
        ListNode prev = null;
        while (cursor != null){
            if(node.data < cursor.data){
                if(prev != null){
                    prev.next = node;
                }else {
                    head = node;
                }
                node.next = cursor;
                return;
            }
            if(cursor.next == null){
                cursor.next = node;
                return;
            }
            prev = cursor;
            cursor = cursor.next;
        }
    }

    
    public ListNode head;
}
