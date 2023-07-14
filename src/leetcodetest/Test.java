package leetcodetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: joe
 * @dateTime: 2023/3/15 18:53
 * @description: TODO
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.tryLock();
        System.out.println(1);
        lock.unlock();
        ArrayList<ArrayList<Integer>> list = factorization(6);
        System.out.println(list.size());
    }

    public static  ArrayList<ArrayList<Integer>> factorization (int n) {
        // write code here
        //
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                n /= i;
            } else {
                i++;
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(entry.getKey(), entry.getValue());
            res.add(list);
        }
        return res;
    }
}
