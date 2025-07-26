class Solution {
    public void reverse(int[] arr, int n) {
      reverseHelper(arr,0,n-1);
    }
    private void reverseHelper(int[] arr,int start,int end){
        if(start>=end) return;
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        reverseHelper(arr,start+1,end-1);
    }
}



