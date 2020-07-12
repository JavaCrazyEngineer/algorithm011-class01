import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Combine
 * Description:给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author G20200343080265
 * @date 2020/07/12
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> combs = new ArrayList<List<Integer>>();

        combine(combs,new ArrayList<Integer>(),1,n,k);
        return combs;
    }

    /**
     *
     * @param combs
     * @param comb
     * @param start
     * @param n
     * @param k
     */
    private void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(0==k){
            combs.add(new ArrayList<Integer>(comb));
            return;
        }

        for(int i=start;i<=n;i++){
            comb.add(i);
            combine(combs,comb,i+1,n,k-1);
            comb.remove(comb.size()-1);
        }
    }
}
