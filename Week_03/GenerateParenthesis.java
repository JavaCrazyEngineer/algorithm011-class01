import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenerateParenthesis
 * Description:生成有效的括号
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> generateList=new ArrayList<>();
        generate(0,0,n,"",generateList);
        return generateList;
    }

    private void generate(int left,int right,int n,String generateValue,List<String> generateList){
        if(left==n&&right==n){
            generateList.add(generateValue);
            return;
        }
        if(left<n){
            generate(left+1,right,n,generateValue+"(",generateList);
        }
        if(left>right){
            generate(left,right+1,n,generateValue+")",generateList);
        }
    }
}
