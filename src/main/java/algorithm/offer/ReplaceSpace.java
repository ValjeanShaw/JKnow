package algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoran
 * @date 2020/07/03
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {

        if(s == null || s.length()==0){
            return "";
        }
        char[] origin = s.toCharArray();
        int num =0;
        for(Character ch: origin){
            if(ch ==' '){
               num++;
            }
        }
        char[] result = new char[origin.length + 2*num];

        int newIndex = result.length-1;
        int oldIndex = origin.length-1;
        for(;newIndex >=0;){
            if(origin[oldIndex] == ' '){
                result[newIndex--] = '0';
                result[newIndex--] = '2';
                result[newIndex--] = '%';
                oldIndex--;
            }else{
                result[newIndex--] = origin[oldIndex--];
            }
        }

        return String.valueOf(result);
    }
}
