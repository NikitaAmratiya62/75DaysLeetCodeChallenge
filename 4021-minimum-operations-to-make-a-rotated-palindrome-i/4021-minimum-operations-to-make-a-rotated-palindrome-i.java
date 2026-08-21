class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            int operations = k;
            for (int i = 0; i < n / 2; i++) {
                int a = s.charAt((i + k) % n) - 'a';
                int b = s.charAt((n - 1 - i + k) % n) - 'a';
                int diff = Math.abs(a - b);
                operations += Math.min(diff, 26 - diff);
            }
            ans = Math.min(ans, operations);
        }
        return ans;
    }
}