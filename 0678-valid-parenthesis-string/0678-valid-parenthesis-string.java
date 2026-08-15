// class Solution {
//     public boolean checkValidString(String s) {
//         return f(s, 0, 0);
//     }

//     private boolean f(String s, int i, int count){
//         if(count < 0) return false;
//         if(i == s.length()) return count == 0;

//         if(s.charAt(i) == '(') return f(s, i+1, count+1);
//         else if(s.charAt(i) == ')') return f(s, i+1, count-1);
//         else return f(s, i+1, count) || f(s, i+1, count+1) || f(s, i+1, count-1);
//     }
// }

class Solution{
    public boolean checkValidString(String s){
        int min = 0, max = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                min++;
                max++;
            }
            else if(c == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(max < 0) return false;
            if(min < 0) min = 0; 
        }

        return min == 0;
    }
}