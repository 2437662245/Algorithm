package leetcodetest;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName: LFUCache2
 * @Description:
 * @Author: zh
 * @DateTime: 2022/11/27 22:23
 * @Version: 1.0
 */
public class L460two {


    @Test
    public void test() {
        LFUCache2 cache = new LFUCache2(3);

        cache.put(1, 100);

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


class LFUCache2 {
    /**
     keyMap存放(key, node) node存放 key val freq
     freqMap存放(freq, node)

     get
     判断keymap中是否有此key
     1.没有 返回-1
     2.有   找到对应的节点，返回节点的值。在返回之前需要做以下操作
     2.1 将node从当前freq的map中移除，如果移除之后此freq对应链表长度为0，则从freqmap中移除此键值对 如果当前freq最小，则minFreq+1
     2.2 将node添加到freq+1的map中，如果此freq的map不存在，则创建此freq的map
     put
     判断keymap中是否有此key
     1.有 将key对应的节点val更改为value
     1.1 将node从当前freq的map中移除，如果移除之后此freq对应链表长度为0，则从freqmap中移除此键值对
     1.2 将node添加到freq+1的map中，如果此freq的map不存在，则创建此freq的map
     2.没有
     1.1 容量足够
     1.1.1 freqMap中存在freq为1的链表，则将新节点插入到表头
     1.1.2 freqMap中不存在freq为1的链表，创建freq为1的链表，freqMap中插入此键值队，最小频率置为1
     1.2 容量不足
     1.2.1 从minFreq对应的链表中删除最后一个节点，在keyMap中，删除此节点 如果此freq对应链表长度为0 删除此freq的键值对
     1.2.2 freqMap中不存在freq为1的链表，创建freq为1的链表，freqMap中插入此键值队，最小频率置为1
     */
    class Node {

        int key;
        int val;
        int freq;
        Node pre;
        Node next;

        Node() {}

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    class DeLinkedList {
        Node dummyHead;
        Node dummyTail;
        int len;
        DeLinkedList() {
            dummyHead = new Node();
            dummyTail = new Node();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            len = 0;
        }
        // 删除节点
        void delNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            len--;
        }
        // 向链表头增加节点
        void addNode(Node node) {
            node.next = dummyHead.next;
            dummyHead.next.pre = node;
            node.pre = dummyHead;
            dummyHead.next = node;
            len++;
        }
        // 获取表尾节点
        Node getTail() {
            return dummyTail.pre;
        }
        // 删除表尾节点 并返回此节点的key
        void delTail() {
            if (len == 0) {
                return;
            }
            dummyTail.pre = dummyTail.pre.pre;
            dummyTail.pre.next = dummyTail;
            len--;
        }
    }

    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DeLinkedList> freqMap;
    int size;
    int capacity;
    int minFreq;
    public LFUCache2(int capacity) {
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        minFreq = 0;
    }

    public int get(int key) {
        // 1.如果key不存在缓存中 返回-1
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        // 2.key存在于缓存中，拿到key对应的节点
        Node node = keyMap.get(key);
        // 3.拿到node的freq对应的链表
        DeLinkedList list = freqMap.get(node.freq);
        // 4.从此链表中删除node
        delNodeWithFreqMap(list, node);
        // 5.节点访问频率+1
        node.freq++;
        // 6.在新频率对应链表中添加此节点
        addNodeWithFreqMap(node);
        return node.val;
    }

    public void put(int key, int value) {
        /**

         判断keymap中是否有此key
         1.有 将key对应的节点val更改为value
         1.1 将node从当前freq的map中移除，如果移除之后此freq对应链表长度为0，则从freqmap中移除此键值对
         1.2 将node添加到freq+1的map中，如果此freq的map不存在，则创建此freq的map
         2.没有
         1.1 容量足够
         1.1.1 freqMap中存在freq为1的链表，则将新节点插入到表头
         1.1.2 freqMap中不存在freq为1的链表，创建freq为1的链表，freqMap中插入此键值队，最小频率置为1
         1.2 容量不足
         1.2.1 从minFreq对应的链表中删除最后一个节点，在keyMap中，删除此节点 如果此freq对应链表长度为0 删除此freq的键值对
         1.2.2 freqMap中不存在freq为1的链表，创建freq为1的链表，freqMap中插入此键值队，最小频率置为1
         */
        // key已经存在于缓存之中 更改其值
        if (capacity == 0) {
            return;
        }
        if (keyMap.containsKey(key)) {
            // 1.拿到key对应的节点
            Node node = keyMap.get(key);
            // 2.拿到node的freq对应的链表
            DeLinkedList list = freqMap.get(node.freq);
            // 3.从此链表中删除node
            delNodeWithFreqMap(list, node);
            // 4.节点访问频率+1
            node.freq++;
            // 5.在新频率对应链表中添加此节点
            addNodeWithFreqMap(node);
            node.val = value;
            return;
        }
        // key不存在
        Node newNode = new Node(key, value, 1);
        keyMap.put(key, newNode);
        // 容量够时
        if (size < capacity) {
            addNodeWithFreqMap(newNode);
        } else {
            // 容量不足时
            DeLinkedList minFreqList = freqMap.get(minFreq);
            Node tailNode = minFreqList.getTail();
            keyMap.remove(tailNode.key);
            minFreqList.delTail();
            if (minFreqList.len == 0) {
                freqMap.remove(minFreq);
            }
            addNodeWithFreqMap(newNode);
        }
        minFreq = 1;
        size++;
    }

    // 删除节点同时 操作freqMap
    public void delNodeWithFreqMap(DeLinkedList list, Node node) {
        list.delNode(node);
        // 如果链表删除之后
        if (list.len == 0) {
            freqMap.remove(node.freq);
            if (minFreq == node.freq) {
                minFreq++;
            }
        }
    }

    // 增加节点
    public void addNodeWithFreqMap(Node node) {
        int nodeFreq = node.freq;
        if (!freqMap.containsKey(nodeFreq)) {
            freqMap.put(nodeFreq, new DeLinkedList());
        }
        freqMap.get(nodeFreq).addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */