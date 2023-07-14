package exam.B;

/**
 * @author: joe
 * @dateTime: 2023/3/11 9:36
 * @description: TODO
 * @version: 1.0
 */
public class B1 {
    public static void main(String[] args) {
        int[] da1 = new int[]{1, 3, 5};
        int[] da2 = new int[]{2, 4, 6};
        System.out.print(da2[da1[0]]);
        interchange(da1, da2);
        System.out.print(da1[da2[0]]);
    }
    static void interchange(int[] da1, int[] da2) {
        int[] dat = da1;
        da1 = da2;
        da2 = dat;
    }
}
