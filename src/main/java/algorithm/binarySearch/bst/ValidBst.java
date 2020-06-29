package algorithm.binarySearch.bst;

import algorithm.binarytree.TreeNode;

/**
 *
 * 判断是否是二叉搜索树
 *
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *      https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author xiaoran
 * @date 2020/06/29
 */
public class ValidBst {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }

    /**
     * 递归，二叉树框架，只需增加参数，判断当前值与最大值最小值的大小即可
     * @param node
     * @return
     */
    public boolean isValidBST(TreeNode node,TreeNode minNode,TreeNode maxNode) {
        //当前节点为空，直接返回true
        if(node == null){
            return true;
        }
        //判断当前节点是否在当前节点允许的最大值和最小值之间
        if(minNode!=null && node.val <= minNode.val){
            return false;
        }
        if(maxNode!=null && node.val >= maxNode.val){
            return false;
        }

        return isValidBST(node.left,minNode,node) && isValidBST(node.right,node,maxNode);

    }
}
