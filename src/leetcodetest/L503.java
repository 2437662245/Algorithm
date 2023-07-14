package leetcodetest;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName: L503
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/18 14:57
 * @Version: 1.0
 */
public class L503 {

    @Test
    public void test() {
        int[] nums = new int[]{1,2,1};
        int[] elements = nextGreaterElements(nums);
        System.out.println(elements);
    }

    public int[] nextGreaterElements(int[] nums) {
        /**

         单调递减栈 栈底->栈顶 单调递减 栈中存放num的index
         当前值比栈顶代表元素大时，栈中比当前小的元素的 下一个更大元素 可以确定 就是当前元素
         因为要循环搜索，所以遍历两边nums
         */
        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < len * 2; i++) {
            // 如果当前元素比栈顶元素大
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peekFirst()]) {
                // res中栈顶位置确定
                res[stack.pollFirst()] = nums[i % len];
            }
            stack.offerFirst(i % len);
        }
        return res;
    }
}
