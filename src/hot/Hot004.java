package hot;

/**
 * @author: joe
 * @dateTime: 2023/2/28 19:44
 * @description: TODO
 * @version: 1.0
 */

public class Hot004 {

    public static void main(String[] args) {
        int[] num1 = new int[]{2};
        int[] num2 = new int[]{1,3,4};
        findMedianSortedArrays(num1, num2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //
        int lengthSum = nums1.length + nums2.length;
        if (lengthSum % 2 == 1) {
            return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, lengthSum / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, lengthSum / 2) +
                    findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, lengthSum / 2 + 1)) / 2.0;
        }
    }

    // 在nums1[start1, end1]和nums2[start2, end2]中寻找第k小的数
    public static int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        // 将短数组放到第一个
        if (end1 - start1 > end2 - start2) {
            return findKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        // nums1可能无元素
        if (end1 < start1) {
            return nums2[start2 + k - 1];
        }
        // 如果求第1小的数，直接返回两个数组中的最小值
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // 求两个数组中的第k小的数
        /**
         x x x x x
         x x x x x x x x
         */
        // 每次可以排除k / 2个数 比较start1+count和start2+count位置的数 哪个小的可以排除
        int count = Math.min(k / 2, end1 - start1 + 1);  // 本次比较可以排除的数
        int index1 = start1 + count - 1;;
        int index2 = start2 + count - 1;
        if (nums1[index1] <= nums2[index2]) {
            // 排除nums1中index1前面的数
            return findKth(nums1, start1 + count, end1, nums2, start2, end2, k - count);
        } else {
            return findKth(nums1, start1, end1, nums2, start2 + count, end2, k - count);
        }
    }
}