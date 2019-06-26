// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class maximum-difference-between-node-and-ancestor {
    // tc -> n, sc-> n
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        countMaxAncestorDiff(root, root.val, root.val);
        return res;
    }
    
    private void countMaxAncestorDiff(TreeNode node, int max, int min){
        if(node==null) return;
        res = Math.max(res, Math.abs(max-node.val));
        res = Math.max(res, Math.abs(min-node.val));
        if(node.left!=null)
            countMaxAncestorDiff(node.left, Math.max(max, node.left.val), 
                                 Math.min(min, node.left.val));
        if(node.right!=null)
            countMaxAncestorDiff(node.right, Math.max(max, node.right.val), 
                                 Math.min(min, node.right.val));
    }
}
