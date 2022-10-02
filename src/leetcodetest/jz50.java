package leetcodetest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Auther: zh
 * DateTime: 2022/5/1 15:27
 * Description:
 */
public class jz50 {
    public static void main(String[] args) {

    }
}

class Jz50Solution {
    public char firstUniqChar(String s) {
        // 借助HashMap  存储每个字符和对应的索引 如果出现了重复的就将index置为-1 最后遍历map第一个index不为-1就是result
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, -1);
            } else {
                map.put(temp, i);
            }
        }
        Set<Map.Entry<Character, Integer>> set = map.entrySet();//将存放key-value对的entry对象存放到Set集合中
        for (Map.Entry<Character, Integer> entry : set) {//遍历Set集合中的entry对象
            if (entry.getValue() != -1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}