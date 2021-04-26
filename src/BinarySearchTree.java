import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree <E extends Comparable> {

    private class TreeNode {
        E value;
        TreeNode left;
        TreeNode right;

        public TreeNode(E value) {
            this.value = value;
        }
    }

    private TreeNode root;

     boolean insert(E value) {

         if(this.search(value)){
             return false;
         };

         this.root = this.insertNode(this.root, new TreeNode(value));

       return true;
     }

    private TreeNode insertNode(TreeNode currentParent, TreeNode newNode) {

        if (currentParent == null) {
            return newNode;
        } else if (newNode.value.compareTo(currentParent.value) > 0) {
            currentParent.right = insertNode(currentParent.right, newNode);
        }
        else {
            currentParent.left = insertNode(currentParent.left, newNode);
        }

        return currentParent;
    }


    boolean remove(E value){
         this.root = this.removeNode(root, value);
         return true;

    }

    private TreeNode removeNode(TreeNode node, E value)
    {
        if (node == null)
            return null;

        if (node.value.compareTo(value ) > 0) {
            node.left = removeNode(node.left, value);
        } else if (node.value.compareTo(value ) < 0) {
            node.right = removeNode(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null)
                return node.left;

            node.value = inOrderSuccessor(node.right);
            node.right = removeNode(node.right, node.value);
        }

        return node;
    }

    public E inOrderSuccessor(TreeNode node) {
        E minimum = node.value;

        while (node.left != null) {
            minimum = node.left.value;
            node = node.left;
        }
        return minimum;
    }

    boolean search( E value) {
        boolean found = false;

        TreeNode node = root;

        while (!found && node != null) {
            if (node.value.compareTo(value) == 0) {
                found = true;
            } else if (node.value.compareTo(value) < 0) {
                node = node.right;
            }else{
                node = node.left;
            }
        }
        return found;
    }

    void display(String message){
        this.printLevelOrder(root);
    }

    private void printLevelOrder(TreeNode parentNode)
    {

        if(parentNode == null)
            return;

        Queue<TreeNode> q =new LinkedList<TreeNode>();
        q.add(parentNode);

        while(true)
        {
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;

            while(nodeCount > 0)
            {
                TreeNode node = q.peek();
                System.out.print(node.value + " ");
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    int numberNodes(){
        return countNode(root);
    }

    private int countNode(TreeNode node) {
        if(node == null)
            return 0;

        return 1 + countNode(node.left) + countNode(node.right);
    }

    int numberLeafNodes() {
         return getLeafCount(root);
    }

    int getLeafCount(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();

        int count = 0;
        q.add(node);
        while (!q.isEmpty())
        {
            TreeNode temp = q.peek();
            q.poll();

            if (temp.left != null)
            {
                q.add(temp.left);
            }
            if (temp.right != null)
            {
                q.add(temp.right);
            }
            if (temp.left == null &&
                    temp.right == null)
            {
                count++;
            }
        }
        return count;
    }

    int height() {
        return this.findHeight(root);
    }


    public int findHeight(TreeNode node){
        if(node == null)
            return -1;

        return findMax(findHeight(node.left), findHeight(node.right)) + 1;
    }

    int findMax(int a, int b){
        if(a >= b)
            return a;
        else
            return b;
    }
}