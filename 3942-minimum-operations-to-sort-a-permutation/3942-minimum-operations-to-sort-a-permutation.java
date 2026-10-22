
import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        int k1 = zero;
        boolean valid1 = true;

        for (int i = 0; i < n; i++) {
            if (nums[(k1 + i) % n] != i) {
                valid1 = false;
                break;
            }
        }

        int k2 = (n - 1 - zero + n) % n;
        boolean valid2 = true;

        for (int i = 0; i < n; i++) {
            int idx = n - 1 - ((k2 + i) % n);
            if (nums[idx] != i) {
                valid2 = false;
                break;
            }
        }

        if (!valid1 && !valid2) {
            return -1;
        }

        int[][] dist = new int[2][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int rev = cur[0];
            int k = cur[1];
            int d = dist[rev][k];

            if (valid1 && rev == 0 && k == k1) {
                return d;
            }

            if (valid2 && rev == 1 && k == k2) {
                return d;
            }

            int nk = (k + 1) % n;
            if (dist[rev][nk] == -1) {
                dist[rev][nk] = d + 1;
                q.offer(new int[]{rev, nk});
            }

            int nr = 1 - rev;
            nk = (n - k) % n;

            if (dist[nr][nk] == -1) {
                dist[nr][nk] = d + 1;
                q.offer(new int[]{nr, nk});
            }
        }

        return -1;
    }
}
