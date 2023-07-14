package common;

/**
 * @ClassName: Node
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/25 19:20
 * @Version: 1.0
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
