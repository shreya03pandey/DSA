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
    int pre=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return build(n,preorder,inorder,0,n-1);
    }
    public TreeNode build(int n,int[] preorder, int[] inorder,int pi,int ni)
    {
        if(pi>ni)
            return null;
      TreeNode root=new TreeNode(preorder[pre++]);
        int idx=-1;
        for(int i=0;i<n;i++)
        {
            if(inorder[i]==root.val)
            {
               idx=i;
               break;
            }
        }
        root.left=build(n,preorder,inorder,pi,idx-1);
        root.right=build(n,preorder,inorder,idx+1,ni);
        return root;
    }
}