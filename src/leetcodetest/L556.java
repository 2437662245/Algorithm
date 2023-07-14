package leetcodetest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: L556
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/9 16:00
 * @Version: 1.0
 */
public class L556 {

    @Test
    public void test2() {
        int[] arr = new int[]{2,1,4,7,4,8,3,6,4,7};
        Arrays.sort(arr, 1, 3);
    }

    @Test
    public void test1() {
        String resStr = "2147483647";
        int res = 0;
        int len = resStr.length();
        for (int i = 0; i < len; i++) {
            res = res * 10 + (resStr.charAt(i) - '0');
        }
        System.out.println("res = " + res);
    }

    @Test
    public void test() {
        int nextGreaterElement = nextGreaterElement(2147483476);
        System.out.println(nextGreaterElement);
    }

    public int nextGreaterElement(int n) {
        /**
         思路：从后向前遍历，找到第一对顺序对，例如466124321，就找到24
         在2的后面找到 比2大的最小数3，将3放到原来2位置上，3后面的逆序放到原来2的后面，2和3之间的逆序放到最后
         */

        // 将n表示为字符串
        String str = String.valueOf(n);
        StringBuilder builder = new StringBuilder();
        int len = str.length();
        if (len < 2) {
            return -1;
        }
        int index = len - 2;
        while (index >= 0 && str.charAt(index) >=str.charAt(index + 1)) {
            index--;
        }
        // n中的数都是递减的，返回-1
        if (index == -1) {
            return -1;
        }
        // index位置是顺序对的前一个数 先将前面无需调整的部分添加到StringBuilder中
        builder.append(str.substring(0, index));
        // 处理后面需要调整的部分
        // 在index后面找到大于index处的最小数
        char c = str.charAt(index);
        int minIndex = index + 1;
        while (minIndex + 1 < len && str.charAt(minIndex) > c && str.charAt(minIndex + 1) > c) {
            minIndex++;
        }
        // 上面while循环完，minIndex处就是 index后面大于index处的最小数
        builder.append(str.charAt(minIndex));
        if (minIndex + 1 < len) {
            builder.append(new StringBuilder(str.substring(minIndex + 1, len)).reverse());
        }
        builder.append(new StringBuilder(str.substring(index, minIndex)).reverse());
        String resStr = builder.toString();
        int res = 0;
        len = resStr.length();
        for (int i = 0; i < len; i++) {
            res = res * 10 + (resStr.charAt(i) - '0');
            System.out.println(res);
        }
        return res;
    }
}
