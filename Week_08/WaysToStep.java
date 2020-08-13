/**
 * 三步问题
 */
public class WaysToStep {

    /**
     *
     * @param n
     * @return
     */
    public int waysToStep(int n){
        int[] dp={1,2,3,4};
        int mod=1000000007;
        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%mod;
        }
        return dp[n];
    }
}
