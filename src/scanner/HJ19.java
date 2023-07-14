package scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/27 19:17
 * @description: TODO
 * @version: 1.0
 */
import java.util.*;
public class HJ19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 思路：为保证读入时的顺序，使用ArrayList存放文件名 + 数组存放出现次数，同时使用HashMap进行去重，map中存(文件名，行数)
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            // 输入的字符串按照\划分为String数组
            String[] strs = sc.nextLine().split("\\\\");
            // 取最后一部分再分割得到 文件名 所在行
            String[] strs1 = strs[strs.length - 1].split(" ");
            int len = strs1[0].length();
            String fileName = len > 16 ? strs1[0].substring(len - 16, len) : strs1[0];
            fileName = fileName + strs1[1];
            // 判断这个文件出现过没有
            if (!map.containsKey(fileName)) {
                list.add(fileName);
            }
            map.put(fileName, map.getOrDefault(fileName, 0));
        }
        int start = 0;
        if (list.size() > 8) {
            start = list.size() - 8;
        }
        for (; start < list.size(); start++) {
            String fileName = list.get(start);
            System.out.print(fileName);
            System.out.println(" " + map.get(fileName));
        }
    }
}