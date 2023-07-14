package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Auther: zh
 * DateTime: 2022/4/21 21:27
 * Description:
 */
public class jz06 {
    public static void main(String[] args) {
        Jz06Solution jz06 = new Jz06Solution();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        int[] ints = jz06.reversePrint(head);
        System.out.println(ints[0]);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Jz06Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> resultList = new ArrayList<>();
        while (head != null) {
            resultList.add(head.val);
            head = head.next;
        }
        int len = resultList.size();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = resultList.get(len - i - 1);
        }
        return result;
    }
}
