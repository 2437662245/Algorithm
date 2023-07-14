package hot;

import java.util.HashMap;

/**
 * @author: joe
 * @dateTime: 2023/3/13 17:09
 * @description: TODO
 * @version: 1.0
 */
public class Hot146B {
    public static void main(String[] args) {

        LRUCache1 lru = new LRUCache1(2);
        lru.put(1, 0);
        lru.put(2, 2);
        int get1 = lru.get(1);
        System.out.println("lru.get(1) = " + get1);
        lru.put(3, 3);
        int get2 = lru.get(2);
        System.out.println("lru.get(1) = " + get2);
        lru.put(4, 4);
        int get11 = lru.get(1);
        System.out.println("lru.get(1) = " + get11);
        int get3 = lru.get(3);
        System.out.println("lru.get(1) = " + get3);
        int get4 = lru.get(4);
        System.out.println("lru.get(1) = " + get4);
    }
}

class LRUCache1 {
    // LRU 使用链表+HashMap实现 链表节点中存储key val，Map中存Key，Node  get去map中查，并将该节点移到表头，put

    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Node dummyHead;
    Node dummyTail;
    HashMap<Integer, Node> map;
    int size;

    LRUCache1(int capacity) {
        this.capacity = capacity;
        dummyHead = new Node(0, 0);
        dummyTail = new Node(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        map = new HashMap<>();
        size = 0;   // 实际元素个数
    }

    public int get(int key) {
        // 获取元素
        // 1.不存在 直接返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        // 2.存在，将此节点移动到表头，返回值
        Node keyNode = map.get(key);
        int res = keyNode.val;
        moveToHead(keyNode);
        return res;
    }

    public void put(int key, int value) {
        // 插入元素
        // 1.如果存在，变更值，移动到表头
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }
        Node node1 = new Node(key, value);
        // 2.如果不存在，直接插入到表头
        if (size < capacity) {
            insertToHead(node1);
            map.put(key, node1);
            size++;
        } else {
            // 3.如果不存在，且容量不足，移除表尾，插入到表头
            Node tailNode = delNode(dummyTail.pre);
            map.remove(tailNode.key);
            insertToHead(node1);
            map.put(key, node1);
        }
    }

    // 将node移动到表头
    public void moveToHead(Node node) {
        if (dummyHead.next == node) {
            return;
        }
        // 从原位置删除此节点
        delNode(node);
        // 插入到表头
        insertToHead(node);
    }

    public Node delNode(Node node) {
        if (node == dummyHead || node == dummyTail) {
            return null;
        }
        // 从原位置删除此节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }
    // 将node节点插入到表头
    public void insertToHead(Node node) {
        node.next = dummyHead.next;
        dummyHead.next.pre = node;
        node.pre = dummyHead;
        dummyHead.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
