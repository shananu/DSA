class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int maxIndex = -1;
        int minIndex = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(nums[i] < min){
                min = nums[i];
                minIndex = i;
            }

            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }

        int left = Math.max(minIndex, maxIndex) + 1;
        int right = n - Math.min(minIndex, maxIndex);
        int bothSides = Math.min(minIndex, maxIndex) + 1 + n - Math.max(minIndex, maxIndex);

        return Math.min(left, Math.min(right, bothSides));
    }
}