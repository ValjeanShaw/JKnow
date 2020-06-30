package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *   同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * @author xiaoran
 * @date 2020/06/30
 */
public class Isomorphic {

    public static void main(String[] args) {
        Isomorphic isomorphic = new Isomorphic();
        System.out.println(isomorphic.isIsomorphic("ab","aa"));
    }

    public boolean isIsomorphic(String s, String t) {
        if(s==null && t == null){
            return true;
        }
        if((s==null || t==null) || s.length()!=t.length()){
            return false;
        }

        char[] sc  = s.toCharArray();
        char[] tc  = t.toCharArray();

        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for (int i = 0; i < sc.length; i++) {
            Character k1 = sc[i];
            Character k2 = tc[i];
            if((map1.containsKey(k1)&&!map1.get(k1).equals(k2))
                    || (map2.containsKey(k2)&&!map2.get(k2).equals(k1))){
                return false;
            }
            map1.put(k1,k2);
            map2.put(k2,k1);
        }
        return true;
    }
}
