package algorithm.dp;

/**
 *
 * leetcode 213  打家劫舍2
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * @author xiaoran
 * @date 2020/05/25
 */
public class Steal3 {

//    public int rob(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//
//    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}