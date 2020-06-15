package algorithm.link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 * 使用队列做辅助
 *
 * 按行打印，需要两个变量进行辅助
 *
 * @author xiaoran
 * @date 2020/06/15
 */
public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        //levelOrder.levelOrder()
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> allList = new ArrayList<>();
        if(root ==null){
            return allList;
        }else{
            queue.offer(root);
        }
        int start = 0;
        int end = 1;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){

            TreeNode now = queue.poll();
            list.add(now.val);
            if(now.left!=null){
                queue.offer(now.left);
            }
            if(now.right!=null){
                queue.offer(now.right);
            }
            start++;
            if(start == end){
                allList.add(list);
                list = new ArrayList<>();
                start = 0;
                end = queue.size();
            }
        }
        return allList;
    }
}

