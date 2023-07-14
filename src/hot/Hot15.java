package hot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/10/1 22:18
 */
public class Hot15 {


    @Test
    public void test() {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 排序+双指针 双指针 从后向前 固定最后一个 前面使用对向双指针
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();    // 结果集

        if (nums.length < 3) {
            return res;
        }

        for (int i = nums.length - 1; i >= 2; i--) {
            // 对前面元素使用双指针 看是否有二元素之和 = -nums[i]
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else if (nums[left] + nums[right] + nums[i] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);
                    res.add(list);
                    right--;    // 继续寻找
                }
            }
        }
        return res;
    }
}
