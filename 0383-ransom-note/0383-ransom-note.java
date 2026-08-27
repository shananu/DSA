// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         int n = ransomNote.length();
//         int m = magazine.length();

//         if(n > m) return false;

//         Map<Character, Integer> map1 = new HashMap<>();
//         for(int i=0; i<n; i++){
//             char ch = ransomNote.charAt(i);
//             map1.put(ch, map1.getOrDefault(ch, 0) + 1);
//         }
//         Map<Character, Integer> map2 = new HashMap<>();
//         for(int i=0; i<m; i++){
//             char ch = magazine.charAt(i);
//             map2.put(ch, map2.getOrDefault(ch, 0) + 1);
//         }

//         for(char c : map1.keySet()){
//             if(map2.getOrDefault(c, 0) < map1.get(c)) return false;
//         }

//         return true;
//     }
// }


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                return false;
            }
            freq[c - 'a']--;
        }

        return true;
    }
}