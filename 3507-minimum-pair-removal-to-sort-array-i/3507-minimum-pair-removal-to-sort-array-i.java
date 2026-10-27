
class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;
        while (!isSorted(nums)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            nums[index] = minSum;
            int[] newNums = new int[nums.length - 1];
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (i != index + 1) {
                    newNums[j++] = nums[i];
                }
            }
            nums = newNums;
            operations++;
        }
        return operations;
    }
    private boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
