package leetcodetest;

/**
 * Auther: zh
 * DateTime: 2022/3/30 19:49
 * Description:
 */
public class TreeNode {
    int val;
    leetcodetest.TreeNode left;
    leetcodetest.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, leetcodetest.TreeNode left, leetcodetest.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
