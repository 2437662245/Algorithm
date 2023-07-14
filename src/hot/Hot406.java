package hot;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Hot406
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/23 10:12
 * @Version: 1.0
 */
public class Hot406 {

    @Test
    public void test() {

    }

    public int[][] reconstructQueue(int[][] people) {
        /*
            先排序再插入

            7 0
            4 4
            7 1
            5 0
            6 1
            5 2

            7 0
            7 1
            6 1
            5 0
            5 2
            4 4
            先根据身高降序(身高相同按照位序升序)排序， 再根据位序插入
        */
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr1[1] > arr2[1] ? 1 : -1;
                } else {
                    return arr1[0] < arr2[0] ? 1 : -1;
                }
            }
        });

        // 按照身高排完序后，按照位序插入
        for (int i = 1; i < people.length; i++) {
            if (people[i][1] == i) {
                continue;
            }
            int[] temp = people[i];
            int j = i;
            for (; j > temp[1]; j--) {
                people[j] = people[j - 1];
            }
            people[j] = temp;
        }
        return people;
    }
}
