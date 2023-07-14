package leetcodetest;

import common.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: ZJ662
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/30 17:34
 * @Version: 1.0
 */
public class ZJ662 {
    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        int width = widthOfBinaryTree(node1);
        System.out.println(width);

    }
    public int widthOfBinaryTree(TreeNode root) {
        // 层序遍历
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        boolean flag = true;
        while (flag) {
            flag = false;    // 标记队列中是否还有有效元素
            int level = -1;
            int sz = deque.size();
            for (int i = 0; i < sz; i++) {
                TreeNode temp = deque.pollFirst();
                if (temp != null) {

                    // 区间左边的节点，从这儿开始计数
                    if (level == -1) {
                        level = 1;
                    } else {
                        // 区间右边的节点，统计宽度，并将level置0，因为后面可能还会产生区间
                        res = Math.max(res, ++level);
                    }
                    deque.offerLast(temp.left);
                    deque.offerLast(temp.right);
                    if (temp.left != null || temp.right != null) {
                        flag = true;
                    }
                } else if (temp == null) {
                    // 遇到空节点，并且正在统计宽度
                    if (level != -1) {
                        level++;
                    }
                    deque.offerLast(null);
                    deque.offerLast(null);
                }
            }
        }
        return res;
    }
}
