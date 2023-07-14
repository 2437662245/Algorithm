package leetcodetest;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: L440
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/29 15:15
 * @Version: 1.0
 */
public class L440 {

    @Test
    public void test() {
        int kthNumber = findKthNumber(13, 2);
        System.out.println(kthNumber);
    }

    public int findKthNumber(int n, int k) {
        // 第1个数
        int curr = 1;
        // 已经确定1个最小数了，k--
        k = k - 1;
        // 去找当前第k个字典序最小数
        while (k > 0) {
            // 计算当前前缀到下一个前缀之间的step数 1-2之间的数个数
            int steps = getSteps(n, curr, curr + 1);
            // 前缀间距太大，需要深入一层
            if (steps > k) {
                // 往孩子走
                curr *= 10;
                // 多了一个确定节点，k继续-1
                k -= 1;
            } else {
                // 间距太小，需要扩大前缀范围 往右兄弟节点走
                curr += 1;
                k -= steps;
            }
        }
        return curr;
    }

    private int getSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
