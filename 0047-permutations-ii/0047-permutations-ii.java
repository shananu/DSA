class Solution{
    public List<List<Integer>> permuteUnique(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        solve(arr,nums,used,ans);
        return ans;
    }

    public void solve(List<Integer> arr,int[] nums,boolean[] used,List<List<Integer>> ans){
        if(arr.size()==nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }

            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }

            used[i]=true;
            arr.add(nums[i]);

            solve(arr,nums,used,ans);

            arr.remove(arr.size()-1);
            used[i]=false;
        }
    }
}