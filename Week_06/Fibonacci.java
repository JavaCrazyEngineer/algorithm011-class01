/**
 *
 */
public class Fibonacci {


    int[] fib_cache = new int[31];

    /**
     * 记忆化搜索
     * @param n
     * @return
     */
    int fib(int n) {

        if (n <= 1) {
            return n;
        } else if (fib_cache[n] != 0) {
            return fib_cache[n];
        } else {
            return fib_cache[n] = fib(n - 1) + fib(n - 2);
        }
    }

    /**
     *
     */
    private Integer[] memo;

    public int fib2(int N) {
        memo = new Integer[N + 1];
        return helper(N);
    }

    private int helper(int N) {
        if (memo[N] != null) return memo[N];
        if (N <= 1) {
            memo[N] = N;
            return N;
        }
        memo[N] = helper(N - 1) + helper(N - 2);
        return memo[N];
    }
}
