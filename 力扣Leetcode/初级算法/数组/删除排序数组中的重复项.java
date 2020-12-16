class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
            for(int i=1;i<nums.length;i++){//这里他题目给的是排序数组 所以我们选择使用双指针,
                if(nums[count]!=nums[i]){//如果后面的和前面一样,那么就不管
                    count++;  //  让后面的+1,因为不一样,所以指针向前
                    nums[count]=nums[i];//把前面的赋值给后面的,这样排序依旧是对的
                }//如果他们一样,那么前指针自动向前增加,直到碰见不一样的,把那个值放入后指针下一个位置
            }
            return count+1;//返回的是数量
    }
}