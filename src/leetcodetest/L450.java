package leetcodetest;

import common.TreeNode;
import org.junit.Test;

/**
 * @ClassName: L450
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/29 10:34
 * @Version: 1.0
 */
public class L450 {

    @Test
    public void test() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;
        TreeNode deleteNode = deleteNode(node5, 5);
        System.out.println(deleteNode.val);
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 1.查找值为key的节点
        TreeNode dummyRoot = new TreeNode();
        dummyRoot.left = root;
        TreeNode nodeParent = dummyRoot;
        TreeNode node = root;

        while (node != null && node.val != key) {
            nodeParent = node;
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (node == null) {
            return null;
        }
        // 2.删除node节点 两种实现方式 ①去左子树上找值最大的节点代替自己，②去右子树上找值最小的节点代替自己
        // 2.1 node是叶子节点
        // 2.2 如果node左子树为空 去右子树找最小值节点minNode 将其值赋给node，并删除minNode
        if (nodeParent.left == node) {
            nodeParent.left = delRoot(node);
        } else if (nodeParent.right == node){
            nodeParent.right = delRoot(node);
        }
        return dummyRoot.left;
    }

    // 删除二叉搜索树的根节点root
    public TreeNode delRoot(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        }
        TreeNode parent = root;
        // 如果右子树为空去左子树寻找值最大的节点
        if (root.right == null) {
            TreeNode leftMaxNode = root.left;
            while (leftMaxNode.right != null) {
                parent = leftMaxNode;
                leftMaxNode = leftMaxNode.right;
            }
            root.val = leftMaxNode.val;
            if (root.left == leftMaxNode) {
                parent.left = delRoot(leftMaxNode);
            } else {
                parent.right = delRoot(leftMaxNode);
            }
        } else {
            // 右子树不为空 去右子树寻找值最小的节点
            TreeNode rightMinNode = root.right;
            while (rightMinNode.left != null) {
                parent = rightMinNode;
                rightMinNode = rightMinNode.left;
            }
            root.val = rightMinNode.val;
            if (rightMinNode == root.right) {
                parent.right = delRoot(rightMinNode);
            } else {
                parent.left = delRoot(rightMinNode);
            }
        }
        return root;
    }
}
