package hot;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Hot621
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/21 14:41
 * @Version: 1.0
 */
public class Hot621 {

    @Test
    public void test() {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        leastInterval(tasks, 2);
    }

    public int leastInterval(char[] tasks, int n) {
        // 统计任务种数及其执行次数
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int[] values = new int[map.size()];
        int index = 0;
        for (int value : map.values()) {
            values[index++] = value;
        }

        int res = 0;
        while (true) {
            // exe: 自己执行之后，又经过的时间片自己执行不算，下一个执行才开始算cd
            int exe = -1;
            for (int i = 0; i < values.length; i++) {
                if (values[i] > 0) {
                    values[i]--;
                    exe++;
                    res++;
                }
                if (exe == -1) {
                    return res;
                }
            }
            res += (n - exe) > 0 ? (n - exe) : 0;
        }
        // return res;
    }
}
