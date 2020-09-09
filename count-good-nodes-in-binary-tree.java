// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
class Solution {
    // tc -> n, sc-> n
    public int goodNodes(TreeNode root) {
        return getGoodNodes(root, root.val);
    }
    
    private int getGoodNodes(TreeNode root, int currMax){
        if(root==null) return 0;
        
        currMax = Math.max(currMax, root.val);
        
        int left =  getGoodNodes(root.left, currMax);
        int right = getGoodNodes(root.right, currMax);
        
        return left + right + (root.val >= currMax ? 1 : 0);
    }
    
}
