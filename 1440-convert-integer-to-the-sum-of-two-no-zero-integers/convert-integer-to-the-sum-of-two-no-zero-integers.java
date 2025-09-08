class Solution {
    public int[] getNoZeroIntegers(int n) {
        int i=1;
        int j=n-1;
        int arr[]=new int[2];
        while(i<=j){
            String first=i+"";
            String second=j+"";
            if(first.indexOf('0')!=-1 || second.indexOf('0')!=-1){
                i++;
                j--;
            }
            else{
                arr[0]=i;
                arr[1]=j;
                break;
            }
        }
        return arr;
    }
}