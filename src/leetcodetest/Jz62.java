package leetcodetest;

import java.util.LinkedList;
import java.util.List;

/**
 * Auther: zh
 * DateTime: 2022/5/5 17:01
 * Description:
 */
public class Jz62 {
    public static void main(String[] args) {
        Jz62Solution jz62 = new Jz62Solution();
        System.out.println(jz62.lastRemaining(10, 17));
    }
}

class Jz62Solution {
    public int lastRemaining(int n, int m) {
        // 存储，遍历删除直到只剩一个
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;    // 计数器
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}