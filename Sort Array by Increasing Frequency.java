class Solution {
    public int[] frequencySort(int[] nums) {
        int a[] = new int[201];
        for (int n : nums)  
            a[n + 100]++;
        int k = 0;
        for (int i=nums.length-1;i>=0;) {
            int m=0, d=-1;
            for (int j=0;j<201;j++) {
                if (a[j]>m) {
                    m=a[j];
                    d=j;
                }
            }
            for (int j=0;j<m;j++)  
                nums[i--] = d-100;
                a[d] = 0;
        }
        return nums;
    }
}
