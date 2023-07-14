package hot;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Hot239
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/16 13:43
 * @Version: 1.0
 */
public class Hot239 {

    @Test
    public void test2() {

    }


    @Test
    public void test() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        for (int num : ints) {
            System.out.print(num);
            System.out.print(" ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         借助 头->尾 非严格递减队列 双端队列
         当前元素
         <= 队尾：
         直接入队
         > 队尾：
         从队尾处 小于自己的数都出队 自己再入队

         滑动窗口：
         右边界右移 对于此右边界元素 处理在队列中逻辑
         左边界右移
         =队头元素
         队头出队
         != 队头
         队列不动
         */
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int resIndex = 0;   // 结果数组res的index
        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;
        int right = 0;  // 滑动窗口左右边界

        // 初次形成窗口
        for (; right < k; right++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(nums[right]);
        }
        res[0] = deque.peekFirst();

        while (right < len - 1) {
            // 窗口左边界先右移，需要检查队头是否需要出队
            if (nums[left] == res[right - k]) {
                deque.pollFirst();
            }
            left++;
            // 窗口右边界右移
            right++;
            // 右边界入栈
            while(!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(nums[right]);
            res[right - k + 1] = deque.peekFirst();
        }

        return res;
    }
}
