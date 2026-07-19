class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            last[ch - 'a'] = i;
        }
       
        boolean[] vis = new boolean[26];
        ArrayDeque<Character> deque = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(vis[ch - 'a']) continue;
            
            while(!deque.isEmpty() && deque.peek()> ch && last[deque.peek() - 'a'] > i) {
                vis[deque.peek() - 'a'] = false;
                deque.pop();
            }

            deque.push(ch);
            vis[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) ans.append(deque.pop());
        return ans.reverse().toString();
    }
}