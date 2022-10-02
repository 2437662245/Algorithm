package leetcodetest;

import org.junit.Test;

import java.util.Arrays;

/**
 * Auther: zh
 * DateTime: 2022/3/30 19:48
 * Description: 思路有问题
 */
public class L98 {

    @Test
    public void test() {
        TreeNode node0 = new TreeNode(120);
        TreeNode node1 = new TreeNode(70);
        TreeNode node2 = new TreeNode(140);
        node0.left = node1;
        node0.right = node2;
        TreeNode node3 = new TreeNode(50);
        TreeNode node4 = new TreeNode(100);
        TreeNode node5 = new TreeNode(130);
        TreeNode node6 = new TreeNode(160);
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeNode node7 = new TreeNode(20);
        TreeNode node8 = new TreeNode(55);
        TreeNode node9 = new TreeNode(75);
        TreeNode node10 = new TreeNode(110);
        TreeNode node11 = new TreeNode(119);
        TreeNode node12 = new TreeNode(135);
        TreeNode node13 = new TreeNode(150);
        TreeNode node14 = new TreeNode(200);
        node3.left = node7;
        node3.right = node8;
        node4.left = node9;
        node4.right = node10;
        node5.left = node11;
        node5.right = node12;
        node6.left = node13;
        node6.right = node14;
        System.out.println(isValidBST(node0));
    }

    public boolean isValidBST(TreeNode root) {
        // 思路：递归从下向上验证。当前节点大于左子树的最大值 小于右子树的最小值 合法返回当前树的最大最小值
        // 递归函数返回值及参数 int[] Helper(Node)
        int[] arr = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] resArr =  Helper(root, arr);
        if (resArr[0] != Integer.MAX_VALUE && resArr[1] != Integer.MIN_VALUE) {
            return true;
        } else {
            return false;
        }

    }

    public int[] Helper(TreeNode node, int[] arr) {
        // 递归终止条件:叶子节点
        if (node.left == null && node.right == null) {
            return new int[]{node.val, node.val};
        } else {
            int[] arr1 = Arrays.copyOf(arr, 2);
            if (node.left != null) {
                // 如果当前节点值比左子树的最大值小
                if (node.val <= Helper(node.left, arr)[1]) {
                    arr1[0] = Integer.MAX_VALUE;
                    arr1[1] = Integer.MIN_VALUE;
                } else {
                    arr1[0] = arr[0];
                }
            }
            if (node.right != null) {
                // 如果当前节点值 >= 右子树最小值
                if (node.val >= Helper(node.right, arr)[0]) {
                    arr1[0] = Integer.MAX_VALUE;
                    arr1[1] = Integer.MIN_VALUE;
                } else {
                    arr1[1] = arr[1];
                }
            }
            return arr1;
        }

        // 如果不是叶子节点 当前节点值要大于左子树最大值，小于右子树最小值，如果符合则返回当前树的最小最大值组成的数组，否则返回Integer最大最小值组成的数组


    }
}


