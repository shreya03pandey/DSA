/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
      return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);  
    }
    public boolean valid(TreeNode root,long l,long r)
    {
        if(root==null)
            return true;
        if( Long.valueOf(root.val)<=l || Long.valueOf(root.val)>=r)
            return false;
        Boolean left=valid(root.left,l,Long.valueOf(root.val));
        Boolean right=valid(root.right,Long.valueOf(root.val),r);
        return left&&right;
    }
}