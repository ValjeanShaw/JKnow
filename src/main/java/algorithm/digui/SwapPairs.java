package algorithm.digui;

/**
 * @author xiaoran
 * @date 2020/05/09
 *
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        SwapPairs swapPairs = new SwapPairs();
        ListNode head = swapPairs.swapPairs(listNode1);
        System.out.println(head);
    }

    public ListNode swapPairs(ListNode head) {
        //结束条件
        if(head == null || head.next == null){
            return head;
        }
        //重命名一下
        ListNode current = head;
        ListNode nextToPre = head.next;

        //下一个节点的关系  认为下一个节点已经转换好了
        ListNode temp = swapPairs(current.next.next);


        //执行当前的转换逻辑
        current.next = temp;
        nextToPre.next = current;

        return nextToPre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}