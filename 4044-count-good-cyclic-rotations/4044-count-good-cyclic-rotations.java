class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int h = n / 2;

        long total = 0;
        long first = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];

            if (i < h) {
                first += nums[i];
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {

            long last = total - first;

            if (first > last) {
                count++;
            }
            first = first - nums[i] + nums[(i + h) % n];
        }

        return count;
    }
}