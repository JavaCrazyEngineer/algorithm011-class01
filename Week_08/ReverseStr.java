/**
 * Ã¿¸ô2k¸ö×Ö·û·­×ª×Ö·û´®
 */
public class ReverseStr {

    /**
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] arr=s.toCharArray();
        int n=s.length();
        int i=0;
        while(i<n){
            int j=Math.min(i+k-1,n-1);
            swap(arr, i, j);
            i+=2*k;
        }
        return String.valueOf(arr);
    }

    /**
     *
     * @param arr
     * @param i
     * @param j
     */
    private void swap(char[] arr, int i, int j) {
        while (i<j) {
            char temp = arr[j];
            arr[j++] = arr[i];
            arr[j--] = temp;
        }
    }
}
