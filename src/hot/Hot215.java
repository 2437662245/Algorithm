package hot;

import org.junit.Test;

import java.util.Random;

/**
 * @ClassName: Hot215
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/14 20:21
 * @Version: 1.0
 */
public class Hot215 {


    @Test
    public void test2() {
        Random random = new Random(3);
        System.out.println(random.nextInt());
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }


    // 在数组的 start-end 范围内找第k 大的数
    public int findKthLargest(int[] nums, int k) {
        /**
         排序后第k大的数，index为num.length-k
         寻找排序后，index为k位置上的数
         快排思想 时间复杂度可O(n)
         */
        int target = nums.length - k;    // 第k大的数在数组中有序时的位置
        int start = 0;
        int end = nums.length - 1;

        while (true) {
            int pivotIndex = quickSort(nums, start, end);
            if (pivotIndex == target) {
                return nums[target];
            } else if (pivotIndex > target) {
                end = pivotIndex - 1;
            } else {
                start = pivotIndex + 1;
            }
        }
    }

    // 在nums左闭右闭区间(left, right)之间随机选择一个数，将其放到有序时应该待的位置上，并将此下标返回
    public int quickSort(int[] nums, int left, int right) {
        // Random(n) 随机返回一个[0, n)的数 这里要选择一个[left, right]之间的数
        Random random = new Random();
        int randIndex = random.nextInt(right - left + 1) + left;
        // 随机选中了randIndex位置的数，现在要将此数的位置定下来 先将其交换到left位置
        swap(nums, randIndex, left);
        int pivot = nums[left];
        int i = left + 1;
        int j = right;

        // 对向双指针，右往左找比left处小的，左往右找比left处大的，找到后交换
        while (true) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        // 此时i处就是left位置的数应该在的位置，交换left与i处的值
        swap(nums, left, i);
        return i;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}