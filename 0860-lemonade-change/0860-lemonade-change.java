class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for(int b : bills){
            if(b == 5) five++;
            else if(b == 10){
                if(five == 0) return false;
                ten++;
                five--;
            }
            else{
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }
                else if(five >= 3) five = five - 3;
                else return false;
            }
        }
        
        return true;
    }
}