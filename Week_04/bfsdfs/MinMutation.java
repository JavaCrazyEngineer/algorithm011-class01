package bfsdfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 基因序列 BFS
 */
public class MinMutation {

    /**
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {

        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        for (String num : bank) {
            bankSet.add(num);
        }

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end)) {//找到了
                    return level;
                }

                char[] charArray = curr.toCharArray();
                for(int c=0;c<charArray.length;c++){
                    char old=charArray[c];
                    for(char ch:charSet){
                        charArray[c]=ch;
                        String next=new String(charArray);
                        if(!visited.contains(next)&&bankSet.contains(next)){
                           visited.add(next);
                           queue.offer(next);//add last
                        }
                    }
                    charArray[c]=old;
                }
            }
            level++;
        }
        return -1;
    }
}
