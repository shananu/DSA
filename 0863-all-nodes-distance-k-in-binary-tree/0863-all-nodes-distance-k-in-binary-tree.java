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
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        buildParent(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();

        q.offer(target);
        vis.add(target);

        int dis = 0;

        while(!q.isEmpty()){
            int size = q.size();

            if(dis == k){
                break;
            }

            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                TreeNode par = parentMap.get(cur);
                
                if (par != null && !vis.contains(par)) {
                    vis.add(par);
                    q.offer(par);
                }

                if(cur.left != null && !vis.contains(cur.left)){
                    vis.add(cur.left);
                    q.offer(cur.left);
                }

                if(cur.right != null && !vis.contains(cur.right)){
                    vis.add(cur.right);
                    q.offer(cur.right);
                }
            }

            dis++;
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }

        return res;
    }

    private void buildParent(TreeNode node, TreeNode par){
        if(node == null){
            return;
        }

        parentMap.put(node, par);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}