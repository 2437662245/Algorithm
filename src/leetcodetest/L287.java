package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L287
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/14 19:48
 * @Version: 1.0
 */
public class L287 {

    @Test
    public void test() {
        int[] nums = new int[]{2,5,9,6,9,3,8,9,7,1};
        int duplicate = findDuplicate(nums);
        System.out.println("duplicate = " + duplicate);
    }

    public int findDuplicate(int[] nums) {

        /**
         原地hash

         */
        int next = 0;
        while (true) {
            int cur = nums[next];
            next = nums[cur];
            if (nums[cur] == cur) {
                return cur;
            }
            nums[cur] = cur;
        }
    }
}
