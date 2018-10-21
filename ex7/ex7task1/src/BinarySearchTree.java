/*
  BinarySearchTree.java
  Simple Binary Search Tree with keys of type int and data of type Object
*/

class BinarySearchTree
{
    public BinarySearchTree ()
    {}

    public boolean isEmpty () {
		return root == null;
    }

    /*
       Insert new node with key to tree; doesn't have to handle
       duplicate keys (you can assume that the user will use different 
       keys)
    */
    public void insert (int key, Object data) {
		var node = new BinaryTreeNode(key,data);
		var cursor = root;
		if(cursor == null){
			root = node;
			return;
		}
		while (true){
		    if(cursor.key < node.key){
		        if(cursor.right != null){
		            cursor = cursor.right;
                }else{
		            cursor.right = node;
		            break;
                }
            }else {
		        if(cursor.left!= null){
		            cursor = cursor.left;
                }else {
		            cursor.left = node;
		            break;
                }
            }
        }
    }

    /*
      Finds data of node with key, returns null if key is not found.
    */
    public Object find (int key) {
		/* exercise */
		var cursor = root;
		while (cursor != null){
			if(key == cursor.key){
				break;
			}else if(cursor.key > key){
				cursor = cursor.left;
			}else {
				cursor = cursor.right;
			}
		}
		if(cursor != null){
			return cursor.data;
		}else {
			return null;
		}
    }

    /*
      Deletes node with key, returns false if deletion is unsuccessful 
      (e.g. node is not found)
    */
    public boolean delete (int key) {
		/* exercise */
		var cursor = root;
		BinaryTreeNode prev = null;
		while (cursor != null){
			if(cursor.key == key){
				break;
			}else if(cursor.key > key) {
				prev = cursor;
				cursor = cursor.left;
			}else {
				prev = cursor;
				cursor = cursor.right;
			}
		}
		if(cursor == null){
			return false;
		}
		//remove k and its child's from tree;
		if(prev == null){
			root = null;

		}else if(prev.left != null && (prev.left.key == cursor.key)){
			prev.left = null;
		}else {
			prev.right = null;
		}
		//insert sub tree back
		insertRecursive(cursor.left);
		insertRecursive(cursor.right);
		return true;
    }

    private void insertRecursive(BinaryTreeNode node){
    	if(node == null){
    		return;
		}
		insert(node.key,node.data);
    	insertRecursive(node.left);
    	insertRecursive(node.right);
	}
    private BinaryTreeNode root;


    /* Consistency check of tree order */
    public boolean checkTreeOrder () {
		return checkTreeOrderRec (root, 
				  java.lang.Integer.MIN_VALUE,
				  java.lang.Integer.MAX_VALUE);
    }
    
    private boolean checkTreeOrderRec (BinaryTreeNode n, int low, int high) {
		boolean result = true;
		if (n != null) {
			if ((n.key <= low) || (n.key >= high)) {
				System.out.println ("ERROR in tree order: should be " + low + " < " + n.key + " < " + high + ".");
				result = false;
			}
			else {
				result = checkTreeOrderRec (n.left,    low, n.key)
				    && checkTreeOrderRec (n.right, n.key, high);
			}
		}
		return result;
    }
}
