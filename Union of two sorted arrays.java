class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        ArrayList<Integer> unionArray=new ArrayList<>();
        while(i<n1&&j<n2){
            if(nums1[i]==nums2[j]){
                if( unionArray.isEmpty()||unionArray.get(unionArray.size()-1)!=nums1[i]){
                    unionArray.add(nums1[i]);
                }
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]){
                 if( unionArray.isEmpty()||unionArray.get(unionArray.size()-1)!=nums1[i]){
                    unionArray.add(nums1[i]);
                }
                i++;

            }
            else {
                 if( unionArray.isEmpty()||unionArray.get(unionArray.size()-1)!=nums2[j]){
                    unionArray.add(nums2[j]);
                }
                j++;

        }
        }
        while(j<n2){

            if( unionArray.isEmpty()||unionArray.get(unionArray.size()-1)!=nums2[j]){
                    unionArray.add(nums2[j]);
                }
                j++;
        }
        while(i<n1){

            if( unionArray.isEmpty()||unionArray.get(unionArray.size()-1)!=nums1[i]){
                    unionArray.add(nums1[i]);
                }
                i++;

        }
        int[] ans = new int[unionArray.size()];
        for (int k = 0; k < unionArray.size(); k++) {
            ans[k] = unionArray.get(k);
        }
        return ans;
    }
}
