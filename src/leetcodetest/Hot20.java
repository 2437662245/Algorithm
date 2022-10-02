package leetcodetest;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/29 22:13
 */
public class Hot20 {

    @Test
    public void test20() {
        String s = "()";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        // 栈
        if (s.length() == 0 || "".equals(s)) {
            return true;
        }
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                deque.offerFirst(c);
            } else {
                if (deque.isEmpty() || deque.pollFirst() != c) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
