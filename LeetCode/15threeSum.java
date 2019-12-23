class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            //不遍历重复的情况，并且避免了i=0时数组越界的情况！
            if(i == 0 || nums[i] != nums[i-1]) {
                int sum = 0 - nums[i], lo = i + 1, hi = nums.length - 1;
                while(lo < hi) {
                    if(nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    } else if(nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
