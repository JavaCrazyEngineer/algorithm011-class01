import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * BFS最短路径
 */
public class ShortPathBFS {

    /**
     *
     * @param start
     * @param target
     * @return
     */
    int bfs(Node start, Node target) {
        Queue<Node> queue = new LinkedList<>();//核心数据结构
        Set<Node> visited = new HashSet<>();//避免走回头路
        queue.offer(start);//将起点加入队列
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //将当前队列中的所有节点向四周扩散
            for (int i = 0; i < queue.size(); i++) {
                Node cur = queue.poll();
                //这里判断是否到达终点
                if (cur.val == target.val) {
                    return step;
                }
                //将cur的相邻节点加入队列
                for (Node childNode : cur.children) {
                    if (!visited.contains(childNode)) {
                        queue.offer(childNode);
                        visited.add(childNode);
                    }
                }
            }
            //划重点，更新步数在这里
            step++;
        }
        return step;
    }
}
