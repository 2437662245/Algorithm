package hot;

import org.junit.Test;

/**
 * @ClassName: H165
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/21 21:00
 * @Version: 1.0
 */
public class H165 {

    @Test
    public void test1() {
        int[] needs = new int[128];
        int needCount = 0;
        String t = "ABC";
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (needs[c] == 0) {
                needCount++;
            }
            needs[c]++;
        }
        System.out.println(needCount);
    }

    @Test
    public void test() {
        String version1 = "0.1";
        String version2 = "1.1";
        int compareVersion = compareVersion(version1, version2);
        System.out.println(compareVersion);
    }

    public int compareVersion(String version1, String version2) {
        // 每次从两个版本号取出一个数字对比
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");

        int len1 = strs1.length;
        int len2 = strs2.length;
        System.out.println(len1);
        System.out.println(len2);
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (Integer.parseInt(strs1[i]) > Integer.parseInt(strs2[i])) {
                return 1;
            } else if (Integer.parseInt(strs1[i]) < Integer.parseInt(strs2[i])) {
                return -1;
            }
        }
        for (int i = len2; i < len1; i++) {
            if (Integer.parseInt(strs1[i]) > 0) {
                return 1;
            }
        }
        for (int i = len1; i < len2; i++) {
            if (Integer.parseInt(strs2[i]) > 0) {
                return -1;
            }
        }
        return 0;
    }
}
