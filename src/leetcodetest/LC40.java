package leetcodetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Auther: zh
 * DateTime: 2022/3/13 16:47
 * Description:
 */
public class LC40 {

    public static void main(String[] args) {
        Solution40 s40 = new Solution40();
        int candidates[] = {10, 1, 2, 7, 6, 1, 5};
        candidates = Arrays.stream(candidates).distinct().toArray();
        int target = 8;
        s40.combinationSum2(candidates, target);
        List<List<Integer>> resList = s40.resList;
        Iterator iterator = resList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}

class Solution40 {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 回溯
        backTracking(candidates, target, 0, 0);
        return resList;
    }

    void backTracking(int candidates[], int target, int sum, int startIndex) {
        // 递归终止条件
        if (sum == target) {
            resList.add(new ArrayList(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
             if(sum + candidates[i] <= target) {
                 // 做出选择
                 list.add(candidates[i]);
                 sum += candidates[i];
                 // 递归
                 backTracking(candidates, target, sum, i + 1);
                 // 回溯
                 list.remove(list.size() - 1);
                 sum -= candidates[i];
             }
        }
    }
}
