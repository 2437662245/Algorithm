package leetcodetest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: L347
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/18 13:49
 * @Version: 1.0
 */
public class L347 {

    @Test
    public void test() {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] frequent = topKFrequent(nums, k);
    }

    public int[] topKFrequent(int[] nums, int k) {
        // HashMap+优先级队列

        int[] res = new int[k];
        int index = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 大顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry entry : map.entrySet()) {
            pq.add(entry);
        }

        for (int i = 0; i < k; i++) {
            res[index++] = pq.poll().getKey();
        }
        return res;
    }
}
