class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int i;
        for(i=1; i<=nums.length; i++){
            int d = k * i;
            if(!set.contains(d)) break;
        }
        return k * i;
    }
}