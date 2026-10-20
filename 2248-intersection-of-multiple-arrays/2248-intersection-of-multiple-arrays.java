class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int num:nums[0]){
            boolean found=true;
            for(int i=1;i<nums.length;i++){
                boolean present=false;
                for(int x:nums[i]){
                    if(x==num){
                        present=true;
                        break;
                    }
                }
                if(!present){
                    found=false;
                    break;
                }
            }
            if(found && !ans.contains(num)) ans.add(num);
        }
        Collections.sort(ans);
        return ans;
    }
}