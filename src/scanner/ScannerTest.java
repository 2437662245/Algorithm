package scanner;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author: joe
 * @dateTime: 2023/2/24 21:46
 * @description: TODO
 * @version: 1.0
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (reader.hasNextInt()) { // 注意 while 处理多个 case
            int b = Integer.valueOf(reader.nextLine());
            int a = reader.nextInt();
            System.out.println(a + b);
        }
    }
}
