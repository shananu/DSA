class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);

        int x = 0;
        int sum = 0;

        for (char c : s.toCharArray()) {
            if (c != '0') {
                int digit = c - '0';
                x = x * 10 + digit;
                sum += digit;
            }
        }

        return (long) x * sum;
    }
}