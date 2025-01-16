class Solution {
    static int div = 1234567;
    static int dp[];
    public long solution(int n) {
        dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % div;
        }
        return dp[n] % div;
    }
}