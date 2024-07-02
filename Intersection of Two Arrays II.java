class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0, j = 0, k = 0;
        while(i<a && j<b){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j])
            {
                j++;
            }
            else
            {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        int[] result = new int[k];
        for (i = 0; i < k; i++) {
        result[i] = nums1[i];
    }
    return result;
    }
}
