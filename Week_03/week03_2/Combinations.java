package week03_2;
import java.util.ArrayList;
import java.util.List;
/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combinations {

    /**
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> combines=new ArrayList<>();

        combine(combines,new ArrayList<Integer>(),1,n,k);

        return combines;
    }

    /**
     *
     * @param combines
     * @param combine
     * @param i
     * @param n
     * @param k
     */
    private void combine(List<List<Integer>> combines, ArrayList<Integer> combine, int i, int n, int k) {

        if(k==0){
            combines.add(new ArrayList<>(combine));
        }

        for(int c=i;c<=n;c++){
            combine.add(c);
            combine(combines,combine,c+1,n,k-1);
            combine.remove(combine.size()-1);
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(5,3));
    }
}
