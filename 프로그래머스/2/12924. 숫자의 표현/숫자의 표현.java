import java.util.*;
class Solution {
    static int ans;
    public int solution(int n) {
        ans = 0;
        int s=1; int e=1; int sum = 0;
        while(true) {
            if (sum >= n){
                if(sum == n)
                    ans++;
                sum-=s++;
            }
            else {
                if(e > n) break;
                sum+=e++;
            }
        }
        return ans;
    }
}