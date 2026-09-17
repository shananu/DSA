class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            sum += arr[i];

            while(sum > target){
                sum -= arr[left];
                left++;
            }

            if(sum == target){
                int len = i - left + 1;

                if(left > 0 && best[left-1] != Integer.MAX_VALUE){
                    res = Math.min(res, len + best[left-1]);
                }

                if(i == 0) best[i] = len;
                else best[i] = Math.min(best[i-1], len);
            }
            else{
                if(i > 0) best[i] = best[i-1];
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}