/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        Pair t = f(root);
        return t.y;
    }
    
    Pair f(TreeNode node) {
        if(node==null) return new Pair(0,0);
        else if(node.left==null && node.right==null) {
            return new Pair(0,0);
        } else if(node.left==null) {
            Pair t = f(node.right);
            if(node.right.val == node.val) {
                return new Pair(t.x+1, Math.max(t.x+1, t.y));
            } else {
                return new Pair(0, t.y);
            }
        } else if(node.right==null) {
            Pair t = f(node.left);
            if(node.left.val == node.val) {
                return new Pair(t.x+1, Math.max(t.x+1, t.y));
            } else {
                return new Pair(0, t.y);
            }
        } else {
            Pair t1 = f(node.left);
            Pair t2 = f(node.right);
            int x = 0, xx = 0;
            if(node.left.val==node.val) { x=Math.max(x, t1.x+1); xx+=t1.x+1; }
            if(node.right.val==node.val) { x=Math.max(x, t2.x+1); xx+=t2.x+1; }
            return new Pair(x, Math.max(xx, Math.max(x,Math.max(t1.y, t2.y))));
        }
    }
    
    class Pair {
        // maximum including itself, global maximum
        int x;
        int y;
        Pair(int x, int y) {
            this.x=x; this.y=y;
        }
    }
}