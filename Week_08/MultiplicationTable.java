/**
 * 九九乘法表
 */
public class MultiplicationTable {

    /**
     *
     */
   public void multiplicationTable(){
       for(int i=1;i<=9;i++) {
           for(int j=1;j<=i;j++) {
               System.out.print(j+"×"+i+"="+i*j+"\t");// \t 跳到下一个TAB位置
           }
           System.out.println();
       }
   }

    /**
     *
     */
    public void multiplicationTableI(){
        for(int i=9;i>0;i--) {
            for(int j=1,k=10-i;j<=i;j++,k++) {
                System.out.print(j+"×"+k+"="+k*j+"\t");// \t 跳到下一个TAB位置
            }
            System.out.println();
        }
    }

}
