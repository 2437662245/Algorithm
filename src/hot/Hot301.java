package hot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Hot301
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/18 16:16
 * @Version: 1.0
 */
public class Hot301 {
    List<String> res = new ArrayList<>();

    @Test
    public void test301() {
        List<String> strings = removeInvalidParentheses("()())()");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        /**
         统计左右括号数量，右括号先出现的位置，删除其左边任意一个右括号（包括它自己）即为所有可能结果（需要注意去重，挨着的右括号 去除任意一个是同一个结果）
         */

        // 统计左右括号数量
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }
        }

        //
        backtrack(s.toCharArray(), new StringBuilder(), 0, Math.min(left, right), 0, 0);
        return res;
    }

    // m:有效括号的对数, StringBuilder中左右括号的个数 记录为sbl sbr
    public void backtrack(char[] chars, StringBuilder sb, int index, int m, int sbl, int sbr) {

        if (index == chars.length && m == sbl && sbr == m) {
            // 与上一个不同 才加入结果集
            if (res.size() > 0 && !sb.toString().equals(res.get(res.size() - 1)));
            res.add(sb.toString());
        }

        if (sbr > sbl || sbl > m || sbr > m || index >= chars.length) {
            return;
        }

        while (chars[index] != '(' && chars[index] != ')') {
            sb.append(chars[index++]);
        }
        for (int i = index; i < chars.length; i++) {
            if (chars[i] == '(') {
                sb.append(chars[i]);
                backtrack(chars, sb, i + 1, m, sbl + 1, sbr);
                sb.deleteCharAt(sb.length() - 1);
            } else if (chars[i] == ')') {
                sb.append(chars[i]);
                backtrack(chars, sb, i + 1, m, sbl, sbr + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
}


