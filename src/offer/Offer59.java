package offer;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/24 22:19
 */
public class Offer59 {

    public static void main(String[] args) {
        Offer59Solution offer59Solution = new Offer59Solution();
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        offer59Solution.maxSlidingWindow(arr, 3);
    }
}

class Offer59Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 怎么确定窗口中的最大值？ 如果当前右边界的值比结果数组中上一个数大 那么当前右边界的就是最大值
        // 如果当前右边界比结果数组中上一个数小 那么就需要从窗口左边比过来
        int[] result = new int[nums.length - k + 1];

        int left = 0, right = 0, index = 0, max = Integer.MIN_VALUE;


        while (right - left <= k - 1) {   // 右边界未到达数组最右端时循环
            max = Math.max(max, nums[right++]);
        }
        result[index++] = max;

        while (right < nums.length) {
            left++;
            if (nums[right] >= result[index]) {
                result[index++] = nums[right];
            } else {
                // 需要从left比过来
                max = Integer.MIN_VALUE;
                for (int i = left; i <= right; i++) {
                    max = Math.max(max, nums[i]);
                }
                result[index++] = max;
            }
            right++;
        }
        return result;
    }
}
