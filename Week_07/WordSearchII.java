import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 212. 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 */
public class WordSearchII {

    Set<String> res = new HashSet<String>();

    /**
     * 1、all words->Trie 构建字典树 prefix
     * 2、二维矩阵 dfs,dfs产生的子串 去 Trie中查找 匹配就输出 不匹配就不输出（遍历二维矩阵，以每一个字符作为起点 上下左右遍历扩散；扩散出来的单词去字典树匹配查找）
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = words.length;
        int n = words[0].length();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * @param board
     * @param visited
     * @param s
     * @param i
     * @param j
     * @param trie
     */
    private void dfs(char[][] board, boolean[][] visited, String s, int i, int j, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        s += board[i][j];
        if (!trie.startsWith(s)) {
            return;
        }
        if (trie.search(s)) {
            res.add(s);
        }
        visited[i][j] = true;
        dfs(board, visited, s, i - 1, j, trie);
        dfs(board, visited, s, i + 1, j, trie);
        dfs(board, visited, s, i, j - 1, trie);
        dfs(board, visited, s, i, j + 1, trie);
        visited[i][j] = false;
    }
}
