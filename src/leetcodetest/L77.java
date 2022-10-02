package leetcodetest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: zh
 * DateTime: 2022/3/13 9:05
 * Description:
 */
public class L77 {
    public static void main(String[] args) {
        System.out.println((char)('2' + 47));

        Solution solution = new Solution();
        solution.combine(5, 3);
        for (List<Integer> list : solution.resList) {
            System.out.println(list.toString());
        }
    }

}

class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // 组合 回溯算法
        backTracking(n, k, 1);
        return resList;

    }
    public void backTracking(int n, int k, int startIndex) {
        // 终止条件，集合list大小达到k
        if (list.size() == k) {
            resList.add(new ArrayList<>(list));  // 加入到结果集中
            return;
        }

        /** 剪枝优化 i < n - (k - list.size()) + 1
        k list中总需要的个数，list.size()现有个数，k - list.size()现在需要个数，
        i最大只能为n - (k - list.size()) + 1，往后遍历才能凑的够k个数，不然没有必要向后遍历，因为遍历到最后也不会满足list.size() == k的条件，浪费时间
        */
         for (int i = startIndex; i <= n; i++) {
            // 处理节点
            list.add(i);
            backTracking(n, k, i + 1);  // 递归
            list.remove(list.size() - 1);
        }
    }
}
