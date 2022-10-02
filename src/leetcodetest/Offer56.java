package leetcodetest;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/24 20:21
 */
public class Offer56 {

    public static void main(String[] args) {
        Offer56Solution offer56Solution = new Offer56Solution();
        int[] arr = new int[]{3,4,3,3};
        System.out.println(offer56Solution.singleNumber(arr));
    }
}

class Offer56Solution {
    public int singleNumber(int[] nums) {
        // 位运算 与 或 非 异或
        // 思路是：所有数字的每一二进制位上相加 必为3n或3n+1，求出每一位 对3取余 可以结果的每一二进制位
        int[] arr = new int[32];
        int index = 0;  // 从0-len是低位到高位
        for (int num : nums) {
            index = 0;
            while (num > 0) {
                arr[index++] += num & 1;
                num >>= 1;  // 右移一位
            }
        }
        int result = 0;
        int base = 1;
        for (int a : arr) {     // 求得每一位上的二进制数
            a = a % 3;
            result = result + a * base;
            base *= 2;
        }
        return result;
    }
}
