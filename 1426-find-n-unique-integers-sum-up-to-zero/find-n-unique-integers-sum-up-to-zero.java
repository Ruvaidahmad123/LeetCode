class Solution {
    public int[] sumZero(int n) {
        if(n==1){
            return new int[]{0};
        }
        int arr[]=new int[n];
        if(n%2==1){
            int k=0;
            for(int i=0;i<n-1 && k<n-1;i+=2){
                arr[i]=(n-k);
                arr[i+1]=-(n-k);
                k++;
            }
            arr[n-1]=0;
        }
        else{
            int k=0;
            for(int i=0;i<n-1 && k<n-1;i+=2){
                arr[i]=(n-k);
                arr[i+1]=-(n-k);
                k++;
            }
        }
        return arr;
    }
}