/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class DecodeWays {

    /**
     * @param s
     * @return
     */
    public int numDecoding(String s) {

        int n = s.length();
        int[] dp = new int[n];
        if (s.charAt(0) == '0') {
            return 0;
        }
        //dp[i]代表前i个字符的解码方式
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != 0) {
                dp[i] += dp[i - 1];//前i-1个字符的解码方式加上自身
            }
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                if (i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i]++;
                }
            }
        }
        return dp[n-1];
    }
}
