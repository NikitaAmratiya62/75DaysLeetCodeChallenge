class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int moves = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int num : nums) {
            moves += max-num;
        }
        return moves;
    }
}