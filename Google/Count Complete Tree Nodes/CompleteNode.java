/*
 * Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.
 */


public class CompleteNode {
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
    public int countNodes(TreeNode root) {
        if(root == null)
        return 0;
        TreeNode curLeft = root.left;
        TreeNode curRight = root.right;
        int num = 1;
        while(curRight != null)
        {
            curLeft = curLeft.left;
            curRight = curRight.right;
            num = (num<<1)+1;
        }
        /*
         *  The signed left shift operator "<<" shifts a bit pattern to the left
            The signed right shift operator ">>" shifts a bit pattern to the right.
            The unsigned right shift operator ">>>" shifts a zero into the leftmost position
         */
        return ((curLeft == null) ?  num : 1+countNodes(root.right)+countNodes(root.left));
    }
}
