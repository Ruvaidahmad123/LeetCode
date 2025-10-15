class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] leftinc = new int[n];
        int[] rightinc = new int[n];
        leftinc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                leftinc[i] = leftinc[i - 1] + 1;
            } else {
                leftinc[i] = 1;
            }
        }
        rightinc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                rightinc[i] = rightinc[i + 1] + 1;
            } else {
                rightinc[i] = 1;
            }
        }
        int ansk = 0;
        for (int i = 0; i < n - 1; i++) {
            int leftlen = leftinc[i];
            int rightlen = rightinc[i + 1];
            int k = Math.min(leftlen, rightlen);
            ansk = Math.max(ansk, k);
        }
        return ansk;
    }
}
