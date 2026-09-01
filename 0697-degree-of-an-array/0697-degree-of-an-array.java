class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        
        int degree = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            degree = Math.max(degree, freq.get(nums[i]));
        }

        for (int num : freq.keySet()) {

            if (freq.get(num) == degree) {

                int length = nums.length - first.get(num);

                int last = 0;

                for (int i = nums.length - 1; i >= 0; i--) {
                    if (nums[i] == num) {
                        last = i;
                        break;
                    }
                }

                length = last - first.get(num) + 1;

                ans = Math.min(ans, length);
            }
        }

        return ans;
    }
}