/**
 * ClassName: MyPow
 * Description:实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class MyPow {

    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        return fastPow(x,n);
    }

    private double fastPow(double x,int n){
        if(n==0){
            return 1.0;
        }
        double half=fastPow(x,n/2);
        if(n%2==0){//x的偶次方
            return half*half;
        }else{
            return half*half*x;
        }
    }
}
