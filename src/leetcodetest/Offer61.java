package leetcodetest;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/25 21:09
 */
public class Offer61 {

    @Test
    public void offer61Test() {
        int[] arr = new int[]{1,2,12,0,3};
        System.out.println(isStraight(arr));
        HashSet set = new HashSet();
    }

    public boolean isStraight(int[] nums) {
        // 若干副：数字可重复 大小王可以看作任意数字
        Arrays.sort(nums);
        // 记录有几个0
        int count0 = 0;

        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == 0) {
                count0++;
                i++;
            } else if (nums[i] == nums[i + 1] - 1){
                i++;
            } else if (nums[i] == nums[i + 1] || (nums[i + 1] - nums[i] > count0 + 1)) {
                return false;
            } else {
                nums[i]++;
                count0--;
            }
        }
        return true;
    }
}
