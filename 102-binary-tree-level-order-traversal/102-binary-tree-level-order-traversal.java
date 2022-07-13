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
    public List<List<Integer>> levelOrder(TreeNode root) {
       Queue<TreeNode>q=new LinkedList<>();
        List<List<Integer>> alist= new LinkedList<List<Integer>>();
        if(root==null)
            return alist;
        q.add(root);
        while(!q.isEmpty())
        {
          int s=q.size();
            List<Integer>al=new LinkedList<>();
            for(int i=0;i<s;i++)
            {
                TreeNode curr=q.poll();
                al.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            alist.add(al);
        }
        return alist;
    }
}