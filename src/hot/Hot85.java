package hot;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Hot85
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/9 20:03
 * @Version: 1.0
 */
public class Hot85 {
    @Test
    public void test() {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        int maximalRectangle = maximalRectangle(matrix);
        System.out.println(maximalRectangle);
    }

    public int maximalRectangle(char[][] matrix) {
        /**
         从第一行往最后一行遍历，遇到1叠加下去，遇到0就中断
         最后矩阵每一行就成了，自己位置有一个val高的圆柱，求圆柱形成的最大矩形面积
         */
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newMatrix = new int[m][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j + 1] = matrix[i][j] - '0';
                if (i == 0) {
                    continue;
                }
                if (matrix[i][j] == '0') {
                    continue;
                } else {
                    newMatrix[i][j + 1] += newMatrix[i - 1][j + 1];
                }
            }
        }
        // 给出一个数组
        int res = 0;
        for (int i = 0; i < newMatrix.length; i++) {
            res = Math.max(res, largestRectangleArea(newMatrix[i]));
        }
        return res;
    }
    public int largestRectangleArea(int[] arr) {
        // 给出一个数组，每个位置代表柱子的高度，求数组能形成的最大矩形面积
        // 单调递增栈：栈底->栈顶 单调非严格递增 遍历数组时，遇到比栈顶大或等的元素入栈，遇到比栈顶小的元素时，栈中大于此元素的都出栈，统计最大矩形面积，直到栈中没有比当前元素大的，当前元素入栈。数组首位都有最小元素0，两个哨兵保证，首位的0省去了遍历数组时 对栈空的判断，简化了代码；尾部的0保证了，遍历完数组之后，栈中的元素都会出栈（除了首部哨兵）
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;    // 最大矩形面积
        stack.offerFirst(0);    // 哨兵入栈
        for (int i = 1; i < arr.length; i++) {
            // 当前元素比栈顶元素小时，需要统计前面较高的柱子形成的最大矩形了
            while (arr[i] < arr[stack.peekFirst()]) {
                /*
                    这段代码错误，而下面代码正确因为，宽度选择问题，这段代码中宽度有误
                    既然在栈中，比如index=2在栈中，现在栈中还有2  6 7，对应高度分别为 3  8 9 现在一个i=8，高度为2入栈了
                    统计的前面index为2 6 7为到index=8分别形成的矩形面积，2后面的一定都比2处的高，不然它不会在栈中
                    求7处的面积为 错误代码 index = 7， h = 9， w = 1, 对应面积为 7
                    求6处的面积为 错误代码 index = 6, h = 6, w = 2, area = 12
                    求2处的面积为 错误代码 index = 2, h = 3, w = 6, area = 18
                    那2处后面的是求得了，那2之前已经出栈的比2处高的就被忽略了，所以要用前一个在栈里面的，代表2处之前第一个比2处小的元素的index
                        比如1处高度为4，那么这个错误计算方法，算2位置面积的时候就少算了1处的部分，
                int index = stack.pollFirst();
                int height = arr[index];
                int width = i - index;
                max = Math.max(max, height * width);
                */

                int curHeight = arr[stack.pollFirst()];
                int curWidth = i - stack.peekFirst() - 1;   // stack.isEmpty()
                max = Math.max(max, curHeight * curWidth);
            }
            stack.offerFirst(i);
        }
        return max;
    }
}


