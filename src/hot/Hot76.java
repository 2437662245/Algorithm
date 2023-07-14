package hot;

import org.junit.Test;

/**
 * @ClassName: Hot76
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/7 19:33
 * @Version: 1.0
 */
public class Hot76 {

    @Test
    public void test() {
        String s = "ADOBECODEBANC", t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }

    public String minWindow(String s, String t) {
        // 滑动窗口
        // 分别用两个数组记录需要的字符数，和现在窗口中有的字符数 再用已经满足的字符数vaild和总的字符数记录count 窗口中有哪些字符数量已经够了
        int[] win = new int[128];
        int[] needs = new int[128];
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int count = 0;     // t中的字符种类数
        // 滑动窗口左右边界，窗口中符合条件的字符数，直到当前窗口 最小字串长度
        int left = 0, right = 0, vaild = 0, len = 100001, start = 0;

        for (char c : tchars) {
            if (needs[c] == 0) {
                count++;
            }
            //            if (needs[c] == 0) {
//                count++;    // count记录的是字符串t中有多少种字符
//            }
            needs[c]++;     // needs记录的是字符串t中各字符各自的个数
        }

        while (right < schars.length) {
            char c = schars[right++];   // 当前右边界字符c，并将窗口右移一下
            win[c]++;   // 窗口中此字符数量加一个

            if (win[c] == needs[c]) {   // 如果加上之后刚好数量够用 则符合条件的字符+1 valid++
                vaild++;
            }

            while (vaild == count) {    // 如果符合条件的字符刚好和需要的字符数相同
                if (right - left < len) {  // 如果还没有产生过符合条件的字串，初始化一下len为r-1 start为left 字串左边界为窗口左边界 准备缩小边界
                    len = right - 1;
                    start = left;
                }
                char d = schars[left++];
                if (needs[d] == win[d]) {
                    vaild--;
                }
                win[d]--;
            }
        }
        return len == 100001 ? "" : s.substring(start, start + len);
    }


}
