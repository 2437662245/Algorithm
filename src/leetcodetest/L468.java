package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L468
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/7 15:29
 * @Version: 1.0
 */
public class L468 {

    @Test
    public void test3() {
        String str = "";
        System.out.println(str.length());
        System.out.println("".equals(str));
    }

    @Test
    public void test2() {
        String IP = "172.16.254.1.";
        String[] split = IP.split("\\.", -1);
        System.out.println(split.length);
    }

    @Test
    public void test() {
        String IP = "172.16.254.1";
        String s = validIPAddress(IP);
        System.out.println(s);
    }

    public String validIPAddress(String queryIP) {
        // 将字符串分割，分别按照:个.分割成两个字符串数组，根据数组的长度确定是IPv6或IPv4
        // 确定类型之后再验证地址中每一个段的合法性
        // 按照IPv6格式分割出的字符串数组
        String[] strs1 = queryIP.split(":");
        // 按照IPv4格式分割出的字符串数组
        String[] strs2 = queryIP.split("\\.");
        // if (strs1.length != 8 && strs2.length != 4) {
        //     return "Neither";
        // }
        // 是IPv6 检测每一个段的合法性
        if (strs1.length == 8) {
            for (String str : strs1) {
                if (!isValid6(str)) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        if (strs2.length == 4) {
            for (String str : strs2) {
                if (!isVaild4(str)) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        return "Neither";
    }
    // IPv4中段的有效性
    public boolean isVaild4(String str) {
        int num = Integer.valueOf(str);
        // 比255大的不合法
        if (num > 255) {
            return false;
        }
        // 只有多个0不合法
        if (num == 0 && str.length() > 1) {
            return false;
        }
        // 不是0，但是还有前导0的不合法
        if (num != 0 && str.charAt(0) == '0') {
            return false;
        }
        return true;
    }

    public boolean isValid6(String str) {
        int len = str.length();
        // 长度不为4 不合法
        if (len != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            char c = str.charAt(i);
            if ((c >= '0' && c <= '9') ||
                    (c >= 'a' && c <= 'f') ||
                    (c >= 'A' && c <= 'F')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
