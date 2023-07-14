package hot;

/**
 * @author: joe
 * @dateTime: 2023/3/17 22:33
 * @description: TODO
 * @version: 1.0
 */
public class Hot208B {
    public static void main(String[] args) {
        Trie1 trie1 = new Trie1();
        trie1.insert("hello");
        System.out.println("trie1.search(\"hell\") = " + trie1.search("hell"));
        System.out.println("trie1.search(\"helloa\") = " + trie1.search("helloa"));
        System.out.println("trie1.search(\"hello\") = " + trie1.search("hello"));
        System.out.println("trie1.startsWith(\"hell\") = " + trie1.startsWith("hell"));
        System.out.println("trie1.startsWith(\"helloa\") = " + trie1.startsWith("helloa"));
        System.out.println("trie1.startsWith(\"hello\") = " + trie1.startsWith("hello"));
    }
}

class Trie1 {

    // 树的节点 字符、下一个字符集、需要表明当前节点是否是结尾
    class Node {
        boolean[] chars;
        Node next;
        boolean end;

        public Node() {
            chars = new boolean[26];
            next = null;
            end = false;
        }
    }

    private Node head;
    public Trie1() {
        head = new Node();
    }

    public void insert(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            Node nextNode = new Node();
            nextNode.chars[c - 'a'] = true;
            cur.next = nextNode;
            cur = cur.next;
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = head.next;
        if (cur == null) {
            return false;
        }
        int wordlen = word.length();
        for (int i = 0; i < wordlen; i++) {
            if (cur == null) {
                return false;
            }
            char c = word.charAt(i);
            if (!cur.chars[c - 'a']) {
                return false;
            }
            if (i == wordlen - 1) {
                return cur.end;
            }
            cur = cur.next;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node cur = head.next;
        if (cur == null) {
            return false;
        }
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            if (!cur.chars[c - 'a']) {
                return false;
            }
            cur = cur.next;
            if (cur == null && i < len - 1) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
