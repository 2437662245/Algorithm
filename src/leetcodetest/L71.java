package leetcodetest;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: L71
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/13 16:29
 * @Version: 1.0
 */
public class L71 {

    @Test
    public void test() {
        String path = "/../";
        String s = simplifyPath(path);
        System.out.println(s);
    }

    public String simplifyPath(String path) {
        // 借助栈
        String[] strs = path.split("/");

        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..") && !deque.isEmpty()) {
                deque.pollFirst();
            } else if (strs[i].equals(".") || strs[i].equals("/") || strs[i].length() == 0) {
                continue;
            } else {
                deque.offerFirst(strs[i]);
            }
        }
        StringBuilder resBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            resBuilder.append("/").append(deque.pollLast());
        }
        return resBuilder.toString();
    }
}
