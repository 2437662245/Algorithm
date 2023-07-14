package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: joe
 * @dateTime: 2023/3/5 15:15
 * @description: TODO
 * @version: 1.0
 */
public class Hot56 {

    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        // 先按照区间左边界排序，再按照右边界排序
        Arrays.sort(intervals, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr1[1] - arr2[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        ArrayList<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 取出上一段
            int[] pre = resList.get(resList.size() - 1);
            // 看能否合并
            if (pre[1] >= intervals[i][0]) {
                // 可以合并
                pre[1] = intervals[i][1];
            } else {
                // 不可以合并
                resList.add(intervals[i]);
            }
        }
        return resList.toArray(new int[resList.size()][2]);
    }
}
