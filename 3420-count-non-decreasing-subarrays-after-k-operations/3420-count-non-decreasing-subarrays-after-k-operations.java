class Solution {
    public long countNonDecreasingSubarrays(int[] nums, long k) {
        int n = nums.length;
        int LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[] next = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && nums[stack[top]] <= nums[i]) {
                top--;
            }

            next[i] = top == -1 ? n : stack[top];
            stack[++top] = i;
        }

        int[][] up = new int[LOG][n];
        long[][] sum = new long[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = next[i];
            sum[0][i] = (long) nums[i] * (next[i] - i);
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int mid = up[j - 1][i];

                if (mid < n) {
                    up[j][i] = up[j - 1][mid];
                    sum[j][i] = sum[j - 1][i] + sum[j - 1][mid];
                } else {
                    up[j][i] = n;
                    sum[j][i] = sum[j - 1][i];
                }
            }
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long answer = 0;

        for (int l = 0; l < n; l++) {
            int low = l;
            int high = n - 1;
            int best = l - 1;

            while (low <= high) {
                int r = low + (high - low) / 2;

                int cur = l;
                long maxSum = 0;

                for (int j = LOG - 1; j >= 0; j--) {
                    if (up[j][cur] <= r) {
                        maxSum += sum[j][cur];
                        cur = up[j][cur];
                    }
                }

                maxSum += (long) nums[cur] * (r - cur + 1);

                long operations = maxSum - (prefix[r + 1] - prefix[l]);

                if (operations <= k) {
                    best = r;
                    low = r + 1;
                } else {
                    high = r - 1;
                }
            }

            answer += best - l + 1;
        }

        return answer;
    }
}
