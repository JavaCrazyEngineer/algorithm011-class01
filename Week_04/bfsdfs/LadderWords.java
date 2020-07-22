package bfsdfs;

import javafx.util.Pair;

import java.util.*;

/**
 * 单词接龙
 */
public class LadderWords {

    /**
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)){
            return 0;
        }

        int len=beginWord.length();
        Map<String,List<String>> allCombDict=new HashMap<>();

        wordList.forEach(curWord->{
            for(int i=0;i<len;i++){
                String combWord=curWord.substring(0,i)+"*"+curWord.substring(i+1);

                List<String> comboList=allCombDict.getOrDefault(combWord,new ArrayList<>());

                comboList.add(curWord);
                allCombDict.put(combWord,comboList);
            }
        });

        Queue<Pair<String,Integer>> queue=new LinkedList<>();

        Map<String,Boolean> hasVisited=new HashMap<>();


        queue.add(new Pair<>(beginWord,1));
        hasVisited.put(beginWord,true);

        while(!queue.isEmpty()){

            Pair<String,Integer> node=queue.poll();

            String currWord=node.getKey();

            int level= node.getValue();

            for(int i=0;i<len;i++){

               String  currComboWord=currWord.substring(0,i)+"*"+currWord.substring(i+1);

               List<String> currComboList=allCombDict.getOrDefault(currComboWord,new ArrayList<>());

               for(String word : currComboList){
                   // 包含目标单词，说明当前单词能一次转换到目标单词，经历的步骤数是当前单词的层级 + 1
                   if (word.equals(endWord))
                       return level + 1;
                   // 否则，当前单词能得到这个单词，如果它还没被访问过
                   // if (!hasVistedList.contains(word)){
                   // HashMap.containsKey方法效率远高于ArrayList.contains
                   if (!hasVisited.containsKey(word)){
                       // 把这个单词加入到队列中
                       queue.add(new Pair<>(word, level + 1));
                       // 标记它为已访问
                       // hasVistedList.add(word);
                       hasVisited.put(word, true);
                   }
               }

            }
        }
        return 0;
    }
}
