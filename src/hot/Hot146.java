package hot;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Hot146
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/12 17:07
 * @Version: 1.0
 */
public class Hot146 {

    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}

/**
 * 使用HashMap存储键值对
 * 用什么维护最近最少使用排序？ 双向链表
 *
 * 构造方法 初始化容量，HashMap、DeLinkedList map中存放LRU的key和Node，Node的val是LRU的val
 *      put操作：在map中判断是否已经存在：
 *                  存在：更新值，取到对应的节点，更新值，并将节点放到链表头部
 *                  不存在：判断LRU的容量和map的大小
 *                      LRU的容量==map大小: 取链表尾部的节点，删除，并且删除map中对应的节点 (根据val找key O(n))
 *                              >       : 创建节点插入到链表头部，添加到map中
 *      get操作：判断map中是否存在此key
 *                  存在：返回对应的节点的val 在链表中将此节点放到表头
 *                  不存在：返回-1
 */
class LRUCache {

    private int capacity;
    DeLinkedList deLinkedList;
    HashMap<Integer, Node> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        deLinkedList = new DeLinkedList();
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            deLinkedList.nodeToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node node = hashMap.get(key);
            node.val = value;
            deLinkedList.nodeToHead(node);
        } else {
            // 还有空位置
            if (hashMap.size() < capacity) {
                Node node = new Node(key, value);
                hashMap.put(key, node);
                deLinkedList.nodeToHead(node);
            } else {
                Node node = deLinkedList.getTail();
                // 在map中删除value为node的kv对
                hashMap.remove(node.key);
                deLinkedList.delNode(node);
                Node node1 = new Node(key, value);
                hashMap.put(key, node1);
                deLinkedList.nodeToHead(node1);
            }
        }
    }
}

/**
 * 双向链表
 * 假头假尾
 * 构造方法 初始化首尾节点
 */
class DeLinkedList {

    Node dummyHead;
    Node dummyTail;

    public DeLinkedList() {
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    // 将不存在的节点插入到表头 或者将链表中某节点移动到表头
    public void nodeToHead(Node node) {
        if (node.pre != null) {
            delNode(node);
        }
        node.next = dummyHead.next;
        node.next.pre = node;
        node.pre = dummyHead;
        dummyHead.next = node;
    }
    public void delNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }
    // 取表尾的节点
    public Node getTail() {
        if (dummyTail.pre == dummyHead) {
            return null;
        } else {
            return dummyTail.pre;
        }
    }
}

/**
 * 双向链表的节点
 */
class Node {
    int key, val;
    Node next;
    Node pre;

    public Node(){

    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

}
