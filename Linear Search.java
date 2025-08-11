class Solution {
    public int linearSearch(int nums[], int target) {
        // int count =0;
		for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                // count++;
                return i;
            }
        }
        return -1;
    }
}
