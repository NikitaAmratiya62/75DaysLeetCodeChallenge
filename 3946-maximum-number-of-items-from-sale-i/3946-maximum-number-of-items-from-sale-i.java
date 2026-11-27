class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int reward = 1 + free[i];

            int[] activated = new int[budget + 1];
            java.util.Arrays.fill(activated, -1000000);

            for (int b = 0; b + price <= budget; b++) {
                activated[b + price] = Math.max(
                    activated[b + price],
                    dp[b] + reward
                );
            }

            for (int b = price; b <= budget; b++) {
                activated[b] = Math.max(
                    activated[b],
                    activated[b - price] + 1
                );
            }

            for (int b = 0; b <= budget; b++) {
                dp[b] = Math.max(dp[b], activated[b]);
            }
        }

        int ans = 0;
        for (int val : dp) {
            ans = Math.max(ans, val);
        }

        return ans;
    }
}