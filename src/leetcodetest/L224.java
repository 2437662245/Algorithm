package leetcodetest;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: L224
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/8 19:32
 * @Version: 1.0
 */
public class L224 {

    @Test
    public void test() {
        int calculate = calculate(" 2-1 + 2 ");
        System.out.println(calculate);
    }

    public int calculate(String s) {
        // 使用操作符栈和算数栈实现表达式计算
        s = s.replaceAll(" ", "");
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> signStack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        numStack.offerLast(0);
        int index = 0;
        while (index < chars.length) {
            if (isDegit(chars[index])) {
                int num = 0;
                while (index < chars.length && isDegit(chars[index])) {
                    num = num * 10 + chars[index] - '0';
                    index++;
                }
                numStack.offerLast(num);
            } else if (chars[index] == ')') {
                // 遇到右括号，需要将括号内部分计算出来
                while (signStack.peekLast() != '(') {
                    int num1 = numStack.pollLast();
                    int num2 = numStack.pollLast();
                    char sign = signStack.pollLast();
                    if (sign == '+') {
                        numStack.offerLast(num2 + num1);
                    } else {
                        numStack.offerLast(num2 - num1);
                    }
                }
                // 将左括号弹出
                signStack.pollLast();
                index++;
            } else {
                // 遇到其它符号，放入符合栈，继续遍历
                signStack.offerLast(chars[index]);
                index++;
            }
        }
        while (!signStack.isEmpty()) {
            int num1 = numStack.pollLast();
            int num2 = numStack.pollLast();
            char sign = signStack.pollLast();
            if (sign == '+') {
                numStack.offerLast(num2 + num1);
            } else {
                numStack.offerLast(num2 - num1);
            }
        }
        return numStack.peekLast();
    }

    // 判断字符是否是数字
    public boolean isDegit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
