package week01_2;

public class ClimbStairs {

    /**
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int first=1,second=2,step=0;
        for(int i=2;i<n;i++){
            step=first+second;
            first=second;
            second=step;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(5));
    }
}
