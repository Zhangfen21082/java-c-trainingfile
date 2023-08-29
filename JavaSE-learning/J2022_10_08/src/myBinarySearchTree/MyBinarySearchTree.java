package myBinarySearchTree;

public class MyBinarySearchTree {
    //节点定义
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode root;

    //查找
    public TreeNode search(int key){
        TreeNode cur = root;
        while(cur != null){
            if(key > cur.val){
                cur = cur.right;
            }else if(key < cur.val){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }

    //插入
    public Boolean insert(int key){
        TreeNode node = new TreeNode(key);
        //如果当前BST为空
        if(root == null){
            this.root = node;
            return true;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            if(key > cur.val){
                pre = cur;
                cur = cur.right;
            }else if(key < cur.val){
                pre = cur;
                cur = cur.left;
            }else{
                return false;//数据相同不能插入
            }
        }
        if(key > pre.val){
            pre.right = node;
        }else{
            pre.left = node;
        }
        return true;
    }

    //删除
    public void remove(int key){
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            if(key > cur.val){
                pre = cur;
                cur = cur.right;
            }else if(key < cur.val){
                pre = cur;
                cur = cur.left;
            }else{
                //找到待删除结点
                removeNode(cur, pre);
                return;
            }
        }
    }
    //删除结点方法
    private void removeNode(TreeNode cur, TreeNode pre) {
        //情况1：如果待删除的结点左子树为空
        if(cur.left == null) {
            if(cur == root){this.root = this.root.right;}//特殊情况：如果待删除结点本身就是根节点，那么直接让该结点的右结点作为根节点
            else{
                //正常情况下就让其父节点的左子树或者右子树指向待删除结点的右子树即可
                if(pre.left == cur){pre.left = cur.right;}
                if(pre.right == cur){pre.right = cur.right;}
            }
        //情况2：如果待删除的结点右子树为空
        }else if(cur.right == null){
            if(cur == root){this.root = this.root.left;}//特殊情况：如果待删除结点本身就是根节点，那么直接让该结点的左结点作为根节点
            else{
                //正常情况下就让其父节点的左子树或者右子树指向待删除结点的左子树即可
                if(pre.left == cur){pre.left = cur.left;}
                if(pre.right == cur){pre.right = cur.left;}
            }
        }
        //情况3：如果左右子树都不为空
        /*从待删除结点开始寻找其右子树的最左结点（用submin标记该结点，并用submin_pre标记该结点的父节点）
         然后把submin结点复制到cur处，接着再删除submin结点即可
         在这种情况下找到的submin一定满足左子树为空，所以删除submin时就等价于情况1
         */
        else{
            TreeNode submin_pre = cur;
            TreeNode submin = cur.right;
            while(submin.left != null){
                submin_pre = submin;
                submin = submin.left;
            }
            cur.val = submin.val;
            if(submin_pre.left == submin){
                submin_pre.left = submin.right;
            }else{
                submin_pre.right = submin.right;
            }
        }
    }


}
