package leetcodetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: zh
 * DateTime: 2022/4/6 21:10
 * Description:
 */
public class L131 {
    public static void main(String[] args) {
        L131 l131 = new L131();
        l131.partition("aab");
    }
    //
    List<List<String>> resList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return resList;
    }

    public void backtracking(String s, int startIndex) {
        // 递归终止条件
        if (startIndex >= s.length()) {
            resList.add(new ArrayList(list));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {  // 是回文串
                // 获取[startIndex, i]在s中的字串
                String str = s.substring(startIndex, i + 1);
                list.add(str);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            list.remove(list.size() - 1);
        }

    }

    // 判断是否是回文串
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
