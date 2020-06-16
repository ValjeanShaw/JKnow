package algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *[1,2,2,2,null,2]
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @author xiaoran
 * @date 2020/06/16
 */
public class MirrorTree {
    public static void main(String[] args) {
        MirrorTree mt = new MirrorTree();
        TreeNode root = TreeNode.createTree(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(mt.isSymmetric(root));
        root = TreeNode.createTree(new Integer[]{1,2,2,2,null,2});
        System.out.println(mt.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root){
        return isMirror(root,root);
    }


    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return t1.val==t2.val && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

}
