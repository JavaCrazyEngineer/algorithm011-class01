package week03_2;

/**
 * 计算x的n次幂函数
 */
public class MyPow {

    /**
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if(n<0){
            x=1/x;
            n=-n;
        }

        return fastPow(x,n);
    }

    /**
     *
     * @param x
     * @param n
     * @return
     */
    private double fastPow(double x, int n) {

        if(n==0){
            return 1.0;
        }
        double half=fastPow(x,n/2);

        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
}
