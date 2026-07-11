class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Map<List<Integer>, Integer> freq = new HashMap<>();
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
            graph[i].add(i);
        } 
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for(int i=0; i<n; i++){
            List<Integer> neighbours = graph[i];
            Collections.sort(neighbours);
            freq.put(neighbours, freq.getOrDefault(neighbours,0)+1);
        }
        int count = 0;
        for(Map.Entry<List<Integer>, Integer> entry : freq.entrySet()){
            if(entry.getKey().size() == entry.getValue()) count++;
        }
        return count;
    }
}