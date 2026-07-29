class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // here in if condition i save our time that is avoid merge algo
        if(n1 == 0){
            if(n2%2 == 0){
                return (nums2[n2/2] + nums2[n2/2-1])/2.0;
            }
            else{
                return nums2[n2/2];
            }
        }

        if(n2 == 0){
            if(n1%2 == 0){
                return (nums1[n1/2] + nums1[n1/2-1])/2.0;
            }
            else{
                return nums1[n1/2];
            }
        }

        // i apply merge algo but not using extra space only maintain prev and curr value of array only because at the end i only need these two value

        int mid = (n1+n2)/2;
        int idx = 0;
        int prev = -1;
        int curr = -1;
        int l1 = 0;
        int l2 = 0;

        // merging algorithm
        while(l1 < n1 && l2 < n2 && idx <= mid){
            if(nums1[l1] <= nums2[l2]){
                prev = curr;
                curr = nums1[l1];
                l1++;
            }
            else{
                prev = curr;
                curr = nums2[l2];
                l2++;
            }
            idx++;
        }

        // if first array contain some element but idx not reached to mid
        while(l1 < n1  && idx <= mid){
            prev = curr;
            curr = nums1[l1];
            l1++;
            idx++;
        }
        // if second array contain some element but idx not reached to mid
        while(l2 < n2 && idx <= mid){
            prev = curr;
            curr = nums2[l2];
            l2++;
            idx++;
        }

        // if size if odd then curr value point to mid 
        if((n1+n2) % 2 != 0) return curr;

        // if size is even then i need prev value also
        return (prev + curr) / 2.0;
    }
}