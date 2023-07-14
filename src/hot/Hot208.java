package hot;

import org.junit.Test;

/**
 * @ClassName: Hot208
 * @Description:
 * @Author: zh
 * @DateTime: 2022/10/14 16:32
 * @Version: 1.0
 */
public class Hot208 {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("trie.search(\"apple\") = " + trie.search("apple"));
        System.out.println("trie.search(\"app\") = " + trie.search("app"));
        System.out.println("trie.startsWith(\"app\") = " + trie.startsWith("app"));

    }
}

class Trie {

    class TrieNode {
        private char val;
        private TrieNode[] child;
        boolean isTail; // 是否有字符串以当前节点结尾
        public TrieNode() {
            child = new TrieNode[26];
        }

        public TrieNode(char _val) {
            val = _val;
            child = new TrieNode[26];
        }
    }

    ;

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new TrieNode(c);
            }
            node = node.child[c - 'a'];
        }
        node.isTail = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (node.child[c - 'a'] != null) {
                node = node.child[c - 'a'];
            } else {
                return false;
            }
        }
        for (TrieNode node1 : node.child) {
            if (node1 != null) {
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (node.child[c - 'a'] != null) {
                node = node.child[c - 'a'];
            } else {
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
