// https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
class Solution {
    // tc -> n, sc-> n
    public TreeNode findNeartestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean isFound = false;
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                if(node.left!=null){
                    if(isFound) return node.left;
                    q.offer( node.left);
                    if(node.left==u) isFound = true;
                }
                
                if(node.right!=null){
                    if(isFound) return node.right;
                    q.offer(node.right);
                    if(node.right==u) isFound = true;
                }
            }
            
        }
        
        return null;
    }
}
