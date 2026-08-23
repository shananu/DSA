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
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if(root == null) return res;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
//         boolean ltor = true;

//         while(!q.isEmpty()){
//             Deque<Integer> list = new LinkedList<>();
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 TreeNode curr = q.poll();
//                 if(ltor) list.offerLast(curr.val);
//                 else list.offerFirst(curr.val);

//                 if(curr.left != null) q.offer(curr.left);
//                 if(curr.right != null) q.offer(curr.right);
//             }
//             res.add(new ArrayList<>(list));
//             ltor = !ltor;
//         }
//         return res;
//     }
// }

// another approach 
// we can just get the level order traversal and then reverse the alternative lists

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            list.add(level);
        }

        for(int i=0; i<list.size(); i++){
            if(i % 2 == 1) Collections.reverse(list.get(i));
        }

        return list;
    }
}