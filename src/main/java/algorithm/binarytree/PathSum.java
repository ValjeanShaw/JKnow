package algorithm.binarytree;

/**
 * 当年面试 360的真题
 * <p>
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @author xiaoran
 * @date 2020/06/16
 */
public class PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        order(root,sum);
        return flag;
    }

    boolean flag = false;

    public void order(TreeNode node, int sum) {
        if (node == null) {
            return;
        } else {
            sum -= node.val;
            if(node.left == null && node.right == null){
                //叶子节点
                if(sum == 0){
                    flag = true;
                }
            }else{
                order(node.left,sum);
                order(node.right,sum);
            }
        }
    }
}
