package myBinaryTree;

import java.util.*;

public class MyBinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    //根节点
    public TreeNode root;
    public int i = 0;

    //根据字符串序列创建二叉树（字符串序列表示某二叉树的先序遍历序列，例如ABC##DE#G##F###,其中
    //#表示空格，代表空树）
    public TreeNode createTree(String str){
        TreeNode root = null;
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else{
            i++;
        }
        return root;
    }

    //前序遍历-递归实现
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + "；");
        preOrder(root.left);
        preOrder(root.right);
    }

    //前序遍历-非递归实现
    public void preOrderNoRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();//临时栈
        TreeNode cur = root;
        //遇到结点就访问然后入栈，并转向左节点
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(root.val + "：");
                stack.push(cur);
                cur = cur.left;
            }
            //循环停止时，走到了最左面的结点
            TreeNode tmp = stack.peek();
            stack.pop();
            //如果它没有右节点，那么就继续出下一个结点
            //如果它有右节点，那么右节点进入循环，然后入栈再重复
            cur = tmp.right;
        }
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.println(root.val + "；");
        preOrder(root.right);
    }

    //中序遍历-非递归实现
    public void inOrderNoRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode tmp = stack.peek();
            stack.pop();
            System.out.println(tmp.val + "：");

            cur = tmp.right;
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val + "；");
    }

    //后序遍历-非递归实现
    //将前序遍历改为“根右左”，然后再反转结果，就是后序遍历
    public void postOrderNoRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(root.val + "：");
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode tmp = stack.peek();
            stack.pop();
            cur = tmp.left;

            // Collections.reverse(ret);

        }
    }

    //获取树中结点的个数
    public int treeSize(TreeNode root) {
        if(root == null) return 0;
        return treeSize(root.left) + treeSize(root.right) + 1;
    }

    //获取树中叶子结点个数
    public int treeLeafNodeSize(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return treeLeafNodeSize(root.left) + treeLeafNodeSize(root.right);
    }

    //求第k层结点个数
    public int theNumOfk(TreeNode root, int k){
        if(root == null) return 0;
        if(k == 1) return 1;
        return theNumOfk(root.left, k-1) + theNumOfk(root.right, k-1);
    }

    //获取二叉树高度
    public int treeHeight(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 :rightHeight + 1;
     }

     //判断某个元素是否存在
    public TreeNode find(TreeNode root, char val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode find_left = find(root.left, val);
        if (find_left != null) return find_left;
        TreeNode find_right = find(root.right ,val);
        if(find_right != null) return find_right;
        return null;
    }

    //层次遍历
    public void levelTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>(); //借助队列实现
        TreeNode temp;
        queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.println(temp.val + ":");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.left != null){
                queue.offer(temp.right);
            }
        }
    }
}
