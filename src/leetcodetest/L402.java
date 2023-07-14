package leetcodetest;

import org.junit.Test;

/**
 * @ClassName: L402
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/3 11:55
 * @Version: 1.0
 */
public class L402 {

    @Test
    public void test() {
        String s = removeKdigits("112", 1);
        System.out.println(s);
    }

    public String removeKdigits(String num, int k) {
        if(num.length() == k) {
            return "0";
        }

        // StringBuilder充当了栈的作用
        StringBuilder builder = new StringBuilder();
        int remains = num.length() - k; // 剩余

        // 遍历字符串num
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);

            /*
                k > 0 : 还有要删除的字符才会检查是否要删除
                builder.length()!=0 : 只有builder长度不为0才需要检查是否要删除
                builder.charAt(builder.length() - 1) > ch : 当前元素比builder的最后一个元素小，要将builder的最后一个元素删去

             */
            while(k > 0 && builder.length() != 0 && builder.charAt(builder.length() - 1) > ch){
                // 删除builder最后一个元素
                builder.setLength(builder.length() - 1);
                k--;
            }
            if(ch == '0' && builder.length() == 0){
                continue;
            }
            builder.append(ch);
        }
        String res = builder.substring(0, builder.length() - k).toString();
        return res.length() == 0 ? "0" : res;
    }
}
