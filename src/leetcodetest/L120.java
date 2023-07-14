package leetcodetest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: L120
 * @Description:
 * @Author: zh
 * @DateTime: 2022/12/1 21:17
 * @Version: 1.0
 */
public class L120 {

    @Test
    public void test() {


        // [2],[3,4],[6,5,7],[4,1,8,3]
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        minimumTotal(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int sz = triangle.size();
        int[] matrix = new int[sz];
        matrix[0] = triangle.get(0).get(0);
        // i控制遍历到哪一层了，j用来更新数组
        for (int i = 1; i < sz; i++) {
            int pre = matrix[0];
            matrix[0] = triangle.get(i).get(0) + matrix[0];
            for (int j = 1; j < i; j++) {
                int temp = matrix[j];
                matrix[j] = triangle.get(i).get(j) + Math.min(pre, matrix[j]);
                pre = temp;
            }
            matrix[i] = triangle.get(i).get(i) + pre;
        }

        int res = 2000001;
        for (int i = 0; i < matrix.length; i++) {
            res = Math.min(res, matrix[i]);
        }
        return res;
    }
}
