class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int even = 1;
        int odd = 0;
        int prefix = 0;
        long ans = 0;
        for (int num : arr) {
            prefix += num;
            if (prefix % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }
            ans %= mod;
        }
        return (int) ans;
    }
}
