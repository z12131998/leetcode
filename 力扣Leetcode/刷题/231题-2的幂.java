/*
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
    return (n&(n-1))==0;
    }
}