class Solution {
    public void printNumbers(int n) {
       if(n==0) return;
       printNumbers(n-1);
       System.out.println(n);
    }
}
