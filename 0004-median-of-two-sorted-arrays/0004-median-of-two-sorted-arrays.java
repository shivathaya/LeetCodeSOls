class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int merg[] = new int[nums1.length + nums2.length];

        int i =0, j=0, k=0;

        while(i<nums1.length && j< nums2.length){
            if(nums1[i] < nums2[j]){
                merg[k++] = nums1[i++];
            }
            else{
                merg[k++] = nums2[j++];
            }
        }

        while(i<nums1.length)
            merg[k++] = nums1[i++];
        while(j < nums2.length)
            merg[k++] = nums2[j++];
        int n = merg.length;

        if(n%2 == 1) 
            return merg[n/2];
        else
            return (merg[n/2 -1]+merg[n/2])/2.0;

    }
}