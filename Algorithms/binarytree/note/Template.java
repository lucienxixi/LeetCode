package binarytree.note;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Template {
    // preorder recursion
    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);   // 在遍历过程中需要做的操作应该在递归函数前进行。
        preorder(root.left);
        preorder(root.right);
    }

    // inorder recursion
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);   // 在遍历过程中需要做的操作应该在两个递归函数之间进行。
        inorder(root.right);
    }

    //postorder recursion
    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);   // 在遍历过程中需要做的操作应该在两个递归函数之后进行。
    }

//    // divide and conquer recursion
//    private 返回结果类型 divideConquer(TreeNode root) {
//        if (root == null) {
//            处理空树应该返回的结果;
//        }
//
//        // 如果叶子节点返回的结果可以根据叶子节点的两个空节点返回得到，那么可以省略这段代码。很多情况这段代码都可以省略
//        if (root.left == null && root.right == null) {
//            处理叶子节点应该返回的结果;
//        }
//
//        左子树返回的结果 = divideConquer(root.left);
//        右子树返回的结果 = divideConquer(root.right);
//        整棵树的结果 = 按照一定方法合并左子树和右子树的结果;
//
//        return 整棵树的结果;
//    }


    // preorder iteration (non-recursion)
    /* 模板1: 根节点存入栈中打印根节点，然后访问这个根节点的左子树，左子树也是将左子树的根存入栈中打印根节点，依次往下直到左子树为空，再取出栈顶元
     * 素，栈顶元素(访问完左子树的根节点)作为新的根节点去访问右子树。
     */
    private void preorderNonRecursion1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();//用一个栈来存放树中的节点
        while(root != null || !stack.isEmpty()) {//只要当前节点不为空(即当前节点的左右子树没有访问完毕)或者栈中还有节点(还有节点没有访问)
            while (root != null) {//一直往左走
                stack.push(root);//根节点入栈
                System.out.println(root.val);//打印根节点
                root = root.left;//访问左子树
            }
            root = stack.pop();//取出根节点
            root = root.right;//访问右子树
        }
    }
   /* 模板2： 我们知道前序遍历遵从根左右的顺序，所以我们打印根节点，并将它的右子树，左子树按照顺序压入栈中，每次只取出栈顶的一个节点，这样就可以保
    * 证所有的左子树都会在右子树之前取出并打印。
    *
    * 跟BFS模板很像，把queue换成stack，然后先把右节点压入栈中
    */
    private void preorderNonRecursion2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)//树为空
            return;
        stack.add(root);//将根节点压入栈中
        while(!stack.isEmpty()){//只要栈不为空，执行循环
            TreeNode node = stack.pop();//取出栈顶元素打印，此时的栈顶元素是以node为根的子树的根
            System.out.println(node.val);
            if(node.right != null)//将右子树压入栈中
                stack.push(node.right);
            if(node.left != null)//将左子树压入栈中
                stack.push(node.left);
        }
    }


    // inorder iteration (non-recursion)
    // 根前序遍历方法一思路一样，不同的只是先不打印根节点，而是先访问左子树，再打印根节点，访问右子树。
    public void inorderNonRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {//只要当前节点不为空(即当前节点的左右子树没有访问完毕)或者栈中还有节点(还有节点没有访问)
            while (root != null) {
                stack.push(root);//根节点入栈
                root = root.left;//访问左子树
            }
            root = stack.pop();//取出左子树的根节点
            System.out.println(root.val);//打印根节点
            root = root.right;//访问右子树
        }
    }


    // postorder iteration (non-recursion)
    // 模板一：常规遍历左右根，和前序、中序方法一类似。
    private void postorderNonRecursion1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                //访问左子树
                stack.push(node);
                node = node.left;
            }
            //判断栈顶元素(根)
            node = stack.peek();
            //1.如果此时的根的右子树为空node.right == null
            //2.如果此时的根的右子树已经访问过了node.right == prev(prev记录的是上次访问打印的节点)
            if (node.right == null || node.right == prev) {
                //打印根节点，并出栈，将打印过的节点从栈中删除
                stack.pop();
                System.out.println(node.val);
                //记录prev，表示以当前prev为根的子树已经访问过了
                prev = node;
                //node置null就不会再次访问以node为根节点的左右子树，这里的node既然已经打印，说明它的左右子树早已访问完毕
                node = null;
            } else {
                //访问右子树
                node = node.right;
            }
        }
    }

        /* 模板2：和前序遍历的方法二类似，我们可以用一个线性表存放后序遍历的结果。我们知道后序遍历是左右根，但是我们可以反过来，一样先访问根，只
        是将根放在后边然后访问右子树放在根的前边左子树的后边，我们可以用线性表头插来实现这个操作，先访问根再右子树再左子树，只是每次都对线性表进行
        头插，这样最后的结果就还是左右根。
         */
        public List<Integer> postorderNonRecusion2(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new LinkedList<>();
            if(root == null)
                return list;
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(0, node.val);//头插此时根节点
                if(node.left != null)
                    stack.push(node.left);
                if(node.right != null)
                    stack.push(node.right);
            }
            return list;
        }
}
