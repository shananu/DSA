class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i=0; i<n-1; i++){
            if(ratings[i] < ratings[i+1]) candies[i+1] = 1 + candies[i];
        }

        for(int i=n-1; i>= 1; i--){
            if(ratings[i] < ratings[i-1]) 
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1); 
        }

        int count = 0;
        for(int i : candies){
            count += i;
        }

        return count;
    }
}