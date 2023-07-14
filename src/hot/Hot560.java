package hot;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Hot560
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/21 19:50
 * @Version: 1.0
 */
public class Hot560 {

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3};
        int subarraySum = subarraySum2(nums, 3);
        System.out.println(subarraySum);
    }

    public int subarraySum(int[] nums, int k) {
        /**
         arr[i]表示nums中[0,i]之和
         */
        int res = 0;
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] - arr[j] == k) {
                    res++;
                }
            }
        }
        if (nums[0] == k) {
            res++;
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
