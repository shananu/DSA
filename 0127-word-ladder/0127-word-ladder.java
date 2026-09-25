class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if(!words.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer(beginWord);
        vis.add(beginWord);

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                String cur = q.poll();

                if(cur.equals(endWord)){
                    return level;
                }

                for(int j=0; j<cur.length(); j++){
                    char[] s = cur.toCharArray();

                    for(char c='a'; c<='z'; c++){
                        s[j] = c;
                        String next = new String(s);

                        if(words.contains(next) && !vis.contains(next)){
                            vis.add(next);
                            q.offer(next);
                        }
                    }
                }
                

            }
            level++;
        }

        return 0;
    }
}