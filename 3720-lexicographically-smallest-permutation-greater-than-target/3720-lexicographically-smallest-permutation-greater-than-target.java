class Solution {
    String res = "";
    public String lexGreaterPermutation(String s, String target) {
        char[] freq = new char[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder cur = new StringBuilder();
        boolean r = solve(s, freq, target, cur, 0, false);
        return res;
    }

    private boolean solve(String s, char[] freq, String target, StringBuilder cur, int i, boolean greater){
        if(i == target.length()){
            if(greater){
                res = cur.toString();
                return true;
            }
            return false;
        }

        for(char c = 'a'; c <= 'z'; c++){
            if(freq[c-'a'] == 0) continue;
            if(!greater && c < target.charAt(i)) continue;

            cur.append(c);
            freq[c-'a']--;

            boolean isGreater = greater || c > target.charAt(i);
            if(solve(s, freq, target, cur, i+1, isGreater)) return true;

            cur.deleteCharAt(cur.length() - 1);;
            freq[c-'a']++;
        }

        return false;
    }
}