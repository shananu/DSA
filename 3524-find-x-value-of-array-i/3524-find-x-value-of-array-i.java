class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at the
        // previous index whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            int value = num % k;

            // Start a new subarray with nums[i]
            next[value]++;

            // Extend every subarray that ended at i - 1
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0)
                    continue;

                int newRemainder = (int) ((long) r * value % k);

                next[newRemainder] += dp[r];
            }

            // All subarrays ending at current index
            // contribute to the final answer
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}