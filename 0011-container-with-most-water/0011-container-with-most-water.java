class Solution {
    public int maxArea(int[] heigh) {
        int left = 0;
        int right = heigh.length - 1;
        int maxWater = 0;

        while(left < right) {
            int h = Math.min(heigh[left], heigh[right]);
            int width = right - left;
            int area = h * width;

            maxWater = Math.max(maxWater, area);

            if(heigh[left] < heigh[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
