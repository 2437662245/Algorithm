package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L862
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/10 13:42
 * @Version: 1.0
 */
public class L862 {

    @Test
    public void test() {
        int[] arr = new int[]{1,93,5,54,47,-7,23,-28,-9,43};
        int k = 193;
        int subarray = shortestSubarray(arr, k);
        System.out.println("subarray = " + subarray);
    }

    public int shortestSubarray(int[] nums, int k) {
        /**
         此子数组的一个明显特征是，子数组两端一定是：大于0的，因为k>0，两端如果小于0，那小于0的部分都可以舍去
         所以考虑使用两个数组时间换空间，
         将元素组中的负数折叠到前面的前面的正数上，
         一个数组记录当前位置折叠后的数是多少，
         另一个数组记录当前折叠的数是由几个数组成的，方便统计长度
         使用两个List来实现，需要频繁插入删除，所以使用LinkedList
         */

        // List<Integer> numList = new LinkedList<>();
        // List<Integer> countList = new LinkedList<>();

        // for (int i = 0; i < nums.length; i++) {

        //     // nums[i] > 0, 则直接放入List, 记录组成当前数元素个数的 list 要同步进行操作
        //     if (nums[i] > 0) {
        //         numList.add(nums[i]);
        //         countList.add(1);
        //     } else {
        //         // 如果当前数 <= 0, 将当前数和前一个数进行折叠
        //     }

        // }

        // 非正数先丢弃 因为一定用不上
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0) {
                break;
            } else {
                nums[i] = 0;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            // 当前数大于0时，正常向后，不做动作
            if (nums[i] > 0) {
                continue;
            } else {
                // 当前数<0时，将当前数和前面的数进行折叠，具体实现就是，将当前数值0，加到前面的数上，直到前面的数>0或者到index=0的位置
                int j = i;
                while (j > 0 && nums[j] < 0 && nums[j - 1] >= 0) {
                    nums[j - 1] += nums[j];
                    nums[j] = 0;
                    j--;
                }

            }
        }

        // 使用滑动数组寻找最短子数组 忽略前面的负数和0，从正数开始
        int left = 0;
        int sum = 0;
        int res = nums.length + 1;
        while (left < nums.length && nums[left] <= 0) {
            left++;
        }
        int right = left;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            if (sum < k) {
                continue;
            }
            while (sum - nums[left] >= k) {
                sum -= nums[left];
                left++;
            }
            res = Math.min(res, right - left);
        }
        return res;
    }
}
