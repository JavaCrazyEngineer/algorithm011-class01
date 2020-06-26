/**
 * ClassName: PlusOne
 * Description:加一
 *
 * @author G20200343080265
 * @date 2020/06/26
 */
public class PlusOne {

    /**
     * 每一个数组下标位置取值范围 [0~9]
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        for(int i=digits.length-1;i>=0;i--){
            digits[i]=(++digits[i])%10;//先加1
            if(digits[i]!=0){//是否满足 满10进位的情况 例：(9+1=10)%10==0
                return digits;
            }
        }
        //例如 999+1 ，会满足以下情况；长度加1 高位为1 =1000
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {

        int[] digits={9,9,9};
        digits=new PlusOne().plusOne(digits);

        for(int i=0;i<digits.length;i++){
            System.out.print(digits[i]);
        }
    }
}
