package leetcodetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: zh
 * DateTime: 2022/4/8 19:20
 * Description:
 */
public class L78 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        L78Solution l78 = new L78Solution();
        List<List<Integer>> resList = new ArrayList<>();
        int[] nums = {1,2,3};
        resList = l78.subsets(nums);
        resList.forEach(integers -> System.out.println(integers));
    }
}

class L78Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 可以转化为切割问题，切出的每一个小块都是符合条件的解
        List<List<Integer>> resList = new ArrayList<>();
        // 分出的每一个集合
        List<Integer> list = new ArrayList<>();
        // 递归函数及返回值 return:void, args(nums, resList, list, int begin)
        backtracking(nums, resList, list, 0);
        return resList;
    }

    public void backtracking(int[] nums, List<List<Integer>> resList, List<Integer> list, int begin) {
        // 递归终止条件
        resList.add(new ArrayList(list));

        // 单层递归逻辑
        for (int i = begin; i < nums.length; i++) {
            list.add(nums[i]);  // 做选择
            backtracking(nums, resList, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}