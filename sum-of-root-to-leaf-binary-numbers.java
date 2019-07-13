// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class sum-of-root-to-leaf-binary-numbers {
    // tc -> n, sc-> n
    class Res{
        int sum;
    }
    public int sumRootToLeaf(TreeNode root) {
        Res res = new Res();
        sumRootToLeaf(root,0, res);
        return res.sum;
    }
    
    private void sumRootToLeaf(TreeNode node, int val, Res res){
        if(node==null) return;
        if(node.left==null && node.right==null)
        res.sum += val*2 + node.val;
        sumRootToLeaf(node.left, val*2+node.val, res);
        sumRootToLeaf(node.right, val*2+node.val, res);
    }
}
