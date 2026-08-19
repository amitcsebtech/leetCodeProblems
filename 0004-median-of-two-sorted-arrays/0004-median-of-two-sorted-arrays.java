class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int l1 = nums1.length;
        int l2 = nums2.length;

        int l = 0;
        int h = l1;

        while(l <= h){
            int mid = l + (h-l)/2;
            int p1 = mid;
            int p2 = (l1 + l2 +1)/2 - mid;

            // left part
            int x1 = (p1 == 0) ? Integer.MIN_VALUE:nums1[p1-1];
            int x2 = (p2 == 0) ? Integer.MIN_VALUE:nums2[p2-1];

            // right part
            int x3 = (p1 == l1) ? Integer.MAX_VALUE:nums1[p1];
            int x4 = (p2 == l2) ? Integer.MAX_VALUE:nums2[p2];

            if(x1 <= x4 && x2 <= x3){
                if((l1 + l2) % 2 == 1){
                    return Math.max(x1,x2);
                }

                return (Math.max(x1,x2) + Math.min(x3,x4)) / 2.0;
            }

            if(x1 > x4){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return -1;
    }
}