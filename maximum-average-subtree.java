https://leetcode.com/problems/maximum-average-subtree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class maximum-average-subtree {
    // tc -> n, sc -> n
    double res;
    public double maximumAverageSubtree(TreeNode root) {
        res = 0;
        calcMaxAvg(root);
        return res;
    }
    
    private double[] calcMaxAvg(TreeNode node){
        if(node==null) return new double[]{0,0};
        double count = 1;
        double sum = node.val;
        double[] left = calcMaxAvg(node.left);
        double[] right = calcMaxAvg(node.right);
        count += left[0] + right[0];
        sum += left[1] + right[1];
        res = Math.max(res, sum/count);
        return new double[]{count, sum};
    }
}
