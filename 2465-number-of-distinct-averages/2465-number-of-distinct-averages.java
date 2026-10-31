class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Float> set= new HashSet<>();
        int n=nums.length;
        Arrays.sort(nums);
        int left=0;
        int right=n-1;
        while(left<right){
            float avg=(nums[left++]+nums[right--])/2.0f;
            set.add(avg);
        }
        return set.size();
    }
}