/**
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 */
public class PowerOfTwo {

    /**
     * 解题思路：
     * 若 n = 2^xn=2
     * x
     *   且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
     * 恒有 n & (n - 1) == 0，这是因为：
     * nn 二进制最高位为 11，其余所有位为 00；
     * n - 1n−1 二进制最高位为 00，其余所有位为 11；
     * 一定满足 n > 0。
     * 因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n = 2^xn=2
     * x
     *  。
     * 2^x	n	n - 1	n & (n - 1)
     * 2^0
     * 0
     *  	00010001	00000000	(0001) & (0000) == 0
     * 2^1
     * 1
     *  	00100010	00010001	(0010) & (0001) == 0
     * 2^2
     * 2
     *  	01000100	00110011	(0100) & (0011) == 0
     * 2^3
     * 3
     *  	10001000	01110111	(1000) & (0111) == 0
     * ...	...	...	...
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
