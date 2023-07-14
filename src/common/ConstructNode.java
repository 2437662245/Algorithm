package common;

import org.junit.Test;

/**
 * @ClassName: ConstructNode
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/25 19:40
 * @Version: 1.0
 */
public class ConstructNode {

    @Test
    public void TestTreeNode() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
    }
}
