package hot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Hot483
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/22 21:40
 * @Version: 1.0
 */
public class Hot483 {

    @Test
    public void test() {
        findAnagrams("baa", "aa");
    }

    public List<Integer> findAnagrams(String s, String p) {
        /**
         统计p中各个字符出现的次数
         大小为p.length的窗口在s上滑动
         统计满足条件的结果

         map中寸的是需要窗口中的字符数量
         */
        List<Integer> resList = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int zeroNum = 0;    // 记录map中val为0的key个数
        int plen = p.length();
        char[] chars = s.toCharArray();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        // 建立窗口的过程
        for (;right < plen; right++) {
            if (map.containsKey(chars[right])) {
                map.put(chars[right], map.get(chars[right]) - 1);
                if (map.get(chars[right]) == 0) {
                    zeroNum++;
                } else if (map.get(chars[right]) == -1) {
                    zeroNum--;
                }
            }
        }

        if (zeroNum == map.size()) {
            resList.add(left);
        }
        right--;
        while (right < chars.length - 1) {
            // 窗口右移一位
            if (map.containsKey(chars[left])) {
                map.put(chars[left], map.get(chars[left]) + 1);
                if (map.get(chars[left]) == 0) {
                    zeroNum++;
                } else if (map.get(chars[left]) == 1) {
                    zeroNum--;
                }
            }
            left++;
            right++;
            if (map.containsKey(chars[right])) {
                map.put(chars[right], map.get(chars[right]) - 1);
                if (map.get(chars[right]) == 0) {
                    zeroNum++;
                } else if (map.get(chars[right]) == -1) {
                    zeroNum--;
                }
            }
            if (zeroNum == map.size()) {
                resList.add(left);
            }
        }
        return resList;
    }
}
