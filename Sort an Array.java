class Solution {
    public int[] sortArray(int[] n) {
        sort(n, 0, n.length-1);
        return n;
    }
    private void sort(int[] n, int l, int r){
        if(l==r)return;
        int m = (l+r)/2;
        sort(n,l,m); sort(n,m+1,r);
        int[] x = new int[r-l+1];
        int li=l, ri=m+1;
        for(int i=0; i<x.length; i++){
            if(ri>r)x[i]=n[li++];
            else if(li>m)x[i]=n[ri++];
            else if(n[li]<=n[ri])x[i]=n[li++];
            else x[i]=n[ri++];
        }
        for(int i=0; i<x.length; i++)n[l+i]=x[i];
    }
}
