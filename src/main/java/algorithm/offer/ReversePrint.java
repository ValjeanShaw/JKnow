package algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoran
 * @date 2020/07/03
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }


        int arr[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(list.size()-1-i);
        }
        return arr;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}