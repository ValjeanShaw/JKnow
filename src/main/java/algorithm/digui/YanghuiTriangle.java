package algorithm.digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author xiaoran
 * @date 2020/05/11
 */
public class YanghuiTriangle {

    public static void main(String[] args) {
        YanghuiTriangle yanghuiTriangle = new YanghuiTriangle();
        List<List<Integer>> list = yanghuiTriangle.generate(5);

        list.stream().forEach(e-> System.out.println(e));
    }

    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0){
            return new ArrayList<>();
        }
        //结束条件
        if(numRows == 1 ){
            List<Integer> currentList = new ArrayList<>();
            currentList.add(1);

            List<List<Integer>> list = new ArrayList<>();
            list.add(currentList);
            return list;
        }else{
            //n 和 n-1 的关系
            List<List<Integer>> allList = generate(numRows - 1);
            List<Integer> lastList = allList.get(numRows-2);
            List<Integer> currentList = new ArrayList<>();
            currentList.add(1);
            for(int i=1;i<numRows-1;i++){
                currentList.add(lastList.get(i-1)+lastList.get(i));
            }
            currentList.add(1);

            allList.add(currentList);
            return allList;
        }
    }


    public List<Integer> getRow(int rowIndex) {
        //递归结束条件
        if(rowIndex == 0){
            return new ArrayList<>(Arrays.asList(1));
        }
        if(rowIndex == 1){
            return new ArrayList<>(Arrays.asList(1,1));
        }
        
        //n 和 n-1 的关系
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=1;i<rowIndex;i++){
            List<Integer> lastList = getRow(rowIndex-1);
            list.add(lastList.get(i-1)+lastList.get(i));
        }
        list.add(1);
        return list;
    }
}
