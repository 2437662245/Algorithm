package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Offer45
 * @Author: zh
 * @DateTime: 2022/12/6 21:53
 * @Description:
 */
public class Offer45 {

    @Test
    public void test() {
        int[] nums = new int[]{3,30,34,5,9};
        minNumber(nums);
        Scanner sc = new Scanner(System.in);
    }

    public String minNumber(int[] nums) {
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = Integer.valueOf(nums[i]);
        }
        Arrays.sort(newNums, (a, b) -> (String.valueOf(a) + String.valueOf(b)).compareTo(String.valueOf(b) + String.valueOf(a)));

        StringBuilder builder = new StringBuilder();
        for (Integer num : newNums) {
            builder.append(num);
        }
        return builder.toString();
    }
}
