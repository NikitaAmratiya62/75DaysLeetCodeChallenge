class Solution {
    public long countBadPairs(int[] nums) {
    // __________BRUTE FORCE APPROACH________(TLE dega)...
    //     int count=0;
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(j-i!=nums[j]-nums[i]) count++;
    //         }
    //     }
    //     return count;

    // _________OPTIMAL APPROACH_____________
        HashMap<Integer ,Integer> map= new HashMap<>();
        long n=nums.length;
        long goodpairs=0;
        for(int i=0;i<n;i++){
            int key=nums[i]-i;
            goodpairs +=map.getOrDefault(key,0);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        long totalpairs=n*(n-1)/2;
        return totalpairs-goodpairs;
    }
}