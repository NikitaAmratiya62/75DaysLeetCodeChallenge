class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> s=new HashSet<>();
        for(int ele:nums){
            s.add(ele);
        }
        int prdt=k;
        while(s.contains(prdt)){
            prdt+=k;
        }

        return prdt;
    }
}