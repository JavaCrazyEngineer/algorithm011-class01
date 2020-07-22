import java.util.Arrays;

/**
 * 分发饼干
 */
public class AssignCookies {

    /**
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i=0;
        for(int j=0;j<g.length&&i<s.length;j++){
            if(g[j]<=s[i]){
                i++;
            }
        }
        return i;
    }
}
