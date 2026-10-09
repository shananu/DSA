
class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> freq1;
    Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        freq1 = new HashMap<>();
        freq2 = new HashMap<>();

        for (int num : nums1) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;

        // Remove the old value's frequency
        freq2.put(oldVal, freq2.get(oldVal) - 1);

        // Add the new value's frequency
        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);

        nums2[index] = newVal;
    }

    public int count(int tot) {
        int res = 0;

        for (Map.Entry<Integer, Integer> entry : freq1.entrySet()) {
            int num1 = entry.getKey();
            int count1 = entry.getValue();

            int complement = tot - num1;

            res += count1 * freq2.getOrDefault(complement, 0);
        }

        return res;
    }
}
