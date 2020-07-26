/**
 * int sqrt(int x)
 * 计算并返回x的平方根，其中x非负数
 * <p>
 * 例：
 * 输入：4 输出：2
 */
public class Sqrt {

    /**
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1, right = x;
        int mid = 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
