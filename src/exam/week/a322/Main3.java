package exam.week.a322;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: joe
 * @dateTime: 2023/3/19 11:45
 * @description: TODO
 * @version: 1.0
 */
public class Main3 {
    public static void main(String[] args) {
        int[] ints = {2, 4, 6};
        int k = 2;
        Solution solution = new Solution();
        solution.beautifulSubsets(ints, k);

    }
}

class Solution {
    int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        backtrack(nums, k, 0, new HashSet<Integer>());
        return count;
    }

    public void backtrack(int[] nums, int k, int startIndex, HashSet<Integer> set) {
        for (int i = startIndex; i < nums.length; i++) {
            if (!set.isEmpty() && set.contains(nums[i] - k)) {
                continue;
            }
            set.add(nums[i]);
            count++;
            backtrack(nums, k, i, set);
            set.remove(nums[i]);
        }
    }

}
