import com.sun.source.tree.Tree;

public class BinarySearchTree <E extends Comparable> {

    private class TreeNode{
        E value;
        TreeNode left;
        TreeNode right;

        public TreeNode(E value){
            this.value = value;
        }
    }

    private TreeNode root;


     boolean insert(E value) {

         if(this.search(value)){
             return false;
         };
       if(this.root == null){
           this.root = new TreeNode(value);
           this.root.value = value;
       }else{
           if(this.root.value.compareTo(value) < 0){
               if(this.root.left != null){
                   this.insert(value);
               }else{
                   this.root.left = new TreeNode(value);
               }
           }else{
               if(this.root.right !=null){
                   this.insert(value);
               }else{
                   this.root.right = new TreeNode(value);
               }
           }
       }
       return true;
     }


    boolean remove(E value){
         return false;
    }

    boolean search( E value) {
        boolean found = false;
        TreeNode node = root;

        while (!found && node != null) {
            if (node.value.compareTo(value) == 0) {
                found = true;
            } else if (node.value.compareTo(value) > 0) {
                node = node.right;
            }else{
                node = node.left;
            }
        }
        return found;
    }

    void display(String message){

    }

    int numberNodes(){
        return 2;
    }

    int numberLeafNodes(){
        return 2;
    }

    int height(){
     return this.findHeight(root);
    }

    public int findHeight(TreeNode node){
        //Check whether tree is empty
        if(node == null) {
            return 0;
        }
        else {
            int leftHeight = 0, rightHeight = 0;

            //Calculate the height of left subtree
            if(node.left != null)
                leftHeight = findHeight(node.left);

            //Calculate the height of right subtree
            if(node.right != null)
                rightHeight = findHeight(node.right);

            //Compare height of left subtree and right subtree
            //and store maximum of two in variable max
            int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;

            //Calculate the total height of tree by adding height of root
            return (max + 1);
        }
    }
}