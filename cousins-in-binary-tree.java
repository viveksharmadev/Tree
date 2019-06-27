// https://leetcode.com/problems/cousins-in-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class cousins-in-binary-tree {
    // tc -> n, sc-> n
    // Using HashMap
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, int[]> map = new HashMap<>();
        buildMap(root, x, 0, null, map);
        buildMap(root, y, 0, null, map);
        return map.get(x)[0]!=map.get(y)[0] && map.get(x)[1]==map.get(y)[1];
    }
    
    private void buildMap(TreeNode node, int val, int level, TreeNode parent, Map<Integer, int[]> map){
        if(node==null) return;  
        map.putIfAbsent(val,new int[2]);
        if(parent!=null && node.val==val){            
            map.get(val)[0] = parent.val;
            map.get(val)[1] = level;           
        }
        buildMap(node.left, val, level+1, node, map);
        buildMap(node.right, val, level+1, node, map);
    }  
    
    // Using Object
    // tc -> n, sc-> n
    class Node{
        int depth;
        TreeNode parent;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        Node node1 = getCousineNode(new Node(), root, x, 0, null);
        Node node2 = getCousineNode(new Node(), root, y, 0, null);
        return node1.parent!=node2.parent && node1.depth==node2.depth;
    }
    
    private Node getCousineNode(Node node, TreeNode root, int val, int level, 
                               TreeNode parent){
        if(root==null) return null;
        if(root.val==val){
            node.parent = parent;
            node.depth = level;
        }
        getCousineNode(node, root.left, val, level+1, root);
        getCousineNode(node, root.right, val, level+1, root);
        return node;
    }    
}
