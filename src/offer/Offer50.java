package offer;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/21 19:47
 */
public class Offer50 {

    @Test
    public void test1() {
        System.out.println(firstUniqChar("leetcode"));
    }


    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        char result = ' ';
        // HashMap
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        // 从map中取出第一个value为1的key
        return result;
    }

}
