package leetcodetest;

import org.junit.Test;

import java.util.Random;

/**
 * @ClassName: L215
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/19 20:22
 * @Version: 1.0
 */
public class L215 {

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int largest = findKthLargest(nums, k);
        System.out.println(largest);
    }

    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;

        while (true) {
            int left = quickSort(nums, start, end);
            if (left == k - 1) {
                return nums[left];
            } else if (left < k - 1) {
                start = left + 1;
            } else {
                end = left - 1;
            }
        }
    }

    private int quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        int left = start, right = end;

        int pivot = rand.nextInt(right - left + 1) + left;
        int key = nums[pivot];
        swap(nums, pivot, left);

        //int key = nums[left]; 这句话是之前的写法 效率很慢 改用随机数来作为基数

        while (left < right) {
            while (left < right && nums[right] <= key) {
                right--;
            }

            while (left < right && nums[left] >= key) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, start, left);
        return left;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
