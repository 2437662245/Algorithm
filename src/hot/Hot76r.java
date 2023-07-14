package hot;

/**
 * @author: joe
 * @dateTime: 2023/3/6 17:06
 * @description: TODO
 * @version: 1.0
 */
public class Hot76r {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        // 滑动窗口
        // need数字记录t的个字符数量 countNeed记录t中字符种数
        int need[] = new int[64];
        int countNeed = 0;
        for (int i = 0; i < t.length(); i++) {
            if (need[t.charAt(i) - 'A']++ == 0) {
                countNeed++;
            }
        }
        int validCount = 0;    // s的窗口中覆盖t的字符种数
        // 左右窗口边界
        int left = 0;
        int right = 0;
        int minLen = s.length();    // 符合条件的最小字串长度
        String res = s;
        while (right < s.length()) {
            // 当前窗口右边界的字符
            char rc = s.charAt(right++);
            if (--need[rc - 'A'] == 0) {
                validCount++;   // 符合条件的字符数+1
            }
            // 窗口能覆盖t
            while (validCount == countNeed) {
                // 左窗口右移
                char lc = s.charAt(left);
                if (need[lc - 'A']++ == 0) {
                    validCount--;
                    // 少了当前这个left位置的字符 就要覆盖不住了 right-left是当前窗口中的字串[l,r)
                    if (right - left < res.length()) {
                        res = s.substring(left, right);
                    }
                    left++;
                    break;
                }
                left++;
            }
        }
        return res;
    }
}