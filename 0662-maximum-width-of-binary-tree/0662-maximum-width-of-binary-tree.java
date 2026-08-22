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
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
       
        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().num;
            int first = 0, last = 0;
           
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int index = curr.num - minIndex;

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (curr.node.left != null) q.offer(new Pair(curr.node.left, 2 * index));
                if (curr.node.right != null) q.offer(new Pair(curr.node.right, 2 * index + 1));
            }

            res = Math.max(res, last - first + 1);
        }
        
        return res;
    }
}