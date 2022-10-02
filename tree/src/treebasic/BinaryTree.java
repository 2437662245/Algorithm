package treebasic;

public class BinaryTree {
    // 先序遍历 递归
    public void preOrder(BinaryTreeNode root) {
        if(root!=null) {
            System.out.println(root.getVal());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    // 中序遍历 递归
    public void inOrder(BinaryTreeNode root) {
        if(root!=null) {
            preOrder(root.getLeft());
            System.out.println(root.getVal());
            preOrder(root.getRight());
        }
    }
    // 后序遍历 递归
    public void postOrder(BinaryTreeNode root) {
        if(root!=null) {
            preOrder(root.getLeft());
            preOrder(root.getRight());
            System.out.println(root.getVal() + "\t");
        }
    }

    /*
    *  非递归需要用一个stack来模拟递归时的函数调用。
    *  对于三种非递归遍历，都使用push当前节点->push左子树->pop左子树->push右子树->pop右子树的方式。但是sout时机会有所不同。
    * */
    // 先序遍历 非递归 push当前节点->push左子树->pop左子树->push右子树->pop右子树
    public void preOrderNoRecursive(BinaryTreeNode root) {
        /*
        * 声明一个stack s
        * 根节点入栈s.push(root)
        *
        * */
    }

}
