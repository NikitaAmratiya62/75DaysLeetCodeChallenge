class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] ans=new int[n];
        int idx=0;
        while(!map.isEmpty()){
            for(int key : new ArrayList<>(map.keySet())){
                ans[idx++]=key;
                if(map.get(key)==1){
                    map.remove(key);
                }
                else{
                    map.put(key,map.get(key)-1);
                }
            }
            
        }
        return ans;
    }
}