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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder,inorder,0,inorder.length-1,0);
    }
    TreeNode construct(int[] preorder,int[] inorder,int l,int r,int idx){
        if(l>r) return null;
        TreeNode a = new TreeNode(preorder[idx]);
        int b=-1;
        for(int x=l;x<=r;x++){
            if(inorder[x]==preorder[idx]){
                 b=x;
                 break;
            }
        }
        if(b>l) a.left=construct(preorder,inorder,l,b-1,idx+1);
        if(b<r) a.right =construct(preorder,inorder,b+1,r,idx+b-l+1);
        return a;
    }
}