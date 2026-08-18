class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;

            // Find the smallest element greater than nums[i] from the right
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        // Reverse the suffix starting at i + 1
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
