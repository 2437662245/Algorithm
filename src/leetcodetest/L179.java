package leetcodetest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: L179
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/5 12:24
 * @Version: 1.0
 */
public class L179 {

    @Test
    public void test() {
        int[] nums = new int[]{34323,3432};
        System.out.println(largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        Integer newNums[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // 自定义排序规则，排序之后拼接
        Arrays.sort(newNums, (num1, num2) -> {
            // 两个数比较的方式为：从首位开始比起 转为字符串比较
            String str1 = String.valueOf(num1);
            String str2 = String.valueOf(num2);
            int index1 = 0;
            int index2 = 0;
            while (index1 < str1.length() || index2 < str2.length()) {
                if (str1.charAt(index1) > str2.charAt(index2)) {
                    return -1;
                } else if (str1.charAt(index1) < str2.charAt(index2)) {
                    return 1;
                } else {
                    // 二者相等 没有到达字符串尾部的继续+1，到达尾部的不动，都到达尾部返回1或-1都可以
                    if (index1 == str1.length() - 1 && index2 == str2.length() - 1) {
                        return 1;
                    }
                    if (index1 < str1.length() - 1) {
                        index1++;
                    }
                    if (index2 < str2.length() - 1) {
                        index2++;
                    }
                }
            }
            return 1;
        });

        StringBuilder builder = new StringBuilder();
        for (Integer num : newNums) {
            builder.append(num);
        }
        return builder.toString();
    }
}
