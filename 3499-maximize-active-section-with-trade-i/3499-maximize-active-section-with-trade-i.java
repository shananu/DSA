import java.util.*;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int base = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') base++;
        }

        // Augment the string
        String t = "1" + s + "1";

        List<Character> chars = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();

        // Run Length Encoding
        char curr = t.charAt(0);
        int len = 1;

        for (int i = 1; i < t.length(); i++) {
            if (t.charAt(i) == curr) {
                len++;
            } else {
                chars.add(curr);
                lens.add(len);

                curr = t.charAt(i);
                len = 1;
            }
        }

        // Store last run
        chars.add(curr);
        lens.add(len);

        int maxGain = 0;

        // Look for 0-run, 1-run, 0-run
        for (int i = 1; i < chars.size() - 1; i++) {
            if (chars.get(i) == '1' && chars.get(i - 1) == '0' && chars.get(i + 1) == '0') {

                int gain = lens.get(i - 1) + lens.get(i + 1);
                maxGain = Math.max(maxGain, gain);
            }
        }

        return base + maxGain;
    }
}