import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree <E extends Comparable> {

    public class TreeNode {
        E value;
        TreeNode left;
        TreeNode right;

        public TreeNode(E value) {

            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

     boolean insert(E value) {

         if(this.search(value)){
             return false;
         };

         //this.root = this.insertNode(root, value);
         this.root = this.insertNode(this.root, new TreeNode(value));

       return true;
     }

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null)
            return node;
        TreeNode curr = root;
        while (true) {
            if (node.value.compareTo(curr.value) < 0) {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = node;
                    break;
                }
            } else if (node.value.compareTo(curr.value) > 0) {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = node;
                    break;
                }
            } else {
                curr.value = node.value;
                break;
            }
        }
        return root;
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
        System.out.println(message);
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
                System.out.println(node.value + " ");
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
        }
    }

    int numberNodes() {
         return countNode(this.root);
    }

    private int countNode(TreeNode node) {

        if (node == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);

        int count = 0;
        while (!queue.isEmpty())
        {
            TreeNode temp = queue.poll();

            count += 1;
            if (temp.left != null)
            {
                queue.add(temp.left);
            }

            if (temp.right != null)
            {
                queue.add(temp.right);
            }
        }
        return count ;
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

            if (temp.left == null && temp.right == null)
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

        if (node == null)
            return 0;

        Queue<TreeNode> q = new LinkedList();

        q.add(node);
        int height = -1;

        while (1 == 1)
        {
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;

            while (nodeCount > 0)
            {
                TreeNode newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }

    int findMax(int a, int b){
        if(a >= b)
            return a;
        else
            return b;
    }
}