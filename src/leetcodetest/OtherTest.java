package leetcodetest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName: OtherTest
 * @Description:
 * @Author: zh
 * @DateTime: 2022/12/2 15:23
 * @Version: 1.0
 */
public class OtherTest {


    @Test
    public void test() {
        int[] nums = new int[]{1,1,1,2,2,3};
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry> pq = new PriorityQueue<>((a, b) -> (Integer) b.getValue() - (Integer) a.getValue());
        Set<Map.Entry<Integer, Integer>> entries = freqMap.entrySet();
    }

}
