package hot;

/**
 * @author: joe
 * @dateTime: 2023/2/28 20:55
 * @description: TODO
 * @version: 1.0
 */
public class Hot006 {
    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
    public static String convert(String s, int numRows) {
        //
        StringBuilder[] builders = new StringBuilder[numRows];
        for (StringBuilder stringBuilder : builders) {
            stringBuilder = new StringBuilder("1");
        }
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length) {
            for (int i = 0; i < numRows; i++) {
                if (index >= chars.length) {
                    break;
                }
                builders[i].append(chars[index++]);
            }
            for (int i = numRows - 1; i > 0; i--) {
                if (index >= chars.length) {
                    break;
                }
                builders[i].append(chars[index++]);
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : builders) {
            res.append(builder);
        }
        return res.toString();
    }
}