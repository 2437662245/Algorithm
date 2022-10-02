package leetcodetest;

import java.util.*;

/**
 * Auther: zh
 * DateTime: 2022/4/19 21:59
 * Description:
 */
public class L56 {
    public static void main(String[] args) {
        L56Solution l56 = new L56Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = l56.merge(intervals);
        System.out.println(merge[0][0]);
        System.out.println(merge[0][1]);


    }
}

class L56Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> resList = new ArrayList<>();

        // 先对intervals根据start进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] > arr2[0]) {
                    return 1;
                } else if (arr1[0] < arr2[0]) {
                    return -1;
                } else {
                    return arr1[1] > arr2[1] ? 1 : -1;
                }
            }
        });

        resList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 用intervals数组中的值和resList中的进行比较 看是否有重叠
            // 无重叠
            if (intervals[i][0] > resList.get(resList.size()-1)[1]) {
                resList.add(intervals[i]);
            } else {
                resList.set(resList.size()-1, new int[]{resList.get(resList.size()-1)[0], Math.max(intervals[i][1], resList.get(resList.size()-1)[1])});
            }
        }
        int[][] result = new int[resList.size()][2];
        return resList.toArray(result);
    }
}