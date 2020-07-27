/**
 * 求 1-n的和
 */
public class AddSum {

    /**
     * @param n
     * @return
     */
    public int addSum(int n) {
        if (n == 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return (n + 1) * n >> 1;
    }

    public static void main(String[] args) {
        System.out.println(new AddSum().addSum(100));
    }
}
