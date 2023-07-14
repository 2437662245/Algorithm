package common;

/**
 * @ClassName: ListNode
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/25 19:18
 * @Version: 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}