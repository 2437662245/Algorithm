package leetcodetest;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName: L189
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/30 20:54
 * @Version: 1.0
 */
public class L189 {

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4,5,6};
        int[] copyOf = Arrays.copyOf(nums, 2);
        rotate(nums, 3);
        System.out.println("ok");
    }

    public void rotate(int[] nums, int k) {
        /**
         1. 借助数组
         2. 原地移动
         1 2 3 4 5 6 7

         */
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        int index = 0;
        int nextVal = nums[0];
        int count = 0;
        int start = 0;
        while (count < nums.length) {
            // index 当前元素(index + k) % nums.length位置去，先暂存此位置的值
            int nextIdx = (index + k) % nums.length;
            int temp = nums[nextIdx];
            nums[nextIdx] = nextVal;
            nextVal = temp;
            index = nextIdx;
            // 将当前值 放置到对应位置之后，计数器+1
            count++;
            if (index == start) {
                index++;
                nextVal = nums[index];
                start = index;
            }
        }
    }
}
