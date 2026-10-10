class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rev = new ArrayList<>();

        for(int i=0; i<n; i++){
            rev.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];
        for(int i=0; i<n; i++){
            outdegree[i] = graph[i].length;

            for(int neighbour : graph[i]){
                rev.get(neighbour).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(outdegree[i] == 0){
                q.offer(i);
            }
        }
        
        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int temp : rev.get(node)){
                outdegree[temp]--;

                if(outdegree[temp] == 0){
                    q.offer(temp);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}