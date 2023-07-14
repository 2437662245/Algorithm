package leetcodetest;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @ClassName: L460
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/8 16:00
 * @Version: 1.0
 */
public class L460 {

    @Test
    public void test1() {
        String path = "/../";
        String[] split = path.split("/");
        System.out.println(split.length);
    }

    @Test
    public void test() {
        LFUCache cache = new LFUCache(3);

        cache.put(2, 200);
        cache.put(1, 100);

        int i2 = cache.get(2);
        System.out.println("i1 = " + i2);

        int i1 = cache.get(1);
        System.out.println("i1 = " + i1);

        int i22 = cache.get(2);
        System.out.println("i22 = " + i22);

        cache.put(3, 300);
        cache.put(4, 400);

        int i3 = cache.get(3);
        System.out.println("i3 = " + i3);

        int i222 = cache.get(2);
        System.out.println("i222 = " + i222);

        int i11 = cache.get(1);
        System.out.println("i11 = " + i11);


        int i44 = cache.get(4);
        System.out.println("i11 = " + i44);

    }
}


/**
 * 思路：HashMap1中存储 key、node(node中存储key、value、freq)
 *      HashMap2中存储 freq、DeLinkedList(对应频率的节点在此链表中)
 *      全局变量minFreq，当Cache满了要插入的时候，去minFreq对应的双链表中删除节点
 */
class LFUCache {

    class Node {

        private int key;
        private int value;
        private int freq;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }

        public Node(int key, int value, int freq, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.pre = pre;
            this.next = next;
        }

        public void update(int newValue) {
            value = newValue;
        }
    }

    class DeLinkedList {

        Node dummyHead;
        Node dummyTail;

        public DeLinkedList() {
            dummyHead = new Node();
            dummyTail = new Node();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        // 将节点插入到表头
        public void insertToHead(Node node) {
            node.next = dummyHead.next;
            dummyHead.next.pre = node;
            dummyHead.next = node;
            node.pre = dummyHead;
        }
        // 删除节点
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
        // 判断双链表是否为空
        public boolean isEmpty() {
            if (dummyTail.pre == dummyHead) {
                return true;
            } else {
                return false;
            }
        }
    }

    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DeLinkedList> freqMap;
    int minFreq;
    int capacity;

    public LFUCache(int capacity) {
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 1;
        this.capacity = capacity;
    }

    /**
     * @param key
     * @return
     * 在keyMap中不存在此key：
     *      return -1
     * 在keyMap中存在此key：
     *
     *      访问会使得频次+1，处理频次增加后产生的逻辑
     *          根据freq找在freqMap中找到对应的双链表，在此双链表中删除此节点 判断此freq是不是minFreq，如果是并且删除后双链表为空 在freqMap中删除此键值对 minFreq+1
     *          此节点的freq+1
     *          判断+1后的freq是否存在freqMap中，
     *              如果存在
     *                  将节点加入到对应的freq的双链表中
     *              不存在
     *                  创建freqMap的新节点 将此节点加入freqMap新节点的双链表中
     *      返回node的value
     */
    public int get(int key) {
        // 不存在此key的情况
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        // 存在此key的情况
        Node node = keyMap.get(key);
        freqIncrement(node);
        return node.value;
    }

    /**
     *
     *
     * @param key
     * @param value
     *
     *  如果键key 已存在，则变更其值；如果键不存在，请插入键值对。
     *  当缓存达到其容量capacity 时，则应该在插入新项之前，移除最不经常使用的项。
     *  在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最近最久未使用的键。
     *
     *  如果key已经存在
     *      1.更新value
     *      2.访问频次+1
     *      3.将节点从原来访问频次的双链表中删除，加入新的访问频次的双链表
     *  如果key不存在
     *      1.如果容量未满
     *          1.1 插入keyMap中，访问频次初始化为1
     *          1.2.将节点插入到访问频次为1的链表中，如果对应的map节点不存在需要新建
     *      2.如果容量已满
     *          2.1取到访问频次最小的链表
     *              2.1.1 如果访问频次最小的链表不存在，说明Cache的容量为0，直接返回
     *              2.1.2 将链表最后一个节点删除 在keyMap中同步删除
 *                  2.1.3 删除之后如果链表为空了，在freq中删除此频次的键值对 并将minFreq+1
     *          2.2执行1的逻辑
     *          2.3只要插入了新节点，都需要更新minFreq为1
     */
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            freqIncrement(node);
        } else {
            // 容量未满
            if (keyMap.size() < capacity) {
                Node node = new Node(key, value, 1);
                keyMap.put(key, node);
                if (freqMap.containsKey(1)) {
                    freqMap.get(1).insertToHead(node);
                } else {
                    DeLinkedList list = new DeLinkedList();
                    list.insertToHead(node);
                    freqMap.put(1, list);
                }
            } else {
                // 容量已满

                // 取到频率最小的链表
                DeLinkedList minFreqList = freqMap.get(minFreq);
                if (minFreqList == null) {
                    return;
                }
                // 在此链表中删除最后一个节点
                // 获取此链表最后一个节点
                Node tailNode = minFreqList.getTail();
                minFreqList.delNode(tailNode);
                // 在keyMap中删除此节点
                keyMap.remove(tailNode.key);
                // 如果删除后链表为空了 最小频率+1
                if (minFreqList.isEmpty()) {
                    // 删除当前链表
                    freqMap.remove(minFreq);
                    minFreq++;
                }

                Node node = new Node(key, value, 1);
                keyMap.put(key, node);
                if (freqMap.containsKey(1)) {
                    freqMap.get(1).insertToHead(node);
                } else {
                    DeLinkedList list = new DeLinkedList();
                    list.insertToHead(node);
                    freqMap.put(1, list);
                }
            }
            minFreq = 1;
        }
    }

    /**
     * 处理node的频率+1的逻辑
     * @param node
     *
     */
    public void freqIncrement(Node node) {
        // 节点对应的频率
        int keyFreq = node.freq;
        // 取到此频率对应的链表
        DeLinkedList linkedList = freqMap.get(keyFreq);
        // 在此频率对应的链表中删除此节点
        linkedList.delNode(node);
        // 如果删除后链表为空了 将freqMap中这个频率的删除 并且当前最小频率是当前频率，那么最小频率+1
        if (linkedList.isEmpty() && minFreq == keyFreq) {
            minFreq++;
            freqMap.remove(keyFreq);
        }
        // 节点的频率+1
        node.freq++;
        // 将节点插入到新频率对应的map中
        int newFreq = node.freq;
        if (!freqMap.containsKey(newFreq)) {
            DeLinkedList list = new DeLinkedList();
            list.insertToHead(node);
            freqMap.put(newFreq, list);
        } else {
            // freqMap中包含新频率
            freqMap.get(newFreq).insertToHead(node);
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */