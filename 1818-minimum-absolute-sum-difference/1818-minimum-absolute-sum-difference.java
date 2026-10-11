import java.util.*;
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int MOD = 1_000_000_007;
        int[] arr = nums1.clone();
        Arrays.sort(arr);
        long sum = 0;
        long maxReduction = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum += diff;
            int idx = lowerBound(arr, nums2[i]);
            if (idx < n) {
                int newDiff = Math.abs(arr[idx] - nums2[i]);
                maxReduction = Math.max(maxReduction, (long) diff - newDiff);
            }
            if (idx > 0) {
                int newDiff = Math.abs(arr[idx - 1] - nums2[i]);
                maxReduction = Math.max(maxReduction, (long) diff - newDiff);
            }
        }
        return (int) ((sum - maxReduction) % MOD);
    }
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
