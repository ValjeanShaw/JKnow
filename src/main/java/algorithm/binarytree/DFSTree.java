package algorithm.binarytree;

import java.util.Stack;

/**
 * 使用非递归方式实现二叉树的先中后序遍历
 *
 * @author xiaoran
 * @date 2020/06/17
 */
public class DFSTree {
    public static void main(String[] args) {
        DFSTree dfsTree = new DFSTree();
        TreeNode root = TreeNode.createTree(new Integer[]{1,2,2,null,3,null,3});
        System.out.println("先序:");
        dfsTree.preOrder(root);
        System.out.println("\n中序:");
        dfsTree.midOrder(root);
        System.out.println("\n后序:");

    }

    /**
     * 先序遍历
     * @param root
     */
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode node = stack.pop();
            System.out.print(node.val+"-");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void midOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || !stack.empty() ){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                System.out.print(root.val+"-");
                root = root.right;
            }
        }
    }

}
