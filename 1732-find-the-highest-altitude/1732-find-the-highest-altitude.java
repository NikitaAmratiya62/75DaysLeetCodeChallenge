class Solution {
    public int largestAltitude(int[] gain) {
        int altitude=0;
        int maxaltitude=0;
        for(int i=0;i<gain.length;i++){
            altitude+=gain[i];
            maxaltitude =Math.max(maxaltitude,altitude);
        }
        return maxaltitude;
    }
}