class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        
        if(nums.length < 4) return false;
        if(sum%4 != 0) return false;

        Arrays.sort(nums);
        return dfs(nums, 0, sum/4, 0, 1, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int pos, int target, int tmpSum, int sides, boolean[] visited) {
        if(sides ==  4) return true;
        if(tmpSum == target) return dfs(nums, 0, target, 0, sides+1, visited);
        if(tmpSum > target) return false;

        for(int i = pos; i < nums.length; i++) {
            if(visited[i]) continue;
            
            
            visited[i] = true;
            if(dfs(nums, i+1, target, tmpSum + nums[i], sides, visited)) return true;
            visited[i] = false;
        }
        return false;
    }
}