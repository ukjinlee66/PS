class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = count_one(n);
        for(int i=n+1;i<=n*2;i++){
            if(count_one(i) == cnt)
                return i;
        }
        return -1;
    }
    
    public int count_one(int num) {
        int cnt = 0;
        while(num>0) {
            num &= num-1;
            cnt++;
        }
        return cnt;
    }
}