package leetcodetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: zh
 * DateTime: 2022/4/8 21:02
 * Description:
 */
public class L491 {
    public static void main(String[] args) {
        L491Solution l491 = new L491Solution();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        List<List<Integer>> resList = l491.findSubsequences(nums);
        resList.forEach(integers -> System.out.println(integers));
    }



}

class L491Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        //
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, resList, list, 0);
        return resList;
    }

    public void backtracking(int[] nums, List<List<Integer>> resList, List<Integer> list, int begin) {
        // 递归终止条件 list至少2个元素，
        if (list.size() >= 2) {
            resList.add(new ArrayList(list));
            // return;
        }

        for (int i = begin; i < nums.length; i++) {
            // 需要剪枝的一种情况是 重复，如果数组中当前元素已经出现过，并且和list前一个元素不同 剪掉
            // 做选择
            if (!list.isEmpty() && nums[i] < list.get(list.size() - 1)) {    // 如果list不为空并且此数比数组中最后一个数小
                continue;
            } else {    // 如果不为空 并且数组中当前元素已经出现过，并且和list前一个元素不同 剪掉
                if (list.size() >= 1 && i > firstIndex(nums, begin, nums[i])) {
                    continue;
                }
                list.add(nums[i]);
            }
            backtracking(nums, resList, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    // 返回val元素在arr数组中第一次出现的位置
    public int firstIndex(int[] arr, int start, int val) {
        int resIndex = -1;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == val) {
                resIndex = i;
                break;
            }
        }
        return resIndex;
    }
}