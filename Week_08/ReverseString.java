/**
 * ·­×ª×Ö·û´®
 */
public class ReverseString {

    /**
     *
     * @param ch
     */
    public void reverseString(char[] ch){
        if(ch==null){
            return;
        }
        for(int i=0,j=ch.length-1;i<j;++i,j--){
            char temp=ch[j];ch[j]=ch[i];ch[i]=temp;
        }
    }
}
