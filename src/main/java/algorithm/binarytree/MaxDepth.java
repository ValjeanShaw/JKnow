package algorithm.binarytree;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author xiaoran
 * @date 2020/06/16
 */
public class MaxDepth {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createTree(nums);

        MaxDepth md = new MaxDepth();
        System.out.println(md.maxDepth(root));
    }

    int maxDep = 0;
    public int maxDepth(TreeNode root) {
        calmaxDepth(root,0);
        return maxDep;
    }

    public void calmaxDepth(TreeNode root,int nowDep){
        if(root==null){
            return;
        }else{
            nowDep++;
            maxDep = Math.max(nowDep,maxDep);
            calmaxDepth(root.left,nowDep);
            calmaxDepth(root.right,nowDep);
        }
    }
}
