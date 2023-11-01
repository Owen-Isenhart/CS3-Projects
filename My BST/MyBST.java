
/**
 * Write a description of class MyBST here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyBST
{
    int count = 4;
    BSTNode root;
    private class BSTNode{
        Integer val;
        BSTNode left, right;
        public BSTNode(Integer val){
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString(){
            return "" + this.val;
        }
    }

    public int size(){
        return size(root);
    }

    int size(BSTNode node)
    {
        if (node == null) //at the end
            return 0;
        else
            return (size(node.left) + 1 + size(node.right)); //checks left and right recrusively adding one
    }

    public void insert(Integer n){
        this.root = insert(root, n);
    }

    public BSTNode insert(BSTNode root, Integer n) {
        if (root == null) { //node is empty
            root = new BSTNode(n);
            return root;
        }
        else if (root.val >= n) { //current node's value is more than n so it goes left
            root.left = insert(root.left, n);
        } else { //current nodes value is less than n so it goes right
            root.right = insert(root.right, n);
        }
        return root;
    }

    public boolean contains(Integer n){
        return contains(root, n);
    }

    public boolean contains(BSTNode root, Integer n){
        if (root == null) //at the end, val hasn't been found
            return false;
        if (root.val == n) //found it
            return true;
        else if (root.val >= n){ //current node's val is more than desired
            return contains(root.left, n);
        }
        else{ //current node's val is less than desired
            return contains(root.right, n);
        }
    }

    public Integer getMax(){
        return getMax(root);
    }

    public Integer getMax(BSTNode root){
        if (root.right == null){ //if next to the right is null, return current val
            return root.val;
        }
        else{
            return getMax(root.right); //otherwise, go to the right where numbers are bigger
        }
    }

    public Integer getMin(){
        return getMin(root);
    }

    public Integer getMin(BSTNode root){
        if (root.left == null){ //if next left is null, return current val because it can't go lower
            return root.val;
        }
        else{
            return getMin(root.left); //otherwise, go to the left where numbers are smaller
        }
    }

    public void delete(Integer n){
        if (contains(n)){
            delete(root, null, n, 0);
        }
    }

    public void delete(BSTNode root, BSTNode parent, Integer n, int leftOrRight){

        if (parent != null){ //once a parent is found
            if (root.val == n && root.left == null && root.right == null){ //leaf
                if (leftOrRight == 1)
                    parent.left = null;
                else{
                    parent.right = null;
                }
            }
            else if (root.val == n && root.left != null && root.right == null){ //left sub
                if (leftOrRight == 1)
                    parent.left = root.left;
                else{
                    parent.right = root.left;
                }

            }
            else if (root.val == n && root.right != null && root.left == null){ //right sub
                if (leftOrRight == 1)
                    parent.left = root.right;
                else{
                    parent.right = root.right;
                }

            }
            else if (root.val == n && root.left != null && root.right != null){ //two subs
                int temp = getMin(root.right); //saves the smallest value of the right subtree
                delete(root.right.val); //deltes right value
                root.val = temp; //sets current root value to deleted value, thus replacing the current node

            }
        }
        else{
            if (root.val >= n){
                if (root.left.val == n)
                    parent = root; //current node is above the desired node
                if (parent == null)
                    delete(root.left, parent, n, 0); //keeps going to the left
                else
                    delete(root.left, parent, n, 1);
            }
            else{
                if (root.right.val == n)
                    parent = root;
                if (parent == null)
                    delete(root.right, parent, n, 0); //keeps going to the right
                else
                    delete(root.right, parent, n, 2);
            }
        }

    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(BSTNode root){
        if (root != null) { //prints all the left first, then all the right
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public void print(){
        print (root, 0);

    }

    public void print(BSTNode root, int s){

        if (root == null)
            return;
        s += count; //spaces in between nums is increases deeper into one subtree it goes

        print(root.right, s); //have to do right ones first

        System.out.print("\n");
        for (int i = count; i < s; i++) //prints the spaces
            System.out.print(" ");
            
        System.out.print(root.val); 
        System.out.println();

        print(root.left, s); //does the left values now, since they're at the bottom in this format
    }
}


