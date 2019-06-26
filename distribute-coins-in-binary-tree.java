// https://leetcode.com/problems/distribute-coins-in-binary-tree/
/**
 * Definition for a binary tree node.
 * public class distribute-coins-in-binary-tree {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // tc -> n, sc-> n
    int res = 0;
    public int distributeCoins(TreeNode root) {
        doDistributionOfCoins(root);
        return res;
    }
    
    private int doDistributionOfCoins(TreeNode root){
        if(root==null) return 0;
        int left = doDistributionOfCoins(root.left);
        int right = doDistributionOfCoins(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val+left+right-1;        
    }
}
