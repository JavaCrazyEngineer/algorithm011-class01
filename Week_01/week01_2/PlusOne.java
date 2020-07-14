package week01_2;

public class PlusOne {

    /**
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        for(int i=digits.length-1;i>=0;i--){

            digits[i]=(++digits[i])%10;
            if(digits[i]!=0){//例如  111】、222
                return digits;
            }
        }
        //例如 999
        int[] result=new int[digits.length+1];
        result[0]=1;
        return digits;
    }


    public static void main(String[] args) {

    }
}
