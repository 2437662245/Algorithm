package leetcodetest;

/**
 * Auther: zh
 * DateTime: 2022/4/23 17:10
 * Description:
 */
public class Jz16 {
    public static void main(String[] args) {
        Jz16Solution jz16 = new Jz16Solution();
        double v = jz16.myPow(5, 10);
        System.out.println(v);

    }
}

class Jz16Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}