package hot;

/**
 * @author: joe
 * @dateTime: 2023/3/2 20:40
 * @description: TODO
 * @version: 1.0
 */

public class Hot33 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        search(arr, 0);
    }
    public static int search(int[] nums, int target) {
        // 二分
        int left = 0;
        int right = nums.length - 1;
        int len = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // target更大  target可能在左半段，也可能在右半段
                // 比右半段最大的还大 在做半段
                if (target > nums[len - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // target更小 如果比左半段最小值小 说明在右半段
                if (target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
