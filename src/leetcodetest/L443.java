package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L443
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/18 13:23
 * @Version: 1.0
 */
public class L443 {

    @Test
    public void test() {
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(chars);
        System.out.println("compress = " + compress);
    }

    public int compress(char[] chars) {

        if (chars.length == 1) {
            return 1;
        }

        // 新数组的索引
        int newIndex = 0;
        // chars的遍历索引
        int index = 1;

        while (index < chars.length) {
            // chars[index - 1]不重复
            if (chars[index] != chars[index - 1]) {
                chars[newIndex++] = chars[index - 1];
                index++;
                break;
            }
            // chars[index - 1]与后面重复
            int count = 1;
            while (index < chars.length && chars[index] == chars[index - 1]) {
                count++;
                index++;
            }
            // 统计完个数之后将压缩后的内容写入到新数组中
            // 将重复的字符写入到新数组中
            chars[newIndex++] = chars[index - 1];
            // 将重复的个数写入到新数组中
            String countStr = String.valueOf(count);
            for (int i = 0; i < countStr.length(); i++) {
                chars[newIndex++] = countStr.charAt(i);
            }
            index++;
        }
        return newIndex;
    }
}
