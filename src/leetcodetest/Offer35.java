package leetcodetest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * Auther: zh
 * DateTime: 2022/9/15 19:50
 */
public class Offer35 {
    public static void main(String[] args) {
        Offer35Solution offer35Solution = new Offer35Solution();
        Node one = new Node(7);
        Node two = new Node(13);
        Node three = new Node(11);
        Node four = new Node(10);
        Node five = new Node(1);
        one.next = two;
        two.next = three;
        two.next = three;
        three.next = four;
        four.next = five;
        one.random = null;
        two.random = one;
        three.random = five;
        four.random = three;
        five.random = one;
        Node node = offer35Solution.copyRandomList(one);
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Offer35Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        // 用map存储原节点 新节点
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 遍历map 复制原链表的next和random关系
        Set<Node> keys = map.keySet();  // 所有的键
        for (Node node : keys) {
            // next关系复制
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(head);
    }
}