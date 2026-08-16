class Mycompare implements Comparator<String>{
    public int compare(String a,String b){
        if(a.length()!=b.length()) return a.length()-b.length();
        return a.compareTo(b);
    }


}
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq=new PriorityQueue<>(new Mycompare());
        for(String s:nums){
            pq.add(s);
            if(pq.size()>k) pq.remove();
        }
        return pq.peek();
    }
}