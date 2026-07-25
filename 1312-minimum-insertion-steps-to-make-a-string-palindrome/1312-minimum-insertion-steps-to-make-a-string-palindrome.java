class Solution {
    public int minInsertions(String s) {
        int lps = longestPalindromeSubseq(s);
        return s.length() - lps;
    }

    public int longestPalindromeSubseq(String s) {
        String a = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == a.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // move curr to prev for next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;

            Arrays.fill(curr, 0);   // Reset for next row
        }
        return prev[n];
    }
}
