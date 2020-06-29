package algorithm.binarytree;

/**
 * @author xiaoran
 * @date 2020/06/15
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     * 给定一个数组，创建出来树
     * @param nums
     * @return
     */
    public static TreeNode createTree(Integer[] nums){
        TreeNode[] tree = new TreeNode[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==null){
                tree[i+1] = null;
            }else{
                TreeNode node = new TreeNode(nums[i]);
                tree[i+1] = node;
            }
        }
        for(int i=1;i<(nums.length+1)/2;i++){
            if(tree[i]!=null){
                tree[i].left = tree[2*i];
                tree[i].right = tree[2*i+1];
            }
        }
        return tree[1];
    }
}
