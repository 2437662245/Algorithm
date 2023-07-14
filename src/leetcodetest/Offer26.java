package leetcodetest;

import common.TreeNode;
import org.junit.Test;

/**
 * @ClassName: Offer26
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/7 16:40
 * @Version: 1.0
 */
public class Offer26 {

    @Test
    public void test() {
        TreeNode A = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        A.left = node1;
        A.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node3.right = node8;

        TreeNode B = new TreeNode(4);
        TreeNode nodeB1 = new TreeNode(8);
        TreeNode nodeB2 = new TreeNode(9);
        B.left = nodeB1;
        B.right = nodeB2;

        System.out.println(isSubStructure(A, B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 递归在A中寻找与B的值相等的节点，递归A左，B左、A右，B右
        if (A == null || B == null) {
            return false;
        }
        boolean res = false;
        if (A.val == B.val) {
            res = res || helper(A, B);
        }
        return res || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean helper(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
