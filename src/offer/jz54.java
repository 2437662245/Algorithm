package offer;

import common.TreeNode;
import org.junit.Test;

/**
 * @ClassName: jz54
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/14 17:18
 * @Version: 1.0
 */
public class jz54 {

    @Test
    public void test() {
        Solution54 solution54 = new Solution54();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println("solution54.kthLargest(node1, 1) = " + solution54.kthLargest(node1, 1));
    }
}
class Solution54 {
    int res;
    public int kthLargest(TreeNode root, int k) {
        // 寻找中序遍历的第k个节点值
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        // 遇到叶子节点返回
        if (root == null) {
            return;
        }
        if (root.right != null) {
            dfs(root.right, k);
        }
        if (1 == k) {
            res = root.val;
            return;
        }
        k++;
        if (root.left != null) {
            dfs(root.left, k);
        }
    }
}
