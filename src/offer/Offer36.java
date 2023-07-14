package offer;

import common.Node;
import common.TreeNode;
import org.junit.Test;

/**
 * @ClassName: Offer36
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/25 19:20
 * @Version: 1.0
 */
public class Offer36 {
    // 中序遍历，用pre记录上一个访问到的节点，建立本节点的上一个节点之间的关系
    Node preNode;
    Node startNode;
    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;

        Node node = treeToDoublyList(node4);
    }

    public Node treeToDoublyList(Node root) {
        // 寻找到最后一个节点
        preNode = root;
        while (preNode.right != null) {
            preNode = preNode.right;
        }
        startNode = root;
        while (startNode.left != null) {
            startNode = startNode.left;
        }
        dfs(root);
        return root;
    }

    public void dfs(Node node) {
        if (node == null || node == startNode) {
            return;
        }
        if (node.left != null) {
            dfs(node.left);
        }
        node.left = preNode;
        preNode.right = node;
        preNode = node;
        if (node.right != null) {
            dfs(node.right);
        }
    }
}
