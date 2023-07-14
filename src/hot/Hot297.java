package hot;

import common.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Hot297
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/17 16:03
 * @Version: 1.0
 */
public class Hot297 {

    Codec codec = new Codec();

    @Test
    public void testSerialize() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize.val);
    }

    @Test
    public void test2() {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(null);
    }
}

/**
 * Definition for a binary tree node.
*/

class Codec {

    /**
     编码:
     将二叉树的层序遍历 编码为字符串 编码格式为 val, val, n, ...
     null节点记为n
     解码:
     将字符串切分之后 构造树
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            TreeNode tempNode = deque.pollFirst();
            if (tempNode == null) {
                sb.append("n");
            } else {
                sb.append(tempNode.val);
                deque.offerLast(tempNode.left);
                deque.offerLast(tempNode.right);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        TreeNode root = buildNode(strs[0]);
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        int strsIndex = 1;

        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            node.left = buildNode(strs[strsIndex++]);
            node.right = buildNode(strs[strsIndex++]);
            if (node.left != null) {
                deque.offerLast(node.left);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
            }
        }
        return root;
    }

    public TreeNode buildNode(String str) {
        return "n".equals(str) ? null : new TreeNode(Integer.valueOf(str));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
