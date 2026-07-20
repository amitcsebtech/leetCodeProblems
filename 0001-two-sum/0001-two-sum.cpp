class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n=nums.size();
        vector<int> ans;
        unordered_map<int,int> mp;
        int firstNum,secondNum;
        for(int i=0; i<n; i++){
            firstNum=nums[i];
            secondNum=target-firstNum;
            if(mp.find(secondNum)!=mp.end()){
                ans.push_back(i);
                ans.push_back(mp[secondNum]);
                break;
            }
            mp[firstNum]=i;
        }
        return ans;
    }
};