package hot;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Hot347
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/20 13:49
 * @Version: 1.0
 */
public class Hot347 {

    @Test
    public void test() {














        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>(
            // 按照value降序排序
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return 0;
                }
            }
        );

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (index < k) {
                res[index++] = e.getKey();
            } else {
                break;
            }
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        /**
         Map+堆
         Map统计词频
         小根堆
         */
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1] < t1[1] ? 1 : -1;
            }
        });


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }
}
