class Solution {
    String res = "";
    public String lexPalindromicPermutation(String s, String target) {
        
        char[] freq = new char[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
                
        boolean odd = false;
        char oddChar = '\0';
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(freq[ch - 'a'] % 2 != 0 && odd) return "";
            else if(freq[ch - 'a'] % 2 != 0){
                oddChar = ch;
                odd = true;
            }
        }

        for(int i=0; i<26; i++) freq[i] /= 2;

        StringBuilder cur = new StringBuilder();
        boolean r = solve(freq, target, s.length()/2, cur, 0, false, oddChar);
        return res;
    }

    private boolean solve(char[] freq, String target, int halfLength, StringBuilder cur, int i, boolean greater, char oddChar){
        
        if(i == halfLength){
            String left = cur.toString();
            String right = new StringBuilder(cur).reverse().toString();
            String temp;
            
            if(oddChar == '\0') temp = left + right;
            else temp = left + oddChar + right;

            if(temp.compareTo(target) > 0){
                res = temp;
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
            if(solve(freq, target, halfLength, cur, i+1, isGreater, oddChar)) return true;

            cur.deleteCharAt(cur.length() - 1);;
            freq[c-'a']++;
        }

        return false;
    }
}