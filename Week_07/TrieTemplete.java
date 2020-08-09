/**
 * ClassName: TrieTemplete
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/08/09
 */
public class TrieTemplete {

    private boolean isEnd;

    private TrieTemplete[] next;

    public TrieTemplete() {
        isEnd = false;
        next = new TrieTemplete[26];
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieTemplete curr = this;
        char[] words = word.toCharArray();

        for (int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) {
                curr.next[n] = new TrieTemplete();
            }
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }

    public boolean search(String word){
        TrieTemplete node= searchPrefix(word);
        return node!=null&&node.isEnd;
    }

    public boolean startsWith(String prefix){
        TrieTemplete node= searchPrefix(prefix);
        return node!=null;
    }

    private TrieTemplete searchPrefix(String word){
        TrieTemplete node=this;
        char[] words=word.toCharArray();
        for(int i=0;i<words.length;i++){
            node=node.next[words[i]-'a'];
            if(node==null){
                return null;
            }
        }
        return node;
    }
}
