import java.util.*;
class Solution {
    class MedianWindow {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;
        void add(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        void remove(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);
            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }
        void insert(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                add(left, val);
                leftSum += val;
                leftSize++;
            } else {
                add(right, val);
                rightSum += val;
                rightSize++;
            }
            balance();
        }
        void erase(int val) {
            if (left.containsKey(val)) {
                remove(left, val);
                leftSum -= val;
                leftSize--;
            } else {
                remove(right, val);
                rightSum -= val;
                rightSize--;
            }
            balance();
        }
        void balance() {
            while (leftSize > rightSize + 1) {
                int val = left.lastKey();
                remove(left, val);
                add(right, val);
                leftSum -= val;
                rightSum += val;
                leftSize--;
                rightSize++;
            }
            while (leftSize < rightSize) {
                int val = right.firstKey();
                remove(right, val);
                add(left, val);
                rightSum -= val;
                leftSum += val;
                rightSize--;
                leftSize++;
            }
        }
        long getCost() {
            int median = left.lastKey();
            return (long) median * leftSize - leftSum
                    + rightSum - (long) median * rightSize;
        }
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        MedianWindow window = new MedianWindow();
        for (int i = 0; i < x; i++) {
            window.insert(nums[i]);
        }
        cost[0] = window.getCost();
        for (int start = 1; start <= n - x; start++) {
            window.erase(nums[start - 1]);
            window.insert(nums[start + x - 1]);
            cost[start] = window.getCost();
        }
        long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            Arrays.fill(curr, INF);
            for (int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];
                if (i >= x) {
                    int start = i - x;
                    if (prev[start] != INF) {
                        long pick = prev[start] + cost[start];
                        curr[i] = Math.min(curr[i], pick);
                    }
                }
            }
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n];
    }
}
