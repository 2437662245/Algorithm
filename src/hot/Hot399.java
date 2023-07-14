package hot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Hot399
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/23 13:55
 * @Version: 1.0
 */
public class Hot399 {

    @Test
    public void test() {
        List<List<String>> equations = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");
        equations.add(list1);
        equations.add(list2);
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("c");
        List<String> list4 = new ArrayList<>();
        list4.add("b");
        list4.add("a");
        List<String> list5 = new ArrayList<>();
        list5.add("a");
        list5.add("e");
        List<String> list6 = new ArrayList<>();
        list6.add("a");
        list6.add("a");
        List<String> list7 = new ArrayList<>();
        list7.add("x");
        list7.add("x");
        queries.add(list3);
        queries.add(list4);
        queries.add(list5);
        queries.add(list6);
        queries.add(list7);
        calcEquation(equations, values, queries);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFindSet ufs = new UnionFindSet(2*equationsSize);
        Map<String, Integer> hashMap = new HashMap<>();
        int id = 0;
        for (int i = 0; i < equationsSize; ++i) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }

            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            ufs.union(hashMap.get(var1), hashMap.get(var2), values[i]);

        }

        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; ++i) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            if (!hashMap.containsKey(var1) || !hashMap.containsKey(var2)) {
                res[i] = -1.0d;
            }else {
                res[i] = ufs.isConnected(hashMap.get(var1), hashMap.get(var2));
            }
        }
        return res;
    }

    private class UnionFindSet {
        private int[] parent;
        private double[] weight;

        public UnionFindSet(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            weight[rootX] = (value*weight[y])/weight[x];
        }

        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] = weight[origin] * weight[x];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) return -1.0d;
            return weight[x] / weight[y];
        }
    }
}
