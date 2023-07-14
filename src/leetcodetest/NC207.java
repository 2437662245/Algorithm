package leetcodetest;

import common.ListNode;
import org.junit.Test;

/**
 * @ClassName: NC207
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/29 17:49
 * @Version: 1.0
 */
public class NC207 {

    @Test
    public void test() {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        ListNode listNode = sortLinkedList(head);

    }

    /**
     *
     * @param head
     * @return
     *
     * 给定一个奇数位升序，偶数位降序的链表，返回对其排序后的链表。
     * 题面解释：例如链表 1->3->2->2->3->1 是奇数位升序偶数位降序的链表，而 1->3->2->2->3->2 则不符合题目要求。
     * 数据范围：链表中元素个数满足 1≤n≤10000, 链表中的元素大小满足 1≤val≤100000
     * 输入 {1,3,2,2,3,1}
     * 输出 {1,1,2,2,3,3}
     * 方法1：将奇数位置的元素都取下来头插形成一个链表，然后合并两个链表
     * 1 2 3 1
     */
    public ListNode sortLinkedList (ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;  // 偶数位置上的节点
            cur.next = temp.next;
            cur = cur.next;
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }
        // 合并两个链表
        cur = dummyHead;
        ListNode head2 = dummyHead.next;
        dummyHead.next = null;
        while (head != null && head2 != null) {
            if (head.val <= head2.val) {
                cur.next = head;
                head = head.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head != null) {
            cur.next = head;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return dummyHead.next;
    }
}
