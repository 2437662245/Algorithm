package stringbuildertest;

import org.junit.Test;

/**
 * @ClassName: StringBuilderTest
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/18 16:08
 * @Version: 1.0
 */
public class StringBuilderTest {

    @Test
    public void test1() {
        StringBuilder builder = new StringBuilder();
        builder.deleteCharAt(1);
    }
}
