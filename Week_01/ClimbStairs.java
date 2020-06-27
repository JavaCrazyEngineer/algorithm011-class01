/**
 * ClassName: ClimbStairs
 * Description:爬楼梯
 *
 * @author G20200343080265
 * @date 2020/06/27
 */
public class ClimbStairs {

    /**
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if(n==0||n==1){
            return 1;
        }
        int step0=1,step1=1,step=0;
        for(int i=2;i<=n;i++){
            step=step0+step1;
            step0=step1;
            step1=step;
        }
        return step;
    }
}
