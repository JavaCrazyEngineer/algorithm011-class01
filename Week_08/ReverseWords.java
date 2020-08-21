import java.util.Arrays;
import java.util.Collections;

/**
 * ‰»Î the sky is blue
 * ‰≥ˆ blue is sky the
 */
public class ReverseWords {

    /**
     *
     * @param words
     * @return
     */
    public String reverseWords(String words){
        String[] wordArray=words.trim().split(" +");
        Collections.reverse(Arrays.asList(wordArray));
        return String.join(" ",wordArray);
    }
}
